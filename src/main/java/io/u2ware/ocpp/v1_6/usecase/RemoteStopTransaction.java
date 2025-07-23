package io.u2ware.ocpp.v1_6.usecase;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

import io.u2ware.ocpp.v1_6.actions.*;
import io.u2ware.ocpp.v1_6.exception.*;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.messaging.Specification;

public interface RemoteStopTransaction {

    public static Specification.Section section = Specification.InitiatedByCentralSystem.RemoteStopTransaction;

    default String comment(ClientHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }
    
    default String comment(ServerHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }

    public static enum Comment {
        sendRemoteStopTransactionRequest,
        receivedRemoteStopTransactionRequest,
        receivedRemoteStopTransactionResponse,
        sendRemoteStopTransactionResponse
        ;

        Comment(String... a){ this.a = StringUtils.arrayToCommaDelimitedString(a);}
        private String a = "";
        public String toString(){return a;}
    }    


    public interface ServerHandler extends RemoteStopTransaction, RemoteStopTransactionOffer {
        public static ServerHandler DEFAULT = new ServerHandler(){
            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public RemoteStopTransactionRequest sendRemoteStopTransactionRequest(String id, Map<String, Object> req) {
                logger.info(comment(this, Comment.sendRemoteStopTransactionRequest, id));
                return RemoteStopTransactionRequest.builder().build();
            }

            @Override
            public void receivedRemoteStopTransactionResponse(String id, RemoteStopTransactionResponse res,
                    ErrorCode err) {
                logger.info(comment(this, Comment.receivedRemoteStopTransactionResponse, id));
            }
           
        };


    }


    public interface ClientHandler extends RemoteStopTransaction, RemoteStopTransactionAnswer {
        public static ClientHandler DEFAULT = new ClientHandler(){
            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public RemoteStopTransactionResponse receivedRemoteStopTransactionRequest(String id,
                    RemoteStopTransactionRequest req) {
                logger.info(comment(this, Comment.receivedRemoteStopTransactionRequest, id));
                return RemoteStopTransactionResponse.builder().build();
            }

            @Override
            public void sendRemoteStopTransactionResponse(String id, RemoteStopTransactionResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.sendRemoteStopTransactionResponse, id));
            }
           
        };
    }      

}
