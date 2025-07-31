package io.u2ware.ocpp.test.base00;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.u2ware.ocpp.OCPPFeature;
import io.u2ware.ocpp.v1_6.exception.ErrorCodes;
import io.u2ware.ocpp.v1_6.model.AuthorizeRequest;
import io.u2ware.ocpp.v1_6.model.AuthorizeResponse;

public class OCPP4ReflectionTests {
    

    protected final Log logger = LogFactory.getLog(getClass());


    @Test
    public void context1Loads()  {


        OCPPFeature a1 = new OCPPFeature(io.u2ware.ocpp.v1_6.handlers.Authorize.ChargePointHandler.DEFAULT);
        OCPPFeature a2 = new OCPPFeature(io.u2ware.ocpp.v1_6.handlers.Authorize.CentralSystemHandler.DEFAULT);


        Assertions.assertTrue(sendRequest(a1, "Authorize", new HashMap<String,Object>()));
        Assertions.assertFalse(sendRequest(a2, "Authorize", new HashMap<String,Object>()));

        Assertions.assertFalse(sendRequest(a1, "Authorize1", new HashMap<String,Object>()));
        Assertions.assertFalse(sendRequest(a2, "Authorize1", new HashMap<String,Object>()));

        Assertions.assertFalse(sendRequest(a1, "Authorize", new AuthorizeRequest()));
        Assertions.assertFalse(sendRequest(a2, "Authorize", new AuthorizeRequest()));
     

        Assertions.assertTrue(receivedResponse(a1, "Authorize", new AuthorizeResponse(), null));
        Assertions.assertFalse(receivedResponse(a2, "Authorize", new AuthorizeResponse(), null));

        Assertions.assertFalse(receivedResponse(a1, "Authorize1", new AuthorizeResponse(), null));
        Assertions.assertFalse(receivedResponse(a2, "Authorize1", new AuthorizeResponse(), null));

        Assertions.assertFalse(receivedResponse(a1, "Authorize", new AuthorizeRequest(), null));
        Assertions.assertFalse(receivedResponse(a2, "Authorize", new AuthorizeRequest(), null));

        Assertions.assertTrue(receivedResponse(a1, "Authorize", null, ErrorCodes.GenericError.exception()));
        Assertions.assertFalse(receivedResponse(a2, "Authorize", null, ErrorCodes.GenericError.exception()));

        Assertions.assertFalse(receivedResponse(a1, "Authorize1", null, ErrorCodes.GenericError.exception()));
        Assertions.assertFalse(receivedResponse(a2, "Authorize1", null, ErrorCodes.GenericError.exception()));

        Assertions.assertFalse(receivedResponse(a1, "Authorize", null,  new AuthorizeRequest()));
        Assertions.assertFalse(receivedResponse(a2, "Authorize", null,  new AuthorizeRequest()));


        Assertions.assertFalse(receivedRequest(a1, "Authorize", new AuthorizeRequest()));
        Assertions.assertTrue(receivedRequest(a2, "Authorize", new AuthorizeRequest()));

        Assertions.assertFalse(receivedRequest(a1, "Authorize1", new AuthorizeRequest()));
        Assertions.assertFalse(receivedRequest(a2, "Authorize1", new AuthorizeRequest()));

        Assertions.assertFalse(receivedRequest(a1, "Authorize", new AuthorizeResponse()));
        Assertions.assertFalse(receivedRequest(a2, "Authorize", new AuthorizeResponse()));

        Assertions.assertFalse(sendResponse(a1, "Authorize", new AuthorizeResponse(), null));
        Assertions.assertTrue(sendResponse(a2, "Authorize", new AuthorizeResponse(), null));

        Assertions.assertFalse(sendResponse(a1, "Authorize1", new AuthorizeResponse(), null));
        Assertions.assertFalse(sendResponse(a2, "Authorize1", new AuthorizeResponse(), null));

        Assertions.assertFalse(sendResponse(a1, "Authorize", new AuthorizeRequest(), null));
        Assertions.assertFalse(sendResponse(a2, "Authorize", new AuthorizeRequest(), null));

        Assertions.assertFalse(sendResponse(a1, "Authorize", null, ErrorCodes.GenericError.exception()));
        Assertions.assertTrue(sendResponse(a2, "Authorize", null, ErrorCodes.GenericError.exception()));
  
        Assertions.assertFalse(sendResponse(a1, "Authorize1", null, ErrorCodes.GenericError.exception()));
        Assertions.assertFalse(sendResponse(a2, "Authorize1", null, ErrorCodes.GenericError.exception()));
 
        Assertions.assertFalse(sendResponse(a1, "Authorize", null,  new AuthorizeRequest()));
        Assertions.assertFalse(sendResponse(a2, "Authorize", null,  new AuthorizeRequest()));
 

    }



    private Boolean sendRequest(OCPPFeature target, String action, Object request){
        try{
            target.sendRequest(action, "id", request);
            return Boolean.TRUE;
        }catch(Exception e){
            logger.info("",e);
            return Boolean.FALSE;
        }
    }
    private Boolean receivedResponse(OCPPFeature target, String action, Object request, Object error){
        try{
            target.receivedResponse(action, "id", request, error);
            return Boolean.TRUE;
        }catch(Exception e){
            logger.info("",e);
            return Boolean.FALSE;
        }
    }

    private Boolean receivedRequest(OCPPFeature target, String action, Object request){
        try{
            target.receivedRequest(action, "id", request);
            return Boolean.TRUE;
        }catch(Exception e){
            logger.info("",e);
            return Boolean.FALSE;
        }
    }

    private Boolean sendResponse(OCPPFeature target, String action, Object response, Object error){
        try{
            target.sendResponse(action, "id", response, error);
            return Boolean.TRUE;
        }catch(Exception e){
            logger.info("",e);
            return Boolean.FALSE;
        }
    }

}
