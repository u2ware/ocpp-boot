package io.u2ware.ocpp.v1_6.usecase;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

import io.u2ware.ocpp.v1_6.actions.*;
import io.u2ware.ocpp.v1_6.exception.*;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.messaging.Specification;

public interface Authorize  {

    public static Specification.Section section = Specification.InitiatedByChargePoint.Authorize;

    default String comment(ClientHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }
    
    default String comment(ServerHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }

    public static enum Comment {
        sendAuthorizeRequest,
        receivedAuthorizeRequest,
        receivedAuthorizeResponse,
        sendAuthorizeResponse,
        ;

        Comment(String... a){ this.a = StringUtils.arrayToCommaDelimitedString(a);}
        private String a = "";
        public String toString(){return a;}
    }


    public interface ClientHandler extends Authorize, AuthorizeOffer {       

        public static ClientHandler DEFAULT = new ClientHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public AuthorizeRequest sendAuthorizeRequest(String id, Map<String, Object> req) {
                logger.info(comment(this, Comment.sendAuthorizeRequest, id));
                return AuthorizeRequest.builder().build();
            }

            @Override
            public void receivedAuthorizeResponse(String id, AuthorizeResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.receivedAuthorizeResponse, id));
            }
        };
    }

    public interface ServerHandler extends Authorize, AuthorizeAnswer {       

        public static ServerHandler DEFAULT = new ServerHandler(){
            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public AuthorizeResponse receivedAuthorizeRequest(String id, AuthorizeRequest req) {
                logger.info(comment(this, Comment.receivedAuthorizeRequest, id));
                return AuthorizeResponse.builder().build();
            }

            @Override
            public void sendAuthorizeResponse(String id, AuthorizeResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.sendAuthorizeResponse, id));
            }
        }; 
    }
}
