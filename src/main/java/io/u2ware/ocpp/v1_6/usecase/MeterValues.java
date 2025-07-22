package io.u2ware.ocpp.v1_6.usecase;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

import io.u2ware.ocpp.v1_6.actions.*;
import io.u2ware.ocpp.v1_6.exception.*;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.messaging.Specification;

public interface MeterValues {
    
    public static Specification.Section section = Specification.InitiatedByChargePoint.Usecase.MeterValues;

    default String comment(ClientHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }
    
    default String comment(ServerHandler handler, Comment comment, String id) {
        return section.comment(Comment.values(), comment, id);                
    }

    public static enum Comment {
        sendMeterValuesRequest,
        receivedMeterValuesRequest,
        receivedMeterValuesResponse,
        sendMeterValuesResponse
        ;

        Comment(String... a){ this.a = StringUtils.arrayToCommaDelimitedString(a);}
        private String a = "";
        public String toString(){return a;}
    }  

    public interface ClientHandler extends MeterValues, MeterValuesOffer {

        public static ClientHandler DEFAULT = new ClientHandler(){
            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public MeterValuesRequest sendMeterValuesRequest(String id, Map<String, Object> req) {
                logger.info(comment(this, Comment.sendMeterValuesRequest, id));
                return MeterValuesRequest.builder().build();
            }

            @Override
            public void receivedMeterValuesResponse(String id, MeterValuesResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.receivedMeterValuesResponse, id));
            }
        };

    }


    public interface ServerHandler extends MeterValues, MeterValuesAnswer {
        
        public static ServerHandler DEFAULT = new ServerHandler(){
            protected Log logger = LogFactory.getLog(getClass());

            @Override
            public MeterValuesResponse receivedMeterValuesRequest(String id, MeterValuesRequest req) {
                logger.info(comment(this, Comment.receivedMeterValuesRequest, id));
                return MeterValuesResponse.builder().build();
            }

            @Override
            public void sendMeterValuesResponse(String id, MeterValuesResponse res, ErrorCode err) {
                logger.info(comment(this, Comment.sendMeterValuesResponse, id));
            }
        };
    }
    
}
