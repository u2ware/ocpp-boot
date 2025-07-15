package io.u2ware.ocpp.v1_6.messaging;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.ClassUtils;

import io.u2ware.ocpp.core.OCPPConsumer;
import io.u2ware.ocpp.core.OCPPMessage;
import io.u2ware.ocpp.core.OCPPOperations;
import io.u2ware.ocpp.core.OCPPReflection;
import io.u2ware.ocpp.core.OCPPVersion;

public abstract class SpecificationOperations extends OCPPOperations{

    protected Map<String, OCPPReflection> usecase = new HashMap<>();
    
    public void registerDefaultUsecases() {
        for(Specification u : Specification.usecases()) {
            registerDefaultUsecase(u);
        }
    }

    public void registerDefaultUsecase(Specification u) {
        Class<?> type = usecaseClass(u.usecase());
        if(type == null) return;
        Object target = OCPPReflection.invokeField(type, "DEFAULT");
        this.registerUsecase(u, target);
    }

    public void registerUsecase(Specification u, Object target) {
        if(! isUsecase(u.usecase(), target)){
            throw new RuntimeException("target is not "+usecaseType(u.usecase()));
        }
        logger.info(String.format("[%s] %s(%s)", name(), u.usecase(), ClassUtils.getDescriptiveType(target)));
        this.usecase.put(u.usecase(), new OCPPReflection(u.usecase(), target));
    }


    @Override
    public OCPPReflection usecase(String source) {
        String key = OCPPReflection.extractElement(usecase.keySet(), source);
        return usecase.get(key);
    }

    @Override
    public String name() {
        return ClassUtils.getShortName(getClass());
    }

    @Override
    public OCPPVersion version() {
        return OCPPVersion.V1_6;
    }

    ////////////////////////////////
    //
    ////////////////////////////////
    public void offer(SpecificationAction source, OCPPConsumer<OCPPMessage<?>> consumer) {
        super.offer(()->{ 
            return source;
        }, consumer);
    }

    public void offer(String source, OCPPConsumer<String> consumer) {
        super.offer(()->{
            SpecificationAction a = conversion.comfortableReadValue(source, SpecificationAction.class);
            return a;
        }, (t,u)->{
            if( t != null) {
                String s = null;
                Throwable x = null;
                try{
                    s = conversion.convertMessage(t);
                    x = u;
                }catch(Exception e){
                    s = null;
                    x = e;
                }
                consumer.accept(s, x);
            }else{
                consumer.accept(null, u);
            }
        });
    }   
}
