package io.u2ware.ocpp.v1_6.usecase;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

import io.u2ware.ocpp.v1_6.actions.*;
import io.u2ware.ocpp.v1_6.exception.*;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.messaging.Specification;

public interface ReserveNow {
    
    public static Specification.Section section = Specification.InitiatedByCentralSystem.ReserveNow;

    default String comment(ClientHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }
    
    default String comment(ServerHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }

    public static enum Comment {
        sendReserveNowRequest,
        receivedReserveNowRequest,
        receivedReserveNowResponse,
        sendReserveNowResponse
        ;

        Comment(String... a){ this.a = StringUtils.arrayToCommaDelimitedString(a);}
        private String a = "";
        public String toString(){return a;}
    }    


    public interface ServerHandler extends ReserveNow, ReserveNowOffer {
        public static ServerHandler DEFAULT = new ServerHandler(){
            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public ReserveNowRequest sendReserveNowRequest(String id, Map<String, Object> req) {
                logger.info(comment(this, Comment.sendReserveNowRequest, id));
                return ReserveNowRequest.builder().build();
            }

            @Override
            public void receivedReserveNowResponse(String id, ReserveNowResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.receivedReserveNowResponse, id));
            }
           
        };


    }


    public interface ClientHandler extends ReserveNow, ReserveNowAnswer {
        public static ClientHandler DEFAULT = new ClientHandler(){
            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public ReserveNowResponse receivedReserveNowRequest(String id, ReserveNowRequest req) {
                logger.info(comment(this, Comment.receivedReserveNowRequest, id));
                return ReserveNowResponse.builder().build();
            }

            @Override
            public void sendReserveNowResponse(String id, ReserveNowResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.sendReserveNowResponse, id));
            }
           
        };
    }     
}
