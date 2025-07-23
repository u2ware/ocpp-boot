package io.u2ware.ocpp.v1_6.usecase;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

import io.u2ware.ocpp.v1_6.actions.*;
import io.u2ware.ocpp.v1_6.exception.*;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.messaging.Specification;

public interface GetLocalListVersion {
    
    public static Specification.Section section = Specification.InitiatedByCentralSystem.GetLocalListVersion;

    default String comment(ClientHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }
    
    default String comment(ServerHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }

    public static enum Comment {
        sendGetLocalListVersionRequest,
        receivedGetLocalListVersionRequest,
        receivedGetLocalListVersionResponse,
        sendGetLocalListVersionResponse
        ;

        Comment(String... a){ this.a = StringUtils.arrayToCommaDelimitedString(a);}
        private String a = "";
        public String toString(){return a;}
    }    


    public interface ServerHandler extends GetLocalListVersion, GetLocalListVersionOffer {

        public static ServerHandler DEFAULT = new ServerHandler(){
            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public GetLocalListVersionRequest sendGetLocalListVersionRequest(String id, Map<String, Object> req) {
                logger.info(comment(this, Comment.sendGetLocalListVersionRequest, id));
                return GetLocalListVersionRequest.builder().build();
            }

            @Override
            public void receivedGetLocalListVersionResponse(String id, GetLocalListVersionResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.receivedGetLocalListVersionResponse, id));
            }
        };
    }


    public interface ClientHandler extends GetLocalListVersion, GetLocalListVersionAnswer {
        public static ClientHandler DEFAULT = new ClientHandler(){
            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public GetLocalListVersionResponse receivedGetLocalListVersionRequest(String id,
                    GetLocalListVersionRequest req) {
                logger.info(comment(this, Comment.receivedGetLocalListVersionRequest, id));
                return GetLocalListVersionResponse.builder().build();
            }

            @Override
            public void sendGetLocalListVersionResponse(String id, GetLocalListVersionResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.sendGetLocalListVersionResponse, id));
            }
        };

    }   
}
