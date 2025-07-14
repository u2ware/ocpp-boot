package io.u2ware.ocpp.v1_6.usecase;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

import io.u2ware.ocpp.v1_6.actions.*;
import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.messaging.Specification;
import io.u2ware.ocpp.v1_6.model.*;

public interface GetDiagnostics {

    public static Specification.Section section = Specification.InitiatedByCentralSystem.Usecase.GetDiagnostics;

    default String comment(ClientHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }
    
    default String comment(ServerHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }

    public static enum Comment {
        sendGetDiagnosticsRequest,
        receivedGetDiagnosticsRequest,
        receivedGetDiagnosticsResponse,
        sendGetDiagnosticsResponse,

        sendDiagnosticsStatusNotificationRequest,
        receivedDiagnosticsStatusNotificationRequest,
        receivedDiagnosticsStatusNotificationResponse,
        sendDiagnosticsStatusNotificationResponse
        ;

        Comment(String... a){ this.a = StringUtils.arrayToCommaDelimitedString(a);}
        private String a = "";
        public String toString(){return a;}
    }    


    public interface ServerHandler extends GetDiagnostics, GetDiagnosticsOffer, DiagnosticsStatusNotificationAnswer {       

        public static ServerHandler DEFAULT = new ServerHandler(){
            protected Log logger = LogFactory.getLog(getClass());
            
            @Override
            public GetDiagnosticsRequest sendGetDiagnosticsRequest(String id, Map<String,Object> req) {
                logger.info(comment(this, Comment.sendGetDiagnosticsRequest, id));
                return new GetDiagnosticsRequest();
            }

            @Override
            public void receivedGetDiagnosticsResponse(String id, GetDiagnosticsResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.receivedGetDiagnosticsResponse, id));
            }

            @Override
            public DiagnosticsStatusNotificationResponse receivedDiagnosticsStatusNotificationRequest(String id, DiagnosticsStatusNotificationRequest req) {
                logger.info(comment(this, Comment.receivedDiagnosticsStatusNotificationRequest, id));
                return new DiagnosticsStatusNotificationResponse();
            }

            @Override
            public void sendDiagnosticsStatusNotificationResponse(String id, DiagnosticsStatusNotificationResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.sendDiagnosticsStatusNotificationResponse, id));
            }            
        };
    }

    public interface ClientHandler extends GetDiagnostics, GetDiagnosticsAnswer, DiagnosticsStatusNotificationOffer {

        public static ClientHandler DEFAULT = new ClientHandler(){
            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public GetDiagnosticsResponse receivedGetDiagnosticsRequest(String id, GetDiagnosticsRequest req) {
                logger.info(comment(this, Comment.receivedGetDiagnosticsRequest, id));
                return new GetDiagnosticsResponse();
            }

            @Override
            public void sendGetDiagnosticsResponse(String id, GetDiagnosticsResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.sendGetDiagnosticsResponse, id));
            }

            @Override
            public DiagnosticsStatusNotificationRequest sendDiagnosticsStatusNotificationRequest(String id, Map<String,Object> req) {
                logger.info(comment(this, Comment.sendDiagnosticsStatusNotificationRequest, id));
                return new DiagnosticsStatusNotificationRequest();
            }

            @Override
            public void receivedDiagnosticsStatusNotificationResponse(String id, DiagnosticsStatusNotificationResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.receivedDiagnosticsStatusNotificationResponse, id));
            }
        };
    }

}