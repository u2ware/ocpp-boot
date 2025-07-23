package io.u2ware.ocpp.v1_6.usecase;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

import io.u2ware.ocpp.v1_6.actions.*;
import io.u2ware.ocpp.v1_6.exception.*;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.messaging.Specification;

public interface FirmwareStatusNotification {
    
    public static Specification.Section section = Specification.InitiatedByChargePoint.FirmwareStatusNotification;

    default String comment(ClientHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }
    
    default String comment(ServerHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }

    public static enum Comment {
        sendFirmwareStatusNotificationRequest,
        receivedFirmwareStatusNotificationRequest,
        receivedFirmwareStatusNotificationResponse,
        sendFirmwareStatusNotificationResponse
        ;

        Comment(String... a){ this.a = StringUtils.arrayToCommaDelimitedString(a);}
        private String a = "";
        public String toString(){return a;}
    }      

    public interface ClientHandler extends FirmwareStatusNotification, FirmwareStatusNotificationOffer {

        public static ClientHandler DEFAULT = new ClientHandler(){
            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public FirmwareStatusNotificationRequest sendFirmwareStatusNotificationRequest(String id,
                    Map<String, Object> req) {
                logger.info(comment(this, Comment.sendFirmwareStatusNotificationRequest, id));
                return FirmwareStatusNotificationRequest.builder().build();
            }

            @Override
            public void receivedFirmwareStatusNotificationResponse(String id, FirmwareStatusNotificationResponse res,
                    ErrorCode err) {
                logger.info(comment(this, Comment.receivedFirmwareStatusNotificationResponse, id));
            }
        };

    }


    public interface ServerHandler extends FirmwareStatusNotification, FirmwareStatusNotificationAnswer {
        
        public static ServerHandler DEFAULT = new ServerHandler(){
            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public FirmwareStatusNotificationResponse receivedFirmwareStatusNotificationRequest(String id,
                    FirmwareStatusNotificationRequest req) {
                logger.info(comment(this, Comment.receivedFirmwareStatusNotificationRequest, id));
                return FirmwareStatusNotificationResponse.builder().build();
            }

            @Override
            public void sendFirmwareStatusNotificationResponse(String id, FirmwareStatusNotificationResponse res,
                    ErrorCode err) {
                logger.info(comment(this, Comment.sendFirmwareStatusNotificationResponse, id));
            }
        };
    }

}
