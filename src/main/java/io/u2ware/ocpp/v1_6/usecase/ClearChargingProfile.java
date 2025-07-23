package io.u2ware.ocpp.v1_6.usecase;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

import io.u2ware.ocpp.v1_6.actions.*;
import io.u2ware.ocpp.v1_6.exception.*;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.messaging.Specification;

public interface ClearChargingProfile {
    
    public static Specification.Section section = Specification.InitiatedByCentralSystem.ClearChargingProfile;

    default String comment(ClientHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }
    
    default String comment(ServerHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }

    public static enum Comment {
        sendClearChargingProfileRequest,
        receivedClearChargingProfileRequest,
        receivedClearChargingProfileResponse,
        sendBootNotificationRequest
        ;

        Comment(String... a){ this.a = StringUtils.arrayToCommaDelimitedString(a);}
        private String a = "";
        public String toString(){return a;}
    }    


    public interface ServerHandler extends ClearChargingProfile, ClearChargingProfileOffer {

        public static ServerHandler DEFAULT = new ServerHandler(){
            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public ClearChargingProfileRequest sendClearChargingProfileRequest(String id, Map<String, Object> req) {
                logger.info(comment(this, Comment.sendClearChargingProfileRequest, id));
                return ClearChargingProfileRequest.builder().build();

            }

            @Override
            public void receivedClearChargingProfileResponse(String id, ClearChargingProfileResponse res,
                    ErrorCode err) {
                logger.info(comment(this, Comment.receivedClearChargingProfileResponse, id));

            }


        };        

    }


    public interface ClientHandler extends ClearChargingProfile, ClearChargingProfileAnswer {
        public static ClientHandler DEFAULT = new ClientHandler(){
            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public ClearChargingProfileResponse receivedClearChargingProfileRequest(String id,
                    ClearChargingProfileRequest req) {
                logger.info(comment(this, Comment.receivedClearChargingProfileRequest, id));
                return ClearChargingProfileResponse.builder().build();
            }

            @Override
            public void sendClearChargingProfileResponse(String id, ClearChargingProfileResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.sendBootNotificationRequest, id));
            }


        }; 
    }    
}
