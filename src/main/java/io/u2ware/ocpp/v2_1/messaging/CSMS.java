package io.u2ware.ocpp.v2_1.messaging;

import org.springframework.util.ClassUtils;

import io.u2ware.ocpp.OCPPConsumer;
import io.u2ware.ocpp.OCPPFeature;
import io.u2ware.ocpp.OCPPFeatureTemplate;
import io.u2ware.ocpp.OCPPMessage;
import io.u2ware.ocpp.OCPPVersion;

public final class CSMS extends OCPPFeatureTemplate<CSMSCommand>{
    
    private final String rootPackage = "io.u2ware.ocpp.v2_0_1";

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

    public void offer(CSMSCommand command, OCPPConsumer<OCPPMessage<?>> consumer) {
        super.offer(()->{ return command;}, consumer);
    }

    public void registerFeature(CSMSHandler handler) {
        super.registerFeature(handler);
    }  

    public CSMS registerDefaultFeatures() {
        for(ChargingStationCommand.Builder e :  ChargingStationCommand.ALL.values()){
            Class<?> c = handlerClass(e.action());
            CSMSHandler h = (CSMSHandler)OCPPFeature.invokeField(c, "DEFAULT");
            super.registerFeature(h);
        }
        for(CSMSCommand.Builder e :  CSMSCommand.ALL.values()){
            Class<?> c = handlerClass(e.action());
            CSMSHandler h = (CSMSHandler)OCPPFeature.invokeField(c, "DEFAULT");
            super.registerFeature(h);
        }
        return this;
    }

}