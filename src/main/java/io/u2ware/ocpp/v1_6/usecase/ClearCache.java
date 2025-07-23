package io.u2ware.ocpp.v1_6.usecase;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

import io.u2ware.ocpp.v1_6.actions.*;
import io.u2ware.ocpp.v1_6.exception.*;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.messaging.Specification;

public interface ClearCache {
    
    public static Specification.Section section = Specification.InitiatedByCentralSystem.ClearCache;

    default String comment(ClientHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }
    
    default String comment(ServerHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }

    public static enum Comment {
        sendClearCacheRequest,
        receivedClearCacheRequest,
        receivedClearCacheResponse,
        sendClearCacheResponse
        ;

        Comment(String... a){ this.a = StringUtils.arrayToCommaDelimitedString(a);}
        private String a = "";
        public String toString(){return a;}
    }    


    public interface ServerHandler extends ClearCache, ClearCacheOffer {
        public static ServerHandler DEFAULT = new ServerHandler(){
            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public ClearCacheRequest sendClearCacheRequest(String id, Map<String, Object> req) {
                logger.info(comment(this, Comment.sendClearCacheRequest, id));
                return ClearCacheRequest.builder().build();
            }

            @Override
            public void receivedClearCacheResponse(String id, ClearCacheResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.receivedClearCacheResponse, id));
            }


        }; 

    }


    public interface ClientHandler extends ClearCache, ClearCacheAnswer {
        public static ClientHandler DEFAULT = new ClientHandler(){
            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public ClearCacheResponse receivedClearCacheRequest(String id, ClearCacheRequest req) {
                logger.info(comment(this, Comment.receivedClearCacheRequest, id));
                return ClearCacheResponse.builder().build();
            }

            @Override
            public void sendClearCacheResponse(String id, ClearCacheResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.sendClearCacheResponse, id));
            }


        }; 
    }    
}
