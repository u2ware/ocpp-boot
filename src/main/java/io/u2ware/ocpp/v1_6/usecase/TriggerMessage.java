package io.u2ware.ocpp.v1_6.usecase;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

import io.u2ware.ocpp.v1_6.actions.*;
import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.messaging.Specification;
import io.u2ware.ocpp.v1_6.model.*;

public interface TriggerMessage {
    
    public static Specification.Section section = Specification.InitiatedByCentralSystem.Usecase.TriggerMessage;

    default String comment(ClientHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }
    
    default String comment(ServerHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }

    public static enum Comment {
        sendTriggerMessageRequest,
        receivedTriggerMessageRequest,
        receivedTriggerMessageResponse,
        sendTriggerMessageResponse,
        ;

        Comment(String... a){ this.a = StringUtils.arrayToCommaDelimitedString(a);}
        private String a = "";
        public String toString(){return a;}
    }


    public interface ServerHandler extends TriggerMessage, TriggerMessageOffer {

        public static ServerHandler DEFAULT = new ServerHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public TriggerMessageRequest sendTriggerMessageRequest(String id, Map<String, Object> req) {
                logger.info(comment(this, Comment.sendTriggerMessageRequest, id));
                return new TriggerMessageRequest();
            }

            @Override
            public void receivedTriggerMessageResponse(String id, TriggerMessageResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.receivedTriggerMessageResponse, id));
            }
        };
    }


    public interface ClientHandler extends TriggerMessage, TriggerMessageAnswer{
        
        public static ClientHandler DEFAULT = new ClientHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public TriggerMessageResponse receivedTriggerMessageRequest(String id, TriggerMessageRequest req) {
                logger.info(comment(this, Comment.receivedTriggerMessageRequest, id));
                return new TriggerMessageResponse();
            }

            @Override
            public void sendTriggerMessageResponse(String id, TriggerMessageResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.sendTriggerMessageResponse, id));
            }
        };
    }
}
