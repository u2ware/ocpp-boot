package io.u2ware.ocpp.v1_6.usecase;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

import io.u2ware.ocpp.v1_6.actions.*;
import io.u2ware.ocpp.v1_6.exception.*;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.messaging.Specification;

public interface ChangeConfiguration {

    public static Specification.Section section = Specification.InitiatedByCentralSystem.Usecase.ChangeConfiguration;

    default String comment(ClientHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }
    
    default String comment(ServerHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }

    public static enum Comment {
        sendChangeConfigurationRequest,
        receivedChangeConfigurationRequest,
        receivedChangeConfigurationResponse,
        sendChangeConfigurationResponse
        ;

        Comment(String... a){ this.a = StringUtils.arrayToCommaDelimitedString(a);}
        private String a = "";
        public String toString(){return a;}
    }    


    public interface ServerHandler extends ChangeConfiguration, ChangeConfigurationOffer {
        public static ServerHandler DEFAULT = new ServerHandler(){
            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public ChangeConfigurationRequest sendChangeConfigurationRequest(String id, Map<String, Object> req) {
                logger.info(comment(this, Comment.sendChangeConfigurationRequest, id));
                return ChangeConfigurationRequest.builder().build();

            }

            @Override
            public void receivedChangeConfigurationResponse(String id, ChangeConfigurationResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.receivedChangeConfigurationResponse, id));

            }


        }; 

    }


    public interface ClientHandler extends ChangeConfiguration, ChangeConfigurationAnswer {
        public static ClientHandler DEFAULT = new ClientHandler(){
            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public ChangeConfigurationResponse receivedChangeConfigurationRequest(String id,
                    ChangeConfigurationRequest req) {
                logger.info(comment(this, Comment.receivedChangeConfigurationRequest, id));
                return ChangeConfigurationResponse.builder().build();

            }

            @Override
            public void sendChangeConfigurationResponse(String id, ChangeConfigurationResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.sendChangeConfigurationResponse, id));

            }


        }; 
    }    
    
}
