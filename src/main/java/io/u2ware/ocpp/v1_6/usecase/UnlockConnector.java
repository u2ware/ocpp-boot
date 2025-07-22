package io.u2ware.ocpp.v1_6.usecase;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

import io.u2ware.ocpp.v1_6.actions.*;
import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.messaging.Specification;
import io.u2ware.ocpp.v1_6.model.*;

public interface UnlockConnector {
    
    public static Specification.Section section = Specification.InitiatedByCentralSystem.Usecase.UnlockConnector;

    default String comment(ClientHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }
    
    default String comment(ServerHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }

    public static enum Comment {
        sendUnlockConnectorRequest,
        receivedUnlockConnectorRequest,
        receivedUnlockConnectorResponse,
        sendUnlockConnectorResponse
        ;

        Comment(String... a){ this.a = StringUtils.arrayToCommaDelimitedString(a);}
        private String a = "";
        public String toString(){return a;}
    }    


    public interface ServerHandler extends UnlockConnector, UnlockConnectorOffer {
        public static ServerHandler DEFAULT = new ServerHandler(){
            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public UnlockConnectorRequest sendUnlockConnectorRequest(String id, Map<String, Object> req) {
                logger.info(comment(this, Comment.sendUnlockConnectorRequest, id));
                return UnlockConnectorRequest.builder().build();
            }

            @Override
            public void receivedUnlockConnectorResponse(String id, UnlockConnectorResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.receivedUnlockConnectorResponse, id));
            }
        };

    }


    public interface ClientHandler extends UnlockConnector, UnlockConnectorAnswer {
        public static ClientHandler DEFAULT = new ClientHandler(){
            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public UnlockConnectorResponse receivedUnlockConnectorRequest(String id, UnlockConnectorRequest req) {
                logger.info(comment(this, Comment.receivedUnlockConnectorRequest, id));
                return UnlockConnectorResponse.builder().build();
            }

            @Override
            public void sendUnlockConnectorResponse(String id, UnlockConnectorResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.sendUnlockConnectorResponse, id));
            }
        };

    }    

}
