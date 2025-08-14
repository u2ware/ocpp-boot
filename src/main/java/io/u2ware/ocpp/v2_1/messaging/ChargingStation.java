package io.u2ware.ocpp.v2_1.messaging;

import java.util.ArrayList;

import org.springframework.util.ClassUtils;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

import io.u2ware.ocpp.OCPPHandlerInvoker;
import io.u2ware.ocpp.OCPPHandlerTemplate;
import io.u2ware.ocpp.OCPPMessageConsumer;
import io.u2ware.ocpp.OCPPVersion;

public final class ChargingStation extends OCPPHandlerTemplate<ChargingStationCommand>{
    
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
        return String.format("%s.handlers.%s.ChargingStationHandler", rootPackage, source);
    }

    @Override
    public final boolean isServer() {
        return false;
    }

    @Override
    public final boolean isClient() {
        return true;
    }  
    
    @Override
    public final String name() {
        return ClassUtils.getShortName(getClass());
    }

    @Override
    public final OCPPVersion version() {
        return OCPPVersion.V2_1;
    }

    public void offer(ChargingStationCommand command, OCPPMessageConsumer consumer) {
        super.offer(()->{ return command;}, consumer);
    }


    //////////////////////////////////////////////////////
    //
    //////////////////////////////////////////////////////
    public ChargingStation registerDefaultHandlers() {
        for(ChargingStationCommand.Builder e :  ChargingStationCommand.ALL.values()){
            String action = e.action();
            Class<?> type = handlerClass(action);

            System.err.println(action+ " "+handlerType(action)+" "+handlerClass(action));

            ChargingStationHandler handler = (ChargingStationHandler)OCPPHandlerInvoker.invokeField(type, "DEFAULT");
            super.registerFeature(action, handler);
        }
        for(CSMSCommand.Builder e :  CSMSCommand.ALL.values()){
            String action = e.action();
            Class<?> type = handlerClass(action);
            ChargingStationHandler handler = (ChargingStationHandler)OCPPHandlerInvoker.invokeField(type, "DEFAULT");
            super.registerFeature(action, handler);
        }
        return this;
    }


    public ChargingStation registerHandler(ChargingStationHandler handler, MultiValueMap<String,Object> metadata) {


        String usecase = handler.usecase();
        boolean actions = handler.actions();


        for(ChargingStationCommand.Builder e :  ChargingStationCommand.ALL.values()){
            String action = e.action();
            Class<?> type = handlerClass(action);

            if(metadata != null && ! metadata.containsKey(action)){
                metadata.put(action, new ArrayList<>());
            }

            if(ClassUtils.isAssignableValue(type, handler)){
                if(StringUtils.hasText(usecase)) {
                    super.registerFeature(usecase, handler);
                    if(metadata != null){
                        metadata.add(action, usecase);
                    }
                }
                if(actions) {
                    super.registerFeature(action, handler);
                    if(metadata != null){
                        metadata.add(action, action);
                    }
                }
            }
        }
        for(CSMSCommand.Builder e :  CSMSCommand.ALL.values()){
            String action = e.action();
            Class<?> type = handlerClass(action);

            if(metadata != null && ! metadata.containsKey(action)){
                metadata.put(action, new ArrayList<>());
            }            
            if(ClassUtils.isAssignableValue(type, handler)){
                if(StringUtils.hasText(usecase)) {
                    super.registerFeature(usecase, handler);
                    if(metadata != null){
                        metadata.add(action, usecase);
                    }
                }
                if(actions) {
                    super.registerFeature(action, handler);
                    if(metadata != null){
                        metadata.add(action, action);
                    }
                }
            }
        }        
        return this;
    }

    public ChargingStation registerHandler(ChargingStationHandler handler) {       
        return registerHandler(handler, null);
    }

}