package io.u2ware.ocpp.v1_6.usecase;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

import io.u2ware.ocpp.v1_6.actions.*;
import io.u2ware.ocpp.v1_6.exception.*;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.messaging.Specification;

public interface GetCompositeSchedule {
    
    public static Specification.Section section = Specification.InitiatedByCentralSystem.Usecase.GetCompositeSchedule;

    default String comment(ClientHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }
    
    default String comment(ServerHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }

    public static enum Comment {
        sendGetCompositeScheduleRequest,
        receivedGetCompositeScheduleRequest,
        receivedGetCompositeScheduleResponse,
        sendGetCompositeScheduleResponse
        ;

        Comment(String... a){ this.a = StringUtils.arrayToCommaDelimitedString(a);}
        private String a = "";
        public String toString(){return a;}
    }    


    public interface ServerHandler extends GetCompositeSchedule, GetCompositeScheduleOffer {
        public static ServerHandler DEFAULT = new ServerHandler(){
            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public GetCompositeScheduleRequest sendGetCompositeScheduleRequest(String id, Map<String, Object> req) {
                logger.info(comment(this, Comment.sendGetCompositeScheduleRequest, id));
                return GetCompositeScheduleRequest.builder().build();
            }

            @Override
            public void receivedGetCompositeScheduleResponse(String id, GetCompositeScheduleResponse res,
                    ErrorCode err) {
                logger.info(comment(this, Comment.receivedGetCompositeScheduleResponse, id));
            }
        };

    }


    public interface ClientHandler extends GetCompositeSchedule, GetCompositeScheduleAnswer {
        public static ClientHandler DEFAULT = new ClientHandler(){
            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public GetCompositeScheduleResponse receivedGetCompositeScheduleRequest(String id,
                    GetCompositeScheduleRequest req) {
                logger.info(comment(this, Comment.receivedGetCompositeScheduleRequest, id));
                return GetCompositeScheduleResponse.builder().build();
            }

            @Override
            public void sendGetCompositeScheduleResponse(String id, GetCompositeScheduleResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.sendGetCompositeScheduleResponse, id));
            }
        };
    }  
}
