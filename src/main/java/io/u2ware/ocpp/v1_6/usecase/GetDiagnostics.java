package io.u2ware.ocpp.v1_6.usecase;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

import io.u2ware.ocpp.v1_6.actions.*;
import io.u2ware.ocpp.v1_6.exception.*;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.messaging.Specification;

public interface GetDiagnostics {

    public static Specification.Section section = Specification.InitiatedByCentralSystem.GetDiagnostics;

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

        ;

        Comment(String... a){ this.a = StringUtils.arrayToCommaDelimitedString(a);}
        private String a = "";
        public String toString(){return a;}
    }    


    public interface ServerHandler extends GetDiagnostics, GetDiagnosticsOffer {       

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
        };
    }

    public interface ClientHandler extends GetDiagnostics, GetDiagnosticsAnswer {

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
        };
    }

}