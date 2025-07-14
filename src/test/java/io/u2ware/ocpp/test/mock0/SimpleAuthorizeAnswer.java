package io.u2ware.ocpp.test.mock0;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import io.u2ware.ocpp.v1_6.exception.*;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.usecase.*;

public class SimpleAuthorizeAnswer implements Authorize.ServerHandler {

    protected final Log logger = LogFactory.getLog(getClass());


    public static enum Test {
        OK,
        CALLERROR,
        EXCEPTION
    }


    private String title;
    private Test test;

    public SimpleAuthorizeAnswer(String title, Test test){
        this.title = title;
        this.test = test;
    }

    public AuthorizeResponse receivedAuthorizeRequest(String id, AuthorizeRequest req) {
        logger.info("SimpleAuthorizeAnswer["+title+"] receivedAuthorizeRequest("+id+", "+req+")");

        switch (test) {
            case OK: {
                return new AuthorizeResponse();
            }
            case CALLERROR: {
                throw ErrorCodes.NotImplemented.exception(title);
            }

            case EXCEPTION: {
                Integer.parseInt("aaaa");
                return new AuthorizeResponse();
            }
            default : {
                return null;
            }
        }
    }
    public void sendAuthorizeResponse(String id, AuthorizeResponse res, ErrorCode err) {
        logger.info("SimpleAuthorizeAnswer["+title+"] sendAuthorizeResponse("+id+", "+res+", "+err+")");
    } 
}
