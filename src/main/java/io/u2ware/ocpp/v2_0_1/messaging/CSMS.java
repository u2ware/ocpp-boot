package io.u2ware.ocpp.v2_0_1.messaging;

public final class CSMS extends SpecificationOperations{
    
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
    protected String usecaseType(String source) {
       return String.format("%s.usecase.%s.ServerHandler", rootPackage, source);
    }

   @Override
   public boolean isServer() {
      return true;
   }

   @Override
   public boolean isClient() {
      return false;
   }      
}