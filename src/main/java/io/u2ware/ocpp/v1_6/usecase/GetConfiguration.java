package io.u2ware.ocpp.v1_6.usecase;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

import io.u2ware.ocpp.v1_6.actions.*;
import io.u2ware.ocpp.v1_6.exception.*;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.messaging.Specification;

public interface GetConfiguration {
    
    public static Specification.Section section = Specification.InitiatedByCentralSystem.GetConfiguration;

    default String comment(ClientHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }
    
    default String comment(ServerHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }

    public static enum Comment {
        sendGetConfigurationRequest,
        receivedGetConfigurationRequest,
        receivedGetConfigurationResponse,
        sendGetConfigurationResponse
        ;

        Comment(String... a){ this.a = StringUtils.arrayToCommaDelimitedString(a);}
        private String a = "";
        public String toString(){return a;}
    }    


    public interface ServerHandler extends GetConfiguration, GetConfigurationOffer {
        public static ServerHandler DEFAULT = new ServerHandler(){
            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public GetConfigurationRequest sendGetConfigurationRequest(String id, Map<String, Object> req) {
                logger.info(comment(this, Comment.sendGetConfigurationRequest, id));
                return GetConfigurationRequest.builder().build();
            }

            @Override
            public void receivedGetConfigurationResponse(String id, GetConfigurationResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.receivedGetConfigurationResponse, id));
            }
        };

    }


    public interface ClientHandler extends GetConfiguration, GetConfigurationAnswer {
        public static ClientHandler DEFAULT = new ClientHandler(){
            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public GetConfigurationResponse receivedGetConfigurationRequest(String id, GetConfigurationRequest req) {
                logger.info(comment(this, Comment.receivedGetConfigurationRequest, id));
                return GetConfigurationResponse.builder().build();
            }

            @Override
            public void sendGetConfigurationResponse(String id, GetConfigurationResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.sendGetConfigurationResponse, id));
            }
        };

    }      
}
