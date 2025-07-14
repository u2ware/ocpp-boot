package io.u2ware.ocpp.v2_0_1.usecase;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

import io.u2ware.ocpp.v2_0_1.actions.*;
import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_0_1.messaging.Specification;
import io.u2ware.ocpp.v2_0_1.model.*;

public interface A04 {
    
    public static Specification.Section section = Specification.Security.Usecase.A04;

    default String comment(ClientHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }
    
    default String comment(ServerHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }


    public static enum Comment {
        sendSecurityEventNotificationRequest("A security related event occurred"),
        receivedSecurityEventNotificationRequest,
        receivedSecurityEventNotificationResponse,
        sendSecurityEventNotificationResponse
        ;

        Comment(String... a){ this.a = StringUtils.arrayToCommaDelimitedString(a);}
        private String a = "";
        public String toString(){return a;}
    }

    public interface ClientHandler extends A04, SecurityEventNotificationOffer {

        public static final ClientHandler DEFAULT = new ClientHandler() {

            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public SecurityEventNotificationRequest sendSecurityEventNotificationRequest(String id, Map<String,Object> req) {
                logger.info(comment(this, Comment.sendSecurityEventNotificationRequest, id));
                return new SecurityEventNotificationRequest();
            }

            @Override
            public void receivedSecurityEventNotificationResponse(String id, SecurityEventNotificationResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.receivedSecurityEventNotificationResponse, id));
            }
        };
    }

    public interface ServerHandler extends A04, SecurityEventNotificationAnswer {

        public static final ServerHandler DEFAULT = new ServerHandler() {

            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public SecurityEventNotificationResponse receivedSecurityEventNotificationRequest(String id, SecurityEventNotificationRequest req) {
                logger.info(comment(this, Comment.receivedSecurityEventNotificationRequest, id));
                return new SecurityEventNotificationResponse();
            }
            @Override
            public void sendSecurityEventNotificationResponse(String id, SecurityEventNotificationResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.sendSecurityEventNotificationResponse, id));
            }
        };
    }
}