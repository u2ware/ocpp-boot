package io.u2ware.ocpp.v1_6.messaging;

import org.springframework.util.ClassUtils;

import io.u2ware.ocpp.OCPPMessageConsumer;
import io.u2ware.ocpp.OCPPHandlerInvoker;
import io.u2ware.ocpp.OCPPHandlerTemplate;
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

    public void registerFeature(CentralSystemHandler handler) {
        super.registerFeature(handler);
    }

    public CentralSystem registerDefaultFeatures() {
        for(ChargePointCommand.Builder e :  ChargePointCommand.ALL.values()){
            Class<?> c = handlerClass(e.action());
            CentralSystemHandler h = (CentralSystemHandler)OCPPHandlerInvoker.invokeField(c, "DEFAULT");
            super.registerFeature(h);
        }
        for(CentralSystemCommand.Builder e :  CentralSystemCommand.ALL.values()){
            Class<?> c = handlerClass(e.action());
            CentralSystemHandler h = (CentralSystemHandler)OCPPHandlerInvoker.invokeField(c, "DEFAULT");
            super.registerFeature(h);
        }
        return this;
    }
}