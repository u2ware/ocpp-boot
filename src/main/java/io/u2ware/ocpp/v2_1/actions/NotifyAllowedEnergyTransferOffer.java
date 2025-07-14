package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.NotifyAllowedEnergyTransferRequest;
import io.u2ware.ocpp.v2_1.model.NotifyAllowedEnergyTransferResponse;

public interface NotifyAllowedEnergyTransferOffer { 

    public NotifyAllowedEnergyTransferRequest sendNotifyAllowedEnergyTransferRequest(String id, Map<String,Object> req);

    public void receivedNotifyAllowedEnergyTransferResponse(String id, NotifyAllowedEnergyTransferResponse res, ErrorCode err);

}