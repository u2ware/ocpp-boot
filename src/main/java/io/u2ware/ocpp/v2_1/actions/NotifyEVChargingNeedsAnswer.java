package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.NotifyEVChargingNeedsRequest;
import io.u2ware.ocpp.v2_1.model.NotifyEVChargingNeedsResponse;

public interface NotifyEVChargingNeedsAnswer { 

    public NotifyEVChargingNeedsResponse receivedNotifyEVChargingNeedsRequest(String id, NotifyEVChargingNeedsRequest req);

    public void sendNotifyEVChargingNeedsResponse(String id, NotifyEVChargingNeedsResponse res, ErrorCode err);

}