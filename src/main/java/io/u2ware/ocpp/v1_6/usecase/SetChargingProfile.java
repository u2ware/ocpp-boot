package io.u2ware.ocpp.v1_6.usecase;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

import io.u2ware.ocpp.v1_6.actions.*;
import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.messaging.Specification;
import io.u2ware.ocpp.v1_6.model.*;

public interface SetChargingProfile {
    
    public static Specification.Section section = Specification.InitiatedByCentralSystem.SetChargingProfile;

    default String comment(ClientHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }
    
    default String comment(ServerHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }

    public static enum Comment {
        sendSetChargingProfileRequest,
        receivedSetChargingProfileRequest,
        receivedSetChargingProfileResponse,
        sendSetChargingProfileResponse,

        ;

        Comment(String... a){ this.a = StringUtils.arrayToCommaDelimitedString(a);}
        private String a = "";
        public String toString(){return a;}
    } 

    public interface ServerHandler extends SetChargingProfile, SetChargingProfileOffer {       


        public static ServerHandler DEFAULT = new ServerHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public SetChargingProfileRequest sendSetChargingProfileRequest(String id, Map<String, Object> req) {
                logger.info(comment(this, Comment.sendSetChargingProfileRequest, id));
                return new SetChargingProfileRequest();
            }

            @Override
            public void receivedSetChargingProfileResponse(String id, SetChargingProfileResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.receivedSetChargingProfileResponse, id));
            }

        };
    }


    public interface ClientHandler extends SetChargingProfile, SetChargingProfileAnswer {       


        public static ClientHandler DEFAULT = new ClientHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public SetChargingProfileResponse receivedSetChargingProfileRequest(String id, SetChargingProfileRequest req) {
                logger.info(comment(this, Comment.receivedSetChargingProfileRequest, id));
                return new SetChargingProfileResponse();
            }

            @Override
            public void sendSetChargingProfileResponse(String id, SetChargingProfileResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.sendSetChargingProfileResponse, id));
            }

        };
    }


}
