package io.u2ware.ocpp.test.server4;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.handlers.RemoteStartTransaction;
import io.u2ware.ocpp.v1_6.handlers.RemoteStopTransaction;
import io.u2ware.ocpp.v1_6.handlers.StartTransaction;
import io.u2ware.ocpp.v1_6.handlers.StopTransaction;
import io.u2ware.ocpp.v1_6.messaging.ChargePointCommand;
import io.u2ware.ocpp.v1_6.messaging.ChargePointCommandOperations;
import io.u2ware.ocpp.v1_6.model.RemoteStartTransactionRequest;
import io.u2ware.ocpp.v1_6.model.RemoteStartTransactionResponse;
import io.u2ware.ocpp.v1_6.model.RemoteStopTransactionRequest;
import io.u2ware.ocpp.v1_6.model.RemoteStopTransactionResponse;
import io.u2ware.ocpp.v1_6.model.StartTransactionRequest;
import io.u2ware.ocpp.v1_6.model.StartTransactionResponse;
import io.u2ware.ocpp.v1_6.model.StopTransactionRequest;
import io.u2ware.ocpp.v1_6.model.StopTransactionResponse;

public class OcppClientHandler implements RemoteStartTransaction.ChargePointHandler, StartTransaction.ChargePointHandler, RemoteStopTransaction.ChargePointHandler, StopTransaction.ChargePointHandler { 

    protected final Log logger = LogFactory.getLog(getClass());

    private ChargePointCommandOperations ocppOperations;

    public OcppClientHandler(ChargePointCommandOperations ocppOperations){
        this.ocppOperations = ocppOperations;
    }

    @Override
    public String[] features() {
        return new String[]{"myModule"};
    }

    @Override
    public RemoteStartTransactionResponse receivedRemoteStartTransactionRequest(String id, RemoteStartTransactionRequest req) {
        logger.info(String.format("\n\n\tSTEP[2/16] receivedRemoteStartTransactionRequest(%s)\n", id));
        return RemoteStartTransactionResponse.builder().build();
    }

    @Override
    public void sendRemoteStartTransactionResponse(String id, RemoteStartTransactionResponse res, ErrorCode err) {
        logger.info(String.format("\n\n\tSTEP[4/8] sendRemoteStartTransactionResponse(%s)\n", id));
        ocppOperations.send(ChargePointCommand.ALL.StartTransaction.buildWith("myModule"));
    }

    @Override
    public StartTransactionRequest sendStartTransactionRequest(String id, Map<String, Object> req) {
        logger.info(String.format("\n\n\tSTEP[5/16] sendStartTransactionRequest(%s)\n", id));
        return StartTransactionRequest.builder().build();
    }

    @Override
    public void receivedStartTransactionResponse(String id, StartTransactionResponse res, ErrorCode err) {
        logger.info(String.format("\n\n\tSTEP[7/16] receivedStartTransactionResponse(%s)\n", id));
    }

    @Override
    public RemoteStopTransactionResponse receivedRemoteStopTransactionRequest(String id, RemoteStopTransactionRequest req) {
        logger.info(String.format("\n\n\tSTEP[10/16] receivedRemoteStopTransactionRequest(%s)\n", id));
        return RemoteStopTransactionResponse.builder().build();
    }

    @Override
    public void sendRemoteStopTransactionResponse(String id, RemoteStopTransactionResponse res, ErrorCode err) {
        logger.info(String.format("\n\n\tSTEP[12/16] sendRemoteStopTransactionResponse(%s)\n", id));
        ocppOperations.send(ChargePointCommand.ALL.StopTransaction.buildWith("myModule"));
    }

    @Override
    public StopTransactionRequest sendStopTransactionRequest(String id, Map<String, Object> req) {
        logger.info(String.format("\n\n\tSTEP[13/16] sendStopTransactionRequest(%s)\n", id));
        return StopTransactionRequest.builder().build();
    }

    @Override
    public void receivedStopTransactionResponse(String id, StopTransactionResponse res, ErrorCode err) {
        logger.info(String.format("\n\n\tSTEP[15/16] receivedStopTransactionResponse(%s)\n", id));
    }
}
