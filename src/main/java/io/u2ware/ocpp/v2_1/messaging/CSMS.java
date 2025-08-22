package io.u2ware.ocpp.v2_1.messaging;

import java.util.ArrayList;

import org.springframework.util.ClassUtils;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

import io.u2ware.ocpp.OCPPHandlerInvoker;
import io.u2ware.ocpp.OCPPHandlerTemplate;
import io.u2ware.ocpp.OCPPMessageConsumer;
import io.u2ware.ocpp.OCPPVersion;

public final class CSMS extends OCPPHandlerTemplate<CSMSCommand>{
    
    private final String rootPackage = "io.u2ware.ocpp.v2_1";

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
        return String.format("%s.handlers.%s.CSMSHandler", rootPackage, source);
    }

    @Override
    public final boolean isServer() {
        return true;
    }

    @Override
    public final boolean isClient() {
        return false;
    }      

    @Override
    public final String name() {
        return ClassUtils.getShortName(getClass());
    }

    @Override
    public final OCPPVersion version() {
        return OCPPVersion.V2_1;
    }

    public void offer(CSMSCommand command, OCPPMessageConsumer consumer) {
        super.offer(()->{ return command;}, consumer);
    }

    //////////////////////////////////////////////////////
    //
    //////////////////////////////////////////////////////
    public CSMS registerDefaultHandlers() {
        return registerDefaultHandlers(null);
    }

    public CSMS registerDefaultHandlers(MultiValueMap<String,String> metadata) {
        for(ChargingStationCommand.Builder e :  ChargingStationCommand.ALL.values()){
            String action = e.action();
            Class<?> type = handlerClass(action);
            CSMSHandler handler = (CSMSHandler)OCPPHandlerInvoker.invokeField(type, "DEFAULT");
            this.registerHandler(action, type, handler, metadata);
        }
        for(CSMSCommand.Builder e :  CSMSCommand.ALL.values()){
            String action = e.action();
            Class<?> type = handlerClass(action);
            CSMSHandler handler = (CSMSHandler)OCPPHandlerInvoker.invokeField(type, "DEFAULT");
            this.registerHandler(action, type, handler, metadata);
        }
        return this;
    }

    public CSMS registerHandler(CSMSHandler handler){
        return registerHandler(handler, null);
    }    

    public CSMS registerHandler(CSMSHandler handler, MultiValueMap<String,String> metadata) {

        for(ChargingStationCommand.Builder e :  ChargingStationCommand.ALL.values()){
            String action = e.action();
            Class<?> type = handlerClass(action);
            this.registerHandler(action, type, handler, metadata);
        }
        for(CSMSCommand.Builder e :  CSMSCommand.ALL.values()){
            String action = e.action();
            Class<?> type = handlerClass(action);
            this.registerHandler(action, type, handler, metadata);
        }        
        return this;
    }

    //////////////////////////////////////////////////////
    //
    //////////////////////////////////////////////////////
    private CSMS registerHandler(String action, Class<?> type, CSMSHandler handler, MultiValueMap<String,String> metadata) {

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