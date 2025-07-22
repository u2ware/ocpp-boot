package io.u2ware.ocpp.v1_6.usecase;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

import io.u2ware.ocpp.v1_6.actions.*;
import io.u2ware.ocpp.v1_6.exception.*;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.messaging.Specification;

public interface StopTransaction {
    
    public static Specification.Section section = Specification.InitiatedByChargePoint.Usecase.StopTransaction;

    default String comment(ClientHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }
    
    default String comment(ServerHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }

    public static enum Comment {
        sendStopTransactionRequest,
        receivedStopTransactionRequest,
        receivedStopTransactionResponse,
        sendStopTransactionResponse
        ;

        Comment(String... a){ this.a = StringUtils.arrayToCommaDelimitedString(a);}
        private String a = "";
        public String toString(){return a;}
    }  

    public interface ClientHandler extends StopTransaction, StopTransactionOffer {

        public static ClientHandler DEFAULT = new ClientHandler(){
            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public StopTransactionRequest sendStopTransactionRequest(String id, Map<String, Object> req) {
                logger.info(comment(this, Comment.sendStopTransactionRequest, id));
                return StopTransactionRequest.builder().build();
            }

            @Override
            public void receivedStopTransactionResponse(String id, StopTransactionResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.receivedStopTransactionResponse, id));
            }
        };

    }


    public interface ServerHandler extends StopTransaction, StopTransactionAnswer {
        
        public static ServerHandler DEFAULT = new ServerHandler(){
            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public StopTransactionResponse receivedStopTransactionRequest(String id, StopTransactionRequest req) {
                logger.info(comment(this, Comment.receivedStopTransactionRequest, id));
                return StopTransactionResponse.builder().build();
            }

            @Override
            public void sendStopTransactionResponse(String id, StopTransactionResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.sendStopTransactionResponse, id));
            }
        };
    }
    
}
