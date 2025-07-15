package io.u2ware.ocpp.v1_6.messaging;


public final class ChargePoint extends SpecificationOperations{

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
    protected String usecaseType(String source) {
        return String.format("%s.usecase.%s.ClientHandler", rootPackage, source);
    }

    @Override
    public boolean isServer() {
        return false;
    }

    @Override
    public boolean isClient() {
        return true;
    }    
}