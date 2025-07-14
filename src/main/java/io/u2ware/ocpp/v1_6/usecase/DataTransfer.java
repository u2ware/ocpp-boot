package io.u2ware.ocpp.v1_6.usecase;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

import io.u2ware.ocpp.v1_6.actions.*;
import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.messaging.Specification;
import io.u2ware.ocpp.v1_6.model.*;

public interface DataTransfer {
    
    public static Specification.Section[] section = {
        Specification.InitiatedByChargePoint.Usecase.DataTransfer,
        Specification.InitiatedByCentralSystem.Usecase.DataTransfer,
    };


    default String comment(ClientHandler handler, Comment comment, String id) {
        switch (comment) {
            case sendDataTransferRequest: return section[0].comment(Comment.values(), comment, id);
            case receivedDataTransferRequest: return section[1].comment(Comment.values(), comment, id);
            case receivedDataTransferResponse: return section[0].comment(Comment.values(), comment, id);
            case sendDataTransferResponse: return section[1].comment(Comment.values(), comment, id);
            default: return null;
        }
    }
    
    default String comment(ServerHandler handler, Comment comment, String id) {

        switch (comment) {
            case sendDataTransferRequest: return section[1].comment(Comment.values(), comment, id);
            case receivedDataTransferRequest: return section[0].comment(Comment.values(), comment, id);
            case receivedDataTransferResponse: return section[1].comment(Comment.values(), comment, id);
            case sendDataTransferResponse: return section[0].comment(Comment.values(), comment, id);
            default: return null;
        }
    }

    static enum Comment {
        sendDataTransferRequest,
        receivedDataTransferRequest,
        receivedDataTransferResponse,
        sendDataTransferResponse,
        ;
        Comment(String... a){ this.a = StringUtils.arrayToCommaDelimitedString(a);}
        private String a = "";
        public String toString(){return a;}
    }


    public interface ClientHandler extends DataTransfer, DataTransferOffer, DataTransferAnswer {     
        
        public static ClientHandler DEFAULT = new ClientHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public DataTransferRequest sendDataTransferRequest(String id, Map<String, Object> req) {
                logger.info(comment(this, Comment.sendDataTransferRequest, id));
                return new DataTransferRequest();
            }

            @Override
            public void receivedDataTransferResponse(String id, DataTransferResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.receivedDataTransferResponse, id));
            }       
            
            @Override
            public DataTransferResponse receivedDataTransferRequest(String id, DataTransferRequest req) {
                logger.info(comment(this, Comment.receivedDataTransferRequest, id));
                return new DataTransferResponse();
            }

            @Override
            public void sendDataTransferResponse(String id, DataTransferResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.sendDataTransferResponse, id));
            }
        };
    }

    public interface ServerHandler extends DataTransfer, DataTransferOffer, DataTransferAnswer {    

        public static ServerHandler DEFAULT = new ServerHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public DataTransferRequest sendDataTransferRequest(String id, Map<String, Object> req) {
                logger.info(comment(this, Comment.sendDataTransferRequest, id));
                return new DataTransferRequest();
            }

            @Override
            public void receivedDataTransferResponse(String id, DataTransferResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.receivedDataTransferResponse, id));
            }       
            
            
            @Override
            public DataTransferResponse receivedDataTransferRequest(String id, DataTransferRequest req) {
                logger.info(comment(this, Comment.receivedDataTransferRequest, id));
                return new DataTransferResponse();
            }

            @Override
            public void sendDataTransferResponse(String id, DataTransferResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.sendDataTransferResponse, id));
            }
        };
    }
}
