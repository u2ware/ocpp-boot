package io.u2ware.ocpp.v2_0_1.usecase;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

import io.u2ware.ocpp.v2_0_1.actions.*;
import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_0_1.messaging.Specification;
import io.u2ware.ocpp.v2_0_1.model.*;

public interface A01 {
   
    public static Specification.Section section = Specification.Security.Usecase.A01;

    default String comment(ClientHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }
    
    default String comment(ServerHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }

    public static enum Comment {
        sendSetVariablesRequest,
        receivedSetVariablesRequest,
        receivedSetVariablesResponse("disconnect", "connect (using new password)"),
        sendSetVariablesResponse,
        ;

        Comment(String... a){ this.a = StringUtils.arrayToCommaDelimitedString(a);}
        private String a = "";
        public String toString(){return a;}
    }
  
    public interface ServerHandler extends A01, SetVariablesOffer{

        public static ServerHandler DEFAULT = new ServerHandler(){

            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public SetVariablesRequest sendSetVariablesRequest(String id, Map<String,Object> req) {
                logger.info(comment(this, Comment.sendSetVariablesRequest, id));
                return new SetVariablesRequest();
            }
            @Override
            public void receivedSetVariablesResponse(String id, SetVariablesResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.receivedSetVariablesResponse, id));
            }
        };

    }

    public interface ClientHandler extends A01, SetVariablesAnswer {

        public static ClientHandler DEFAULT = new ClientHandler(){ 

            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public SetVariablesResponse receivedSetVariablesRequest(String id, SetVariablesRequest req) {
                logger.info(comment(this, Comment.receivedSetVariablesRequest, id));
                return new SetVariablesResponse();
            }

            @Override
            public void sendSetVariablesResponse(String id, SetVariablesResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.sendSetVariablesResponse, id));
            }
        };

    }
}