package io.u2ware.ocpp.v1_6.messaging;

import java.util.ArrayList;

import org.springframework.util.ClassUtils;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

import io.u2ware.ocpp.OCPPHandlerInvoker;
import io.u2ware.ocpp.OCPPHandlerTemplate;
import io.u2ware.ocpp.OCPPMessageConsumer;
import io.u2ware.ocpp.OCPPVersion;

public final class CentralSystem extends OCPPHandlerTemplate<CentralSystemCommand>{

    private final String rootPackage = "io.u2ware.ocpp.v1_6";

    @Override
    protected String requestType(String source) {
        return String.format("%s.model.%sRequest", rootPackage, source);
    }

    @Override
    protected String responseType(String source) {
        return String.format("%s.model.%sResponse", rootPackage, source);
    }

    @Override
    protected String errorType(String source) {
        return String.format("%s.exception.ErrorCode", rootPackage);
    }

    @Override
    protected String handlerType(String source) {
        return String.format("%s.handlers.%s.CentralSystemHandler", rootPackage, source);
    }

    @Override
    public boolean isServer() {
        return true;
    }

    @Override
    public boolean isClient() {
        return false;
    }

    @Override
    public String name() {
        return ClassUtils.getShortName(getClass());
    }

    @Override
    public OCPPVersion version() {
        return OCPPVersion.V1_6;
    }

    public void offer(CentralSystemCommand command, OCPPMessageConsumer consumer) {
        super.offer(()->{ return command;}, consumer);
    }


    //////////////////////////////////////////////////////
    //
    //////////////////////////////////////////////////////
    public CentralSystem registerDefaultHandlers() {
        return registerDefaultHandlers(null);
    }

    public CentralSystem registerDefaultHandlers(MultiValueMap<String,String> metadata) {
        for(ChargePointCommand.Builder e :  ChargePointCommand.ALL.values()){
            String action = e.action();
            Class<?> type = handlerClass(action);
            CentralSystemHandler handler = (CentralSystemHandler)OCPPHandlerInvoker.invokeField(type, "DEFAULT");
            this.registerHandler(action, type, handler, metadata);
        }
        for(CentralSystemCommand.Builder e :  CentralSystemCommand.ALL.values()){
            String action = e.action();
            Class<?> type = handlerClass(action);
            CentralSystemHandler handler = (CentralSystemHandler)OCPPHandlerInvoker.invokeField(type, "DEFAULT");
            this.registerHandler(action, type, handler, metadata);
        }
        return this;
    }

    public CentralSystem registerHandler(CentralSystemHandler handler){
        return registerHandler(handler, null);
    }

    public CentralSystem registerHandler(CentralSystemHandler handler, MultiValueMap<String,String> metadata) {       
        for(ChargePointCommand.Builder e :  ChargePointCommand.ALL.values()){
            String action = e.action();
            Class<?> type = handlerClass(action);
            this.registerHandler(action, type, handler, metadata);
        }
        for(CentralSystemCommand.Builder e :  CentralSystemCommand.ALL.values()){
            String action = e.action();
            Class<?> type = handlerClass(action);
            this.registerHandler(action, type, handler, metadata);
        }
        return this;
    }

    //////////////////////////////////////////////////////
    //
    //////////////////////////////////////////////////////
    private CentralSystem registerHandler(String action, Class<?> type, CentralSystemHandler handler, MultiValueMap<String,String> metadata) {       
        String usecase = handler.usecase();
        boolean actions = handler.actions();
        if(metadata != null) {
            metadata.computeIfAbsent(action, (key)->{ return new ArrayList<>();});
        }

        if(ClassUtils.isAssignableValue(type, handler)){
            if(StringUtils.hasText(usecase)) {
                super.registerFeature(usecase, handler);
                if(metadata != null) {
                    metadata.computeIfPresent(action, (key, list)->{
                        if(! list.contains(usecase)) list.add(usecase);
                        return list;
                    });
                }
            }
            if(actions) {
                super.registerFeature(action, handler);
                if(metadata != null) {
                    metadata.computeIfPresent(action, (key, list)->{
                        if(! list.contains(action)) list.add(action);
                        return list;
                    });
                }
            }
        }
        return this;
    }
}