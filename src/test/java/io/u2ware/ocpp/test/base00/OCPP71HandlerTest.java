package io.u2ware.ocpp.test.base00;

import java.util.ArrayList;
import java.util.Map;
import java.util.function.BiConsumer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.handlers.Authorize;
import io.u2ware.ocpp.v1_6.handlers.BootNotification;
import io.u2ware.ocpp.v1_6.handlers.ChangeAvailability;
import io.u2ware.ocpp.v1_6.handlers.DataTransfer;
import io.u2ware.ocpp.v1_6.handlers.Heartbeat;
import io.u2ware.ocpp.v1_6.handlers.MeterValues;
import io.u2ware.ocpp.v1_6.messaging.ChargePoint;
import io.u2ware.ocpp.v1_6.model.AuthorizeRequest;
import io.u2ware.ocpp.v1_6.model.AuthorizeResponse;
import io.u2ware.ocpp.v1_6.model.ChangeAvailabilityRequest;
import io.u2ware.ocpp.v1_6.model.ChangeAvailabilityResponse;
import io.u2ware.ocpp.v1_6.model.DataTransferRequest;
import io.u2ware.ocpp.v1_6.model.DataTransferResponse;
import io.u2ware.ocpp.v1_6.model.HeartbeatRequest;
import io.u2ware.ocpp.v1_6.model.HeartbeatResponse;
import io.u2ware.ocpp.v1_6.model.MeterValuesRequest;
import io.u2ware.ocpp.v1_6.model.MeterValuesResponse;

public class OCPP71HandlerTest {
    
    protected final Log logger = LogFactory.getLog(getClass());


    @Test
    public void context1Loads()  throws Exception{
        logger.info("-------------------");

        ChargePoint cp = new ChargePoint();
        MultiValueMap<String,String> metadata = new LinkedMultiValueMap<>();

        cp.registerHandler(new HandlerA(), metadata);
        cp.registerHandler(new HandlerB(), metadata);
        cp.registerHandler(new HandlerC(), metadata);
        cp.registerHandler(new HandlerD(), metadata);


        System.err.println(metadata);
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
            return "Hello";
        }

        @Override
        public Boolean actions() {
            return true;
        }

        @Override
        public AuthorizeRequest sendAuthorizeRequest(String id, Map<String, Object> req) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'sendAuthorizeRequest'");
        }

        @Override
        public void receivedAuthorizeResponse(String id, AuthorizeResponse res, ErrorCode err) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'receivedAuthorizeResponse'");
        }

    }












    public static class HandlerC implements ChangeAvailability.ChargePointHandler, Heartbeat.ChargePointHandler {

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
        @Override
        public ChangeAvailabilityResponse receivedChangeAvailabilityRequest(String id, ChangeAvailabilityRequest req) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'receivedChangeAvailabilityRequest'");
        }
        @Override
        public void sendChangeAvailabilityResponse(String id, ChangeAvailabilityResponse res, ErrorCode err) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'sendChangeAvailabilityResponse'");
        }
    }

    public static class HandlerD implements DataTransfer.ChargePointHandler, MeterValues.ChargePointHandler {


        @Override
        public String usecase() {
            return "World";
        }

        @Override
        public Boolean actions() {
            return true;
        }

        @Override
        public DataTransferRequest sendDataTransferRequest(String id, Map<String, Object> req) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'sendDataTransferRequest'");
        }

        @Override
        public void receivedDataTransferResponse(String id, DataTransferResponse res, ErrorCode err) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'receivedDataTransferResponse'");
        }

        @Override
        public DataTransferResponse receivedDataTransferRequest(String id, DataTransferRequest req) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'receivedDataTransferRequest'");
        }

        @Override
        public void sendDataTransferResponse(String id, DataTransferResponse res, ErrorCode err) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'sendDataTransferResponse'");
        }

        @Override
        public MeterValuesRequest sendMeterValuesRequest(String id, Map<String, Object> req) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'sendMeterValuesRequest'");
        }

        @Override
        public void receivedMeterValuesResponse(String id, MeterValuesResponse res, ErrorCode err) {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'receivedMeterValuesResponse'");
        }

    }


}
