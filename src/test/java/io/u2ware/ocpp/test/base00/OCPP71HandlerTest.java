package io.u2ware.ocpp.test.base00;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.handlers.Authorize;
import io.u2ware.ocpp.v1_6.handlers.BootNotification;
import io.u2ware.ocpp.v1_6.handlers.Heartbeat;
import io.u2ware.ocpp.v1_6.messaging.ChargePoint;
import io.u2ware.ocpp.v1_6.model.AuthorizeRequest;
import io.u2ware.ocpp.v1_6.model.AuthorizeResponse;
import io.u2ware.ocpp.v1_6.model.BootNotificationRequest;
import io.u2ware.ocpp.v1_6.model.BootNotificationResponse;
import io.u2ware.ocpp.v1_6.model.HeartbeatRequest;
import io.u2ware.ocpp.v1_6.model.HeartbeatResponse;

public class OCPP71HandlerTest {
    
    protected final Log logger = LogFactory.getLog(getClass());


    @Test
    public void context1Loads()  throws Exception{
        logger.info("-------------------");

        ChargePoint cp = new ChargePoint();
        MultiValueMap<String,Object> metadata = new LinkedMultiValueMap<>();


        cp.registerHandler(new HandlerA(), metadata);
        cp.registerHandler(new HandlerB(), metadata);
        cp.registerHandler(new HandlerC(), metadata);
        cp.registerHandler(new HandlerD(), metadata);
        System.err.println(metadata);


        // CentralSystem cs = new CentralSystem();
    }



    public static class HandlerA implements Authorize.ChargePointHandler {

        @Override
        public AuthorizeRequest sendAuthorizeRequest(String id, Map<String, Object> req) {
            throw new UnsupportedOperationException("Unimplemented method 'sendAuthorizeRequest'");
        }

        @Override
        public void receivedAuthorizeResponse(String id, AuthorizeResponse res, ErrorCode err) {
            throw new UnsupportedOperationException("Unimplemented method 'receivedAuthorizeResponse'");
        }
    }

    public static class HandlerB implements Authorize.ChargePointHandler {

        @Override
        public String usecase() {
            return "HelloWorld";
        }

        @Override
        public Boolean actions() {
            return false;
        }


        @Override
        public AuthorizeRequest sendAuthorizeRequest(String id, Map<String, Object> req) {
            throw new UnsupportedOperationException("Unimplemented method 'sendAuthorizeRequest'");
        }

        @Override
        public void receivedAuthorizeResponse(String id, AuthorizeResponse res, ErrorCode err) {
            throw new UnsupportedOperationException("Unimplemented method 'receivedAuthorizeResponse'");
        }
    }


    public static class HandlerC implements BootNotification.ChargePointHandler, Heartbeat.ChargePointHandler {

        @Override
        public BootNotificationRequest sendBootNotificationRequest(String id, Map<String, Object> req) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'sendBootNotificationRequest'");
        }
        @Override
        public void receivedBootNotificationResponse(String id, BootNotificationResponse res, ErrorCode err) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'receivedBootNotificationResponse'");
        }
        @Override
        public HeartbeatRequest sendHeartbeatRequest(String id, Map<String, Object> req) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'sendHeartbeatRequest'");
        }
        @Override
        public void receivedHeartbeatResponse(String id, HeartbeatResponse res, ErrorCode err) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'receivedHeartbeatResponse'");
        }
    }

    public static class HandlerD implements BootNotification.ChargePointHandler, Heartbeat.ChargePointHandler {


        @Override
        public String usecase() {
            return "World";
        }

        @Override
        public Boolean actions() {
            return true;
        }

        @Override
        public BootNotificationRequest sendBootNotificationRequest(String id, Map<String, Object> req) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'sendBootNotificationRequest'");
        }
        @Override
        public void receivedBootNotificationResponse(String id, BootNotificationResponse res, ErrorCode err) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'receivedBootNotificationResponse'");
        }
        @Override
        public HeartbeatRequest sendHeartbeatRequest(String id, Map<String, Object> req) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'sendHeartbeatRequest'");
        }
        @Override
        public void receivedHeartbeatResponse(String id, HeartbeatResponse res, ErrorCode err) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'receivedHeartbeatResponse'");
        }
    }


}
