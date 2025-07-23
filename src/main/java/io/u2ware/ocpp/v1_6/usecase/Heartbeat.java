package io.u2ware.ocpp.v1_6.usecase;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

import io.u2ware.ocpp.v1_6.actions.*;
import io.u2ware.ocpp.v1_6.exception.*;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.messaging.Specification;

public interface Heartbeat {

    public static Specification.Section section = Specification.InitiatedByChargePoint.Heartbeat;

    default String comment(ClientHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }
    
    default String comment(ServerHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }

    public static enum Comment {
        sendHeartbeatRequest,
        receivedHeartbeatRequest,
        receivedHeartbeatResponse,
        sendHeartbeatResponse
        ;

        Comment(String... a){ this.a = StringUtils.arrayToCommaDelimitedString(a);}
        private String a = "";
        public String toString(){return a;}
    }      
    
    public interface ClientHandler extends Heartbeat, HeartbeatOffer {

        public static ClientHandler DEFAULT = new ClientHandler(){
            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public HeartbeatRequest sendHeartbeatRequest(String id, Map<String, Object> req) {
                logger.info(comment(this, Comment.sendHeartbeatRequest, id));
                return HeartbeatRequest.builder().build();
            }

            @Override
            public void receivedHeartbeatResponse(String id, HeartbeatResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.receivedHeartbeatResponse, id));
            }
        };

    }


    public interface ServerHandler extends Heartbeat, HeartbeatAnswer {
        
        public static ServerHandler DEFAULT = new ServerHandler(){
            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public HeartbeatResponse receivedHeartbeatRequest(String id, HeartbeatRequest req) {
                logger.info(comment(this, Comment.receivedHeartbeatRequest, id));
                return HeartbeatResponse.builder().build();
            }

            @Override
            public void sendHeartbeatResponse(String id, HeartbeatResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.sendHeartbeatResponse, id));
            }
        };
    }
     
}
