package io.u2ware.ocpp.v1_6.usecase;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

import io.u2ware.ocpp.v1_6.actions.*;
import io.u2ware.ocpp.v1_6.exception.*;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.messaging.Specification;

public interface StatusNotification {

    public static Specification.Section section = Specification.InitiatedByChargePoint.Usecase.StatusNotification;

    default String comment(ClientHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }
    
    default String comment(ServerHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }

    public static enum Comment {
        sendStatusNotificationRequest,
        receivedStatusNotificationRequest,
        receivedStatusNotificationResponse,
        sendStatusNotificationResponse
        ;

        Comment(String... a){ this.a = StringUtils.arrayToCommaDelimitedString(a);}
        private String a = "";
        public String toString(){return a;}
    }  

    public interface ClientHandler extends StatusNotification, StatusNotificationOffer {

        public static ClientHandler DEFAULT = new ClientHandler(){
            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public StatusNotificationRequest sendStatusNotificationRequest(String id, Map<String, Object> req) {
                logger.info(comment(this, Comment.sendStatusNotificationRequest, id));
                return StatusNotificationRequest.builder().build();
            }

            @Override
            public void receivedStatusNotificationResponse(String id, StatusNotificationResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.receivedStatusNotificationResponse, id));
            }
        };

    }


    public interface ServerHandler extends StatusNotification, StatusNotificationAnswer {
        
        public static ServerHandler DEFAULT = new ServerHandler(){
            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public StatusNotificationResponse receivedStatusNotificationRequest(String id,
                    StatusNotificationRequest req) {
                logger.info(comment(this, Comment.receivedStatusNotificationRequest, id));
                return StatusNotificationResponse.builder().build();
            }

            @Override
            public void sendStatusNotificationResponse(String id, StatusNotificationResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.sendStatusNotificationResponse, id));
            }

        };
    }
       

}
