package io.u2ware.ocpp.core;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.ClassUtils;

public abstract class OCPPOperations {
    
    protected final Log logger = LogFactory.getLog(getClass());


    protected OCPPConversion conversion = new OCPPConversion();
    protected OCPPOperations(){}

    private Map<String, OCPPIdentifier> identifiers = new HashMap<>();

    public abstract String name();
    public abstract boolean isServer();
    public abstract boolean isClient();
    public abstract OCPPVersion version();
    public abstract OCPPReflection usecase(String source); //name is usecase or messageId....

    protected abstract String requestType(String source);
    protected abstract String responseType(String source);
    protected abstract String errorType(String source);
    protected abstract String usecaseType(String source);

    public Class<?> requestClass(String source) {
        return OCPPReflection.invokeType(requestType(source));
    }
    public Class<?> responseClass(String source) {
        return OCPPReflection.invokeType(responseType(source));
    }
    public Class<?> errorClass(String source) {
        return OCPPReflection.invokeType(errorType(source));
    }
    public Class<?> usecaseClass(String source){
        return OCPPReflection.invokeType(usecaseType(source));
    }

    public boolean isRequest(String source, Object target) {
        return ClassUtils.isAssignableValue(requestClass(source), target);
    }
    public boolean isResponse(String source, Object target) {
        return ClassUtils.isAssignableValue(responseClass(source), target);
    }
    public boolean isError(String source, Object target) {
        return ClassUtils.isAssignableValue(errorClass(source), target);
    }
    public boolean isUsecase(String source, Object target) {
        return ClassUtils.isAssignableValue(usecaseClass(source), target);
    }

    ///////////////////////////////////////////////////////
    //
    ///////////////////////////////////////////////////////
    // protected void offer(Supplier<String> source, OCPPConsumer<String> consumer) {

    //     final AtomicReference<Long> start = new AtomicReference<>(System.currentTimeMillis());

    //     CompletableFuture.supplyAsync(
    //         source

    //     ).whenCompleteAsync((usecase, err)->{

    //         if(err != null) {
    //             String r = "failure";
    //             long d = System.currentTimeMillis() - start.get();
    //             Throwable t = err.getCause();

    //             String x = String.format("%s offer(%s) %s. [%d]ms.", name(), "supplier", r, d);
    //             logger.info(x, t);
    //             consumer.accept(null, err != null ? err.getCause() : null);

    //         }else {
    //             offer(usecase, (t, u)->{
    //                 String result = t != null ? conversion.convertMessage(t) : null;
    //                 consumer.accept(result, u);
    //             });
    //         }
    //     });
    // }

    protected void offer(Supplier<OCPPAction> source, OCPPConsumer<OCPPMessage<?>> consumer)  {

        final AtomicReference<Long> start = new AtomicReference<>(System.currentTimeMillis());
        final AtomicReference<String> idRef = new AtomicReference<>();

        CompletableFuture.supplyAsync(source).thenApplyAsync(m->{

            if(m == null) {
                String x = String.format("%s offer(%s) '%s' action is not found.", name(), null, null);
                throw new RuntimeException(x);
            }

            String id = m.getIdentifier(); 
            String usecase = m.getUsecase();
            String action = m.getAction();
            Object attrs = m.getAttributes();
            idRef.set(id);

            // String x = String.format("%s offer(%s) started.", name(), id);
            // logger.info(x);

            OCPPReflection offer = usecase(usecase);
            if(offer == null) {
                offer = usecase(action);
            }
            if(offer == null) {
                String x = String.format("%s offer(%s) '%s' reflection is not found.", name(), id, action);
                throw new RuntimeException(x);
            }
            Object payload = offer.sendRequest(action, id, attrs);
            if(payload == null) {
                String x = String.format("%s offer(%s) '%s' reflection return null payload", name(),  action);
                throw new RuntimeException(x);
            }
            Call<Object> cc = new Call<>();
            cc.setId(id);
            cc.setAction(action);
            cc.setPayload(payload);



            identifiers.put(id, new OCPPIdentifier(usecase, action, id)); // for call result 
            return cc;
        })
        .whenCompleteAsync((m,e)->{
            consumer.accept(m, e != null ? e.getCause() : null);
        })
        .whenCompleteAsync((m,e)->{
            String id = idRef.get(); 
            String r = e == null ? "success" : "failure";
            long d = System.currentTimeMillis() - start.get();
            Throwable t = e != null ? e.getCause() : null;

            String x = String.format("%s offer(%s) %s. [%d]ms.", name(), id, r, d);
            logger.info(x, t);
        })
        ;
    }


    ///////////////////////////////////////////////////////
    //
    ///////////////////////////////////////////////////////
    public void answer(OCPPMessage<?> source, OCPPConsumer<OCPPMessage<?>> consumer){

        final AtomicReference<Long> start = new AtomicReference<>(System.currentTimeMillis());
        final AtomicReference<String> idRef = new AtomicReference<>();
        final AtomicReference<OCPPReflection> callReflectionRef = new AtomicReference<>();
        final AtomicReference<Call<?>> callMessageRef = new AtomicReference<>();

        CompletableFuture.supplyAsync(()->{

            if(CallType.Call.correct(source)){

                Call<?> cc = (Call<?>)source;
                String id = cc.getId();
                String action = cc.getAction();
                idRef.set(id);

                // String x = String.format("%s answer(%s) started.", name(), id);
                // logger.info(x);

                OCPPReflection answer = usecase(id);
                if(answer == null) {
                    answer = usecase(action);
                }
                if(answer == null) {
                    String x = String.format("%s answer(%s) '%s' reflection is not found.", name(), id, action);
                    throw new RuntimeException(x);
                }
               

                Object payload = conversion.convertPayload(cc.getPayload(), requestClass(action));
                if(! isRequest(action, payload)) {
                    String x = String.format("%s answer(%s) '%s' reflection request is not supported.", name(), id, action);
                    throw new RuntimeException(x);
                }

                callMessageRef.set(cc);
                callReflectionRef.set(answer);

                try{
                    Object response = answer.receivedRequest(action, id, payload);

                    CallResult<Object> cr = new CallResult<>();
                    cr.setId(id);
                    cr.setPayload(response);
                    return cr;

                }catch(Exception e){
                    if(! isError(action, e.getCause())) throw e;

                    CallError<CallException> ce = new CallError<>();
                    ce.setId(id);
                    ce.setPayload((CallException)e.getCause());
                    return ce;
                }

            }else if(CallType.CallResult.correct(source)){

                CallResult<?> cr = (CallResult<?>)source;
                String id = cr.getId();
                idRef.set(id);

                OCPPIdentifier identifier = identifiers.remove(id);
                String usecase = (identifier != null) ? identifier.getUsecase() : cr.getId();
                String action = (identifier != null) ? identifier.getAction() : cr.getId();

                OCPPReflection offer = usecase(usecase);
                if(offer == null) {
                    String x = String.format("%s answer(%s) '%s' reflection is not found.", name(), id, action);
                    throw new RuntimeException(x);
                }

                Object payload = conversion.convertPayload(cr.getPayload(), responseClass(action));
                if(! isResponse(action, payload)) {
                    String x = String.format("%s answer(%s) '%s' reflection response is not supported.", name(), id, action);
                    throw new RuntimeException(x);
                }

                offer.receivedResponse(action, id, payload, null);
                return null;

            }else if(CallType.CallError.correct(source)){

                CallError<?> ce = (CallError<?>)source;
                String id = ce.getId();
                idRef.set(id);                

                OCPPIdentifier identifier = identifiers.remove(id);
                String usecase = (identifier != null) ? identifier.getUsecase() : ce.getId();
                String action = (identifier != null) ? identifier.getAction() : ce.getId();

                OCPPReflection offer = usecase(usecase);
                if(offer == null) {
                    String x = String.format("%s answer(%s) '%s' reflection is not found.", name(), id, action);
                    throw new RuntimeException(x);
                }
                
                if(! isError(action, ce.getPayload())) {
                    String x = String.format("%s answer(%s) '%s' reflection errorCode is not supported.", name(), id, action);
                    throw new RuntimeException(x);
                }

                offer.receivedResponse(action, id, null, ce.getPayload());
                return null;
            }else{
                throw new RuntimeException("message type is not supported.");
            }
        })
        .whenCompleteAsync((m,e)->{
            consumer.accept(m, e != null ? e.getCause() : null);
        })
        .whenCompleteAsync((m,e)->{

            if(CallType.Call.correct(m)){

            }else if(CallType.CallResult.correct(m)){

                Call<?> cc = callMessageRef.get();
                OCPPReflection answer = callReflectionRef.get();
                CallResult<?> cr = (CallResult<?>)m;
                
                answer.sendResponse(cc.getAction(), idRef.get(), cr.getPayload(), null);

            }else if(CallType.CallError.correct(m)){

                Call<?> cc = callMessageRef.get();
                OCPPReflection answer = callReflectionRef.get();
                CallError<?> ce = (CallError<?>)m;

                answer.sendResponse(cc.getAction(), idRef.get(), null, ce.getPayload());
            }else{
                
            }
        })
        .whenCompleteAsync((m,e)->{
            String id = idRef.get(); 
            String r = e == null ? "success" : "failure";
            long d = System.currentTimeMillis() - start.get();
            Throwable t = e != null ? e.getCause() : null;

            String x = String.format("%s answer(%s) %s. [%d]ms.", name(), id, r, d);
            logger.info(x, t);
        })        
        ;
    }


    // public void answer(String source, OCPPConsumer<String> consumer) {
    //     final AtomicReference<Long> start = new AtomicReference<>(System.currentTimeMillis());
    //     final AtomicReference<String> messageId = new AtomicReference<>(source);

    //     CompletableFuture.supplyAsync(()->{
    //         return conversion.convertMessage(source);
    //     }).whenCompleteAsync((node, err)->{
    //         if(err != null) {
    //             String id = messageId.get(); 
    //             String r = "failure";
    //             long d = System.currentTimeMillis() - start.get();
    //             Throwable t = err.getCause();

    //             String x = String.format("%s offer(%s) %s. [%d]ms.", name(), id, r, d);
    //             logger.info(x, t);
    //             consumer.accept(null, err != null ? err.getCause() : null);

    //         }else {
    //             answer(node, (t, u)->{
    //                 String result = t != null ? conversion.convertMessage(t) : null;
    //                 consumer.accept(result, u);
    //             });
    //         }
    //     });
    // }    
}