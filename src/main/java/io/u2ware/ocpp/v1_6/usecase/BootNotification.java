package io.u2ware.ocpp.v1_6.usecase;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

import io.u2ware.ocpp.v1_6.actions.*;
import io.u2ware.ocpp.v1_6.exception.*;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.messaging.Specification;

public interface BootNotification {

    public static Specification.Section section = Specification.InitiatedByChargePoint.BootNotification;

    default String comment(ClientHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }
    
    default String comment(ServerHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }

    public static enum Comment {
        sendBootNotificationRequest,
        receivedBootNotificationRequest,
        receivedBootNotificationResponse,
        sendBootNotificationResponse
        ;

        Comment(String... a){ this.a = StringUtils.arrayToCommaDelimitedString(a);}
        private String a = "";
        public String toString(){return a;}
    }    

    public interface ClientHandler extends BootNotification, BootNotificationOffer {

        public static ClientHandler DEFAULT = new ClientHandler(){
            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public BootNotificationRequest sendBootNotificationRequest(String id, Map<String, Object> req) {
                logger.info(comment(this, Comment.sendBootNotificationRequest, id));
                return BootNotificationRequest.builder().build();
            }

            @Override
            public void receivedBootNotificationResponse(String id, BootNotificationResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.receivedBootNotificationResponse, id));
            }
        };

    }


    public interface ServerHandler extends BootNotification, BootNotificationAnswer {
        
        public static ServerHandler DEFAULT = new ServerHandler(){
            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public BootNotificationResponse receivedBootNotificationRequest(String id, BootNotificationRequest req) {
                logger.info(comment(this, Comment.receivedBootNotificationRequest, id));
                return BootNotificationResponse.builder().build();
            }

            @Override
            public void sendBootNotificationResponse(String id, BootNotificationResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.sendBootNotificationResponse, id));
            }
        };
    }
}
