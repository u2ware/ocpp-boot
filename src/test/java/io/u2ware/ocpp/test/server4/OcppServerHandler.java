package io.u2ware.ocpp.test.server4;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.handlers.RemoteStartTransaction;
import io.u2ware.ocpp.v1_6.handlers.RemoteStopTransaction;
import io.u2ware.ocpp.v1_6.handlers.StartTransaction;
import io.u2ware.ocpp.v1_6.handlers.StopTransaction;
import io.u2ware.ocpp.v1_6.messaging.CentralSystemCommand;
import io.u2ware.ocpp.v1_6.messaging.CentralSystemCommandOperations;
import io.u2ware.ocpp.v1_6.model.RemoteStartTransactionRequest;
import io.u2ware.ocpp.v1_6.model.RemoteStartTransactionResponse;
import io.u2ware.ocpp.v1_6.model.RemoteStopTransactionRequest;
import io.u2ware.ocpp.v1_6.model.RemoteStopTransactionResponse;
import io.u2ware.ocpp.v1_6.model.StartTransactionRequest;
import io.u2ware.ocpp.v1_6.model.StartTransactionResponse;
import io.u2ware.ocpp.v1_6.model.StopTransactionRequest;
import io.u2ware.ocpp.v1_6.model.StopTransactionResponse;

@Component
public class OcppServerHandler implements RemoteStartTransaction.CentralSystemHandler, StartTransaction.CentralSystemHandler, RemoteStopTransaction.CentralSystemHandler, StopTransaction.CentralSystemHandler {

    protected final Log logger = LogFactory.getLog(getClass());

    private CentralSystemCommandOperations ocppOperations;

    @Autowired
    public OcppServerHandler(CentralSystemCommandOperations ocppOperations){
        this.ocppOperations = ocppOperations;
    }

    @Override
    public String[] features() {
        return new String[]{"myModule"};
    }

    @Override
    public RemoteStartTransactionRequest sendRemoteStartTransactionRequest(String id, Map<String, Object> req) {
        logger.info(String.format("\n\n\tSTEP[1/16] sendRemoteStartTransactionRequest(%s)\n", id));
        return RemoteStartTransactionRequest.builder().build();
    }

    @Override
    public void receivedRemoteStartTransactionResponse(String id, RemoteStartTransactionResponse res, ErrorCode err) {
        logger.info(String.format("\n\n\tSTEP[3/16] receivedRemoteStartTransactionResponse(%s)\n", id));
    }

    @Override
    public StartTransactionResponse receivedStartTransactionRequest(String id, StartTransactionRequest req) {
        logger.info(String.format("\n\n\tSTEP[6/16] receivedStartTransactionRequest(%s)\n", id));
        return StartTransactionResponse.builder().build();
    }

    @Override
    public void sendStartTransactionResponse(String id, StartTransactionResponse res, ErrorCode err) {
        logger.info(String.format("\n\n\tSTEP[8/16] sendStartTransactionResponse(%s)\n", id));
        ocppOperations.send(CentralSystemCommand.ALL.RemoteStopTransaction.buildWith("myModule"));
    }

    @Override
    public RemoteStopTransactionRequest sendRemoteStopTransactionRequest(String id, Map<String, Object> req) {
        logger.info(String.format("\n\n\tSTEP[9/16] sendRemoteStopTransactionRequest(%s)\n", id));
        return RemoteStopTransactionRequest.builder().build();
    }

    @Override
    public void receivedRemoteStopTransactionResponse(String id, RemoteStopTransactionResponse res, ErrorCode err) {
        logger.info(String.format("\n\n\tSTEP[11/16] receivedRemoteStopTransactionResponse(%s)\n", id));
    }

    @Override
    public StopTransactionResponse receivedStopTransactionRequest(String id, StopTransactionRequest req) {
        logger.info(String.format("\n\n\tSTEP[14/16] sendRemoteStopTransactionRequest(%s)\n", id));
        return StopTransactionResponse.builder().build();
    }

    @Override
    public void sendStopTransactionResponse(String id, StopTransactionResponse res, ErrorCode err) {
        logger.info(String.format("\n\n\tSTEP[16/16] sendRemoteStopTransactionRequest(%s)\n", id));
    }
}