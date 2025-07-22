package io.u2ware.ocpp.v1_6.usecase;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

import io.u2ware.ocpp.v1_6.actions.*;
import io.u2ware.ocpp.v1_6.exception.*;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.messaging.Specification;

public interface ChangeAvailability {
    
    public static Specification.Section section = Specification.InitiatedByCentralSystem.Usecase.ChangeAvailability;

    default String comment(ClientHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }
    
    default String comment(ServerHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }

    public static enum Comment {
        sendChangeAvailabilityRequest,
        receivedChangeAvailabilityRequest,
        receivedChangeAvailabilityResponse,
        sendChangeAvailabilityResponse
        ;

        Comment(String... a){ this.a = StringUtils.arrayToCommaDelimitedString(a);}
        private String a = "";
        public String toString(){return a;}
    }    


    public interface ServerHandler  extends ChangeAvailability, ChangeAvailabilityOffer {
        public static ServerHandler DEFAULT = new ServerHandler(){
            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public ChangeAvailabilityRequest sendChangeAvailabilityRequest(String id, Map<String, Object> req) {
                logger.info(comment(this, Comment.sendChangeAvailabilityRequest, id));
                return ChangeAvailabilityRequest.builder().build();

            }

            @Override
            public void receivedChangeAvailabilityResponse(String id, ChangeAvailabilityResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.receivedChangeAvailabilityResponse, id));

            }


        }; 

    }


    public interface ClientHandler extends ChangeAvailability, ChangeAvailabilityAnswer {
        public static ClientHandler DEFAULT = new ClientHandler(){
            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public ChangeAvailabilityResponse receivedChangeAvailabilityRequest(String id,
                    ChangeAvailabilityRequest req) {
                logger.info(comment(this, Comment.receivedChangeAvailabilityRequest, id));
                return ChangeAvailabilityResponse.builder().build();
            }

            @Override
            public void sendChangeAvailabilityResponse(String id, ChangeAvailabilityResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.sendChangeAvailabilityResponse, id));

            }


        }; 
    }    
        
}
