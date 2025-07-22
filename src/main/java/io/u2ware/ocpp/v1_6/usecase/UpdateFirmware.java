package io.u2ware.ocpp.v1_6.usecase;


import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

import io.u2ware.ocpp.v1_6.actions.*;
import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.messaging.Specification;
import io.u2ware.ocpp.v1_6.model.*;

public interface UpdateFirmware {
    
    public static Specification.Section section = Specification.InitiatedByCentralSystem.Usecase.UpdateFirmware;

    default String comment(ClientHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }
    
    default String comment(ServerHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }

    public static enum Comment {
        sendUpdateFirmwareRequest,
        receivedUpdateFirmwareRequest,
        receivedUpdateFirmwareResponse,
        sendUpdateFirmwareResponse,
        ;

        Comment(String... a){ this.a = StringUtils.arrayToCommaDelimitedString(a);}
        private String a = "";
        public String toString(){return a;}
    }    


    public interface ServerHandler extends UpdateFirmware, UpdateFirmwareOffer {

        public static ServerHandler DEFAULT = new ServerHandler(){
            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public UpdateFirmwareRequest sendUpdateFirmwareRequest(String id, Map<String, Object> req) {
                logger.info(comment(this, Comment.sendUpdateFirmwareRequest, id));
                return UpdateFirmwareRequest.builder().build();
            }

            @Override
            public void receivedUpdateFirmwareResponse(String id, UpdateFirmwareResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.receivedUpdateFirmwareResponse, id));
            }
        };
    }


    public interface ClientHandler extends UpdateFirmware, UpdateFirmwareAnswer {
        public static ClientHandler DEFAULT = new ClientHandler(){
            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public UpdateFirmwareResponse receivedUpdateFirmwareRequest(String id, UpdateFirmwareRequest req) {
                logger.info(comment(this, Comment.receivedUpdateFirmwareRequest, id));
                return UpdateFirmwareResponse.builder().build();
            }

            @Override
            public void sendUpdateFirmwareResponse(String id, UpdateFirmwareResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.sendUpdateFirmwareResponse, id));
            }
        };

    }  

}
