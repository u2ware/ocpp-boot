package io.u2ware.ocpp.v1_6.usecase;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

import io.u2ware.ocpp.v1_6.actions.*;
import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.messaging.Specification;
import io.u2ware.ocpp.v1_6.model.*;

public interface SendLocalList {
    
    public static Specification.Section section = Specification.InitiatedByCentralSystem.SendLocalList;

    default String comment(ClientHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }
    
    default String comment(ServerHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }

    public static enum Comment {
        sendSendLocalListRequest,
        receivedSendLocalListRequest,
        receivedSendLocalListResponse,
        sendSendLocalListResponse
        ;

        Comment(String... a){ this.a = StringUtils.arrayToCommaDelimitedString(a);}
        private String a = "";
        public String toString(){return a;}
    }    


    public interface ServerHandler extends SendLocalList, SendLocalListOffer {
        public static ServerHandler DEFAULT = new ServerHandler(){
            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public SendLocalListRequest sendSendLocalListRequest(String id, Map<String, Object> req) {
                logger.info(comment(this, Comment.sendSendLocalListRequest, id));
                return SendLocalListRequest.builder().build();
            }

            @Override
            public void receivedSendLocalListResponse(String id, SendLocalListResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.receivedSendLocalListResponse, id));
            }
        };

    }


    public interface ClientHandler extends SendLocalList, SendLocalListAnswer {
        public static ClientHandler DEFAULT = new ClientHandler(){
            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public SendLocalListResponse receivedSendLocalListRequest(String id, SendLocalListRequest req) {
                logger.info(comment(this, Comment.receivedSendLocalListRequest, id));
                return SendLocalListResponse.builder().build();
            }

            @Override
            public void sendSendLocalListResponse(String id, SendLocalListResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.sendSendLocalListResponse, id));
            }
        };
    }     
}