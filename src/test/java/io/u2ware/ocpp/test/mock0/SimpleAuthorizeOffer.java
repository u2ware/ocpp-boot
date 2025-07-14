package io.u2ware.ocpp.test.mock0;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import io.u2ware.ocpp.v1_6.exception.*;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.usecase.*;


public class SimpleAuthorizeOffer implements Authorize.ClientHandler {

    protected final Log logger = LogFactory.getLog(getClass());

    public static enum Test {
        OK,
        CALLERROR,
        EXCEPTION
    }


    private String title;
    private Test test;

    public SimpleAuthorizeOffer(String title, Test test){
        this.title = title;
        this.test = test;
    }

    @Override
    public AuthorizeRequest sendAuthorizeRequest(String id, Map<String,Object> req) {
        logger.info("SimpleAuthorizeOffer["+title+"] sendAuthorizeRequest("+id+", "+req+")");

        switch (test) {
            case OK: {
                return new AuthorizeRequest();
            }
            case CALLERROR: {
                throw ErrorCodes.NotImplemented.exception(title);
            }

            case EXCEPTION: {
                Integer.parseInt("aaaa");
                return new AuthorizeRequest();
            }
            default : {
                return null;
            }
        }        
    }

    @Override
    public void receivedAuthorizeResponse(String id, AuthorizeResponse res, ErrorCode err) {
        logger.info("SimpleAuthorizeOffer["+title+"] receivedAuthorizeResponse("+id+", "+res+", "+err+")");
    }

}
