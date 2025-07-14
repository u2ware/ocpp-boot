package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.NotifyAllowedEnergyTransferRequest;
import io.u2ware.ocpp.v2_1.model.NotifyAllowedEnergyTransferResponse;

public interface NotifyAllowedEnergyTransferAnswer { 

    public NotifyAllowedEnergyTransferResponse receivedNotifyAllowedEnergyTransferRequest(String id, NotifyAllowedEnergyTransferRequest req);

    public void sendNotifyAllowedEnergyTransferResponse(String id, NotifyAllowedEnergyTransferResponse res, ErrorCode err);

}