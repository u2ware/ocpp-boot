package io.u2ware.ocpp.test.handler1;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.u2ware.ocpp.v1_6.messaging.*;
import io.u2ware.ocpp.v1_6.exception.*;
import io.u2ware.ocpp.v1_6.model.*;
import io.u2ware.ocpp.v1_6.usecase.*;

@Component
public class StartTransactionHandler implements StartTransaction.ServerHandler, SetChargingProfile.ServerHandler{

    protected Log logger = LogFactory.getLog(getClass());

    private @Autowired SpecificationSendingOperations ocppOperations;


    @Override
    public StartTransactionResponse receivedStartTransactionRequest(String id, StartTransactionRequest arg1) {
        logger.info(comment(this, StartTransaction.Comment.receivedStartTransactionRequest, id));
        return new StartTransactionResponse();
    }

    @Override
    public void sendStartTransactionResponse(String id, StartTransactionResponse arg1, ErrorCode arg2) {
        logger.info(comment(this, StartTransaction.Comment.sendStartTransactionResponse, id));
        

        SpecificationAction message = Specification.InitiatedByCentralSystem.Usecase.SetChargingProfile.message("world");
        ocppOperations.convertAndSend(id, message);
    }

    @Override
    public SetChargingProfileRequest sendSetChargingProfileRequest(String id, Map<String, Object> arg1) {
        logger.info(comment(this, SetChargingProfile.Comment.sendSetChargingProfileRequest, id));
        return new SetChargingProfileRequest();
    }

    @Override
    public void receivedSetChargingProfileResponse(String id, SetChargingProfileResponse arg1, ErrorCode arg2) {
        logger.info(comment(this, SetChargingProfile.Comment.receivedSetChargingProfileResponse, id));
    }
    
}
