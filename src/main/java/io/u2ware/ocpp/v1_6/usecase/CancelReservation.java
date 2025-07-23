package io.u2ware.ocpp.v1_6.usecase;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

import io.u2ware.ocpp.v1_6.actions.*;
import io.u2ware.ocpp.v1_6.exception.*;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.messaging.Specification;

public interface CancelReservation {

    public static Specification.Section section = Specification.InitiatedByCentralSystem.CancelReservation;

    default String comment(ClientHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }
    
    default String comment(ServerHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }

    public static enum Comment {
        sendCancelReservationRequest,
        receivedCancelReservationRequest,
        receivedCancelReservationResponse,
        sendCancelReservationResponse
        ;

        Comment(String... a){ this.a = StringUtils.arrayToCommaDelimitedString(a);}
        private String a = "";
        public String toString(){return a;}
    }    


    public interface ServerHandler  extends CancelReservation, CancelReservationOffer {
        public static ServerHandler DEFAULT = new ServerHandler(){
            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public CancelReservationRequest sendCancelReservationRequest(String id, Map<String, Object> req) {
                logger.info(comment(this, Comment.sendCancelReservationRequest, id));
                return CancelReservationRequest.builder().build();
            }

            @Override
            public void receivedCancelReservationResponse(String id, CancelReservationResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.receivedCancelReservationResponse, id));

            }


        }; 

    }


    public interface ClientHandler extends CancelReservation, CancelReservationAnswer {
        public static ClientHandler DEFAULT = new ClientHandler(){
            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public CancelReservationResponse receivedCancelReservationRequest(String id, CancelReservationRequest req) {
                logger.info(comment(this, Comment.receivedCancelReservationRequest, id));
                return CancelReservationResponse.builder().build();
            }

            @Override
            public void sendCancelReservationResponse(String id, CancelReservationResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.sendCancelReservationResponse, id));

            }


        }; 
    }    
    

    
}
