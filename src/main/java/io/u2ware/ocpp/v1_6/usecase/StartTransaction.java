package io.u2ware.ocpp.v1_6.usecase;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

import io.u2ware.ocpp.v1_6.actions.*;
import io.u2ware.ocpp.v1_6.exception.*;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.messaging.Specification;

public interface StartTransaction {
    
    public static Specification.Section section = Specification.InitiatedByChargePoint.StartTransaction;

    default String comment(ClientHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }
    
    default String comment(ServerHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }

    public static enum Comment {
        sendStartTransactionRequest,
        receivedStartTransactionRequest,
        receivedStartTransactionResponse,
        sendStartTransactionResponse,
        ;

        Comment(String... a){ this.a = StringUtils.arrayToCommaDelimitedString(a);}
        private String a = "";
        public String toString(){return a;}
    } 


    public interface ClientHandler extends StartTransaction, StartTransactionOffer {

        public static ClientHandler DEFAULT = new ClientHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public StartTransactionRequest sendStartTransactionRequest(String id, Map<String, Object> req) {
                logger.info(comment(this, Comment.sendStartTransactionRequest, id));
                return StartTransactionRequest.builder().build();
            }

            @Override
            public void receivedStartTransactionResponse(String id, StartTransactionResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.receivedStartTransactionResponse, id));
            }


        };
    }

    public interface ServerHandler extends StartTransaction, StartTransactionAnswer {

        public static ServerHandler DEFAULT = new ServerHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public StartTransactionResponse receivedStartTransactionRequest(String id, StartTransactionRequest req) {
                logger.info(comment(this, Comment.receivedStartTransactionRequest, id));
                return StartTransactionResponse.builder().build();
            }

            @Override
            public void sendStartTransactionResponse(String id, StartTransactionResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.sendStartTransactionResponse, id));
            }


        };        
    }
}
