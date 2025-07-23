package io.u2ware.ocpp.v1_6.usecase;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

import io.u2ware.ocpp.v1_6.actions.*;
import io.u2ware.ocpp.v1_6.exception.*;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.messaging.Specification;

public interface DiagnosticsStatusNotification {
    
    public static Specification.Section section = Specification.InitiatedByChargePoint.DiagnosticsStatusNotification;

    default String comment(ClientHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }
    
    default String comment(ServerHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }

    public static enum Comment {
        sendDiagnosticsStatusNotificationRequest,
        receivedDiagnosticsStatusNotificationRequest,
        receivedDiagnosticsStatusNotificationResponse,
        sendDiagnosticsStatusNotificationResponse
        ;

        Comment(String... a){ this.a = StringUtils.arrayToCommaDelimitedString(a);}
        private String a = "";
        public String toString(){return a;}
    }  

    public interface ClientHandler extends DiagnosticsStatusNotification, DiagnosticsStatusNotificationOffer {

        public static ClientHandler DEFAULT = new ClientHandler(){
            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public DiagnosticsStatusNotificationRequest sendDiagnosticsStatusNotificationRequest(String id,
                    Map<String, Object> req) {
                logger.info(comment(this, Comment.sendDiagnosticsStatusNotificationRequest, id));
                return DiagnosticsStatusNotificationRequest.builder().build();
            }

            @Override
            public void receivedDiagnosticsStatusNotificationResponse(String id,
                    DiagnosticsStatusNotificationResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.receivedDiagnosticsStatusNotificationResponse, id));
            }
        };

    }


    public interface ServerHandler extends DiagnosticsStatusNotification, DiagnosticsStatusNotificationAnswer {
        
        public static ServerHandler DEFAULT = new ServerHandler(){
            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public DiagnosticsStatusNotificationResponse receivedDiagnosticsStatusNotificationRequest(String id,
                    DiagnosticsStatusNotificationRequest req) {
                logger.info(comment(this, Comment.receivedDiagnosticsStatusNotificationRequest, id));
                return DiagnosticsStatusNotificationResponse.builder().build();
            }

            @Override
            public void sendDiagnosticsStatusNotificationResponse(String id, DiagnosticsStatusNotificationResponse res,
                    ErrorCode err) {
                logger.info(comment(this, Comment.sendDiagnosticsStatusNotificationResponse, id));
            }
        };
    }


}
