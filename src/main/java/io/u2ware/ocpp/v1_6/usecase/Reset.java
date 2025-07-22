package io.u2ware.ocpp.v1_6.usecase;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

import io.u2ware.ocpp.v1_6.actions.*;
import io.u2ware.ocpp.v1_6.exception.*;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.messaging.Specification;

public interface Reset {
    
    public static Specification.Section section = Specification.InitiatedByCentralSystem.Usecase.Reset;

    default String comment(ClientHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }
    
    default String comment(ServerHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }

    public static enum Comment {
        sendResetRequest,
        receivedResetRequest,
        receivedResetResponse,
        sendResetResponse
        ;

        Comment(String... a){ this.a = StringUtils.arrayToCommaDelimitedString(a);}
        private String a = "";
        public String toString(){return a;}
    }    


    public interface ServerHandler extends Reset, ResetOffer {
        public static ServerHandler DEFAULT = new ServerHandler(){
            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public ResetRequest sendResetRequest(String id, Map<String, Object> req) {
                logger.info(comment(this, Comment.sendResetRequest, id));
                return ResetRequest.builder().build();
            }

            @Override
            public void receivedResetResponse(String id, ResetResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.receivedResetResponse, id));
            }
           
        };

    }


    public interface ClientHandler extends Reset, ResetAnswer {
        public static ClientHandler DEFAULT = new ClientHandler(){
            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public ResetResponse receivedResetRequest(String id, ResetRequest req) {
                logger.info(comment(this, Comment.receivedResetRequest, id));
                return ResetResponse.builder().build();
            }

            @Override
            public void sendResetResponse(String id, ResetResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.sendResetResponse, id));
            }
           
        };
    }       
}
