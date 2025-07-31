package io.u2ware.ocpp.test.client4;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.handlers.Heartbeat;
import io.u2ware.ocpp.v1_6.handlers.StartTransaction;
import io.u2ware.ocpp.v1_6.model.HeartbeatRequest;
import io.u2ware.ocpp.v1_6.model.HeartbeatResponse;
import io.u2ware.ocpp.v1_6.model.StartTransactionRequest;
import io.u2ware.ocpp.v1_6.model.StartTransactionResponse;


public class OcppServerHandler implements Heartbeat.CentralSystemHandler, StartTransaction.CentralSystemHandler{

    protected Log logger = LogFactory.getLog(getClass());


    @Override
    public String[] features() {
        return new String[]{"Heartbeat", "StartTransaction"};
    }

    @Override
    public HeartbeatResponse receivedHeartbeatRequest(String id, HeartbeatRequest req) {
        logger.info(String.format("\n\n\tSTEP[2/8] receivedHeartbeatRequest(%s)\n", id));
        return HeartbeatResponse.builder().build();
    }

    @Override
    public void sendHeartbeatResponse(String id, HeartbeatResponse res, ErrorCode err) {
        logger.info(String.format("\n\n\tSTEP[4/8] sendHeartbeatResponse(%s)\n", id));
    }

    @Override
    public StartTransactionResponse receivedStartTransactionRequest(String id, StartTransactionRequest arg1) {
        logger.info(String.format("\n\n\tSTEP[6/8] receivedStartTransactionRequest(%s)\n", id));
        return StartTransactionResponse.builder().build();
    }

    @Override
    public void sendStartTransactionResponse(String id, StartTransactionResponse arg1, ErrorCode arg2) {
        logger.info(String.format("\n\n\tSTEP[8/8] sendStartTransactionResponse(%s)\n", id));
    }
}
