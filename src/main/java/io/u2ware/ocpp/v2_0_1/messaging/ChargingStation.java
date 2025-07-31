package io.u2ware.ocpp.v2_0_1.messaging;

import org.springframework.util.ClassUtils;

import io.u2ware.ocpp.core.OCPPConsumer;
import io.u2ware.ocpp.core.OCPPFeatureOperations;
import io.u2ware.ocpp.core.OCPPMessage;
import io.u2ware.ocpp.core.OCPPVersion;

public final class ChargingStation extends OCPPFeatureOperations{
    
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
        return String.format("%s.handlers.%s.ChargingStationHandler", rootPackage, source);
    }

    @Override
    public boolean isServer() {
        return false;
    }

    @Override
    public boolean isClient() {
        return true;
    }  
    
    @Override
    public String name() {
        return ClassUtils.getShortName(getClass());
    }

    @Override
    public OCPPVersion version() {
        return OCPPVersion.V1_6;
    }

    public void offer(ChargingStationCommand command, OCPPConsumer<OCPPMessage<?>> consumer) {
        super.offer(()->{ return command;}, consumer);
    }

    public void registerFeature(ChargingStationHandler handler) {
        super.registerFeature(handler);
    }    

}