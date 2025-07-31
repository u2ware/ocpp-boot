package io.u2ware.ocpp.test.client4;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.handlers.Heartbeat;
import io.u2ware.ocpp.v1_6.handlers.StartTransaction;
import io.u2ware.ocpp.v1_6.messaging.ChargePointCommand;
import io.u2ware.ocpp.v1_6.messaging.ChargePointCommandOperations;
import io.u2ware.ocpp.v1_6.model.HeartbeatRequest;
import io.u2ware.ocpp.v1_6.model.HeartbeatResponse;
import io.u2ware.ocpp.v1_6.model.StartTransactionRequest;
import io.u2ware.ocpp.v1_6.model.StartTransactionResponse;

@Component
public class OcppClientHandler implements Heartbeat.ChargePointHandler, StartTransaction.ChargePointHandler{

    protected Log logger = LogFactory.getLog(getClass());

    private @Autowired ChargePointCommandOperations ocppOperations;


    @Override
    public String[] features() {
        return new String[]{"Heartbeat", "StartTransaction"};
    }

    @Override
    public HeartbeatRequest sendHeartbeatRequest(String id, Map<String, Object> req) {
        logger.info(String.format("\n\n\tSTEP[1/8] sendHeartbeatRequest(%s)\n", id));
        return HeartbeatRequest.builder().build();
    }

    @Override
    public void receivedHeartbeatResponse(String id, HeartbeatResponse res, ErrorCode err) {
        logger.info(String.format("\n\n\tSTEP[3/8] receivedHeartbeatResponse(%s)\n", id));
        ocppOperations.send(ChargePointCommand.ALL.StartTransaction.build());
    } 

    @Override
    public StartTransactionRequest sendStartTransactionRequest(String id, Map<String, Object> req) {
        logger.info(String.format("\n\n\tSTEP[5/8] sendStartTransactionRequest(%s)\n", id));
        return StartTransactionRequest.builder().build();
    }

    @Override
    public void receivedStartTransactionResponse(String id, StartTransactionResponse res, ErrorCode err) {
        logger.info(String.format("\n\n\tSTEP[7/8] receivedStartTransactionResponse(%s)\n", id));
    }





    
}
