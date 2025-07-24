package io.u2ware.ocpp.v2_0_1.usecase;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

import io.u2ware.ocpp.v2_0_1.actions.*;
import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_0_1.messaging.Specification;
import io.u2ware.ocpp.v2_0_1.model.*;

public interface A05 {
    
    public static Specification.Section section = Specification.Security.A05;

    default String comment(ClientHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }
    
    default String comment(ServerHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }


    public static enum Comment {
        sendSetVariablesRequest,
        receivedSetVariablesRequest,
        receivedSetVariablesResponse,
        sendSetVariablesResponse("call next sendResetRequest"),

        sendResetRequest,
        receivedResetRequest,
        receivedResetResponse,
        sendResetResponse("Reboot" , "Connect using (new) NetworkConnectionProfile with higher security profile", "call next sendBootNotificationRequest"),

        sendBootNotificationRequest,
        receivedBootNotificationRequest,
        receivedBootNotificationResponse,
        sendBootNotificationResponse
        ;


        Comment(String... a){ this.a = StringUtils.arrayToCommaDelimitedString(a);}
        private String a = "";
        public String toString(){return a;}
    }


    public interface ServerHandler extends A05, SetVariablesOffer, ResetOffer, BootNotificationAnswer {

        public static final ServerHandler DEFAULT = new ServerHandler() {

            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public SetVariablesRequest sendSetVariablesRequest(String id, Map<String,Object> req) {
                logger.info(comment(this, Comment.sendSetVariablesRequest, id));
                return new SetVariablesRequest();
            }

            @Override
            public void receivedSetVariablesResponse(String id, SetVariablesResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.receivedSetVariablesResponse, id));
            }

            @Override
            public ResetRequest sendResetRequest(String id, Map<String,Object> req) {
                logger.info(comment(this, Comment.sendResetRequest, id));
                return new ResetRequest();
            }

            @Override
            public void receivedResetResponse(String id, ResetResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.receivedResetResponse, id));
            }

            @Override
            public BootNotificationResponse receivedBootNotificationRequest(String id, BootNotificationRequest req) {
                logger.info(comment(this, Comment.receivedBootNotificationRequest, id));
                return new BootNotificationResponse();
            }

            @Override
            public void sendBootNotificationResponse(String id, BootNotificationResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.sendBootNotificationResponse, id));
            }
        };
    }
    public interface ClientHandler extends A05, SetVariablesAnswer, ResetAnswer, BootNotificationOffer  {


        public static final ClientHandler DEFAULT = new ClientHandler() {

            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public SetVariablesResponse receivedSetVariablesRequest(String id, SetVariablesRequest req) {
                logger.info(comment(this, Comment.receivedSetVariablesRequest, id));
                return new SetVariablesResponse();
            }

            @Override
            public void sendSetVariablesResponse(String id, SetVariablesResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.sendSetVariablesResponse, id));
            }

            @Override
            public ResetResponse receivedResetRequest(String id, ResetRequest req) {
                logger.info(comment(this, Comment.receivedResetRequest, id));
                return new ResetResponse();
            }

            @Override
            public void sendResetResponse(String id, ResetResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.sendResetResponse, id));
            }

            @Override
            public BootNotificationRequest sendBootNotificationRequest(String id, Map<String,Object> req) {
                logger.info(comment(this, Comment.sendBootNotificationRequest, id));
                return new BootNotificationRequest();
            }

            @Override
            public void receivedBootNotificationResponse(String id, BootNotificationResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.receivedBootNotificationResponse, id));
            }
        };
    }
}
