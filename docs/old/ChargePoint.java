package io.u2ware.ocpp.v1_6.messaging;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.ClassUtils;

import io.u2ware.ocpp.core.OCPPConsumer;
import io.u2ware.ocpp.core.OCPPMessage;
import io.u2ware.ocpp.core.OCPPOperations;
import io.u2ware.ocpp.core.OCPPReflection;
import io.u2ware.ocpp.core.OCPPVersion;

public final class ChargePoint extends OCPPOperations{

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
        return String.format("%s.usecase.%s.ChargePointHandler", rootPackage, source);
    }

    @Override
    public boolean isServer() {
        return false;
    }

    @Override
    public boolean isClient() {
        return true;
    }    


    protected Map<String, OCPPReflection> handlers = new HashMap<>();
    
    @Override
    public OCPPReflection handler(String source) {
        if(handlers.containsKey(source)) return handlers.get(source);
        String key = OCPPReflection.extractElement(handlers.keySet(), source);
        return handlers.get(key);
    }


    @Override
    public String name() {
        return ClassUtils.getShortName(getClass());
    }

    @Override
    public OCPPVersion version() {
        return OCPPVersion.V1_6;
    }

    public void register(ChargePointHandler handler) {
        logger.info(String.format("[%s] %s(%s)", name(), handler.name(), ClassUtils.getDescriptiveType(handler)));
        this.handlers.put(handler.name(), new OCPPReflection(handler));
    }

    public void offer(ChargePointFeature feature, OCPPConsumer<OCPPMessage<?>> consumer) {
        super.offer(()->{ 
            return feature;
        }, consumer);
    }

}