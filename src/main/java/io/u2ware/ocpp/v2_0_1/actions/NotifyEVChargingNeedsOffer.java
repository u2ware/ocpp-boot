package io.u2ware.ocpp.v2_0_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_0_1.model.NotifyEVChargingNeedsRequest;
import io.u2ware.ocpp.v2_0_1.model.NotifyEVChargingNeedsResponse;

public interface NotifyEVChargingNeedsOffer { 

    public NotifyEVChargingNeedsRequest sendNotifyEVChargingNeedsRequest(String id, Map<String,Object> req);

    public void receivedNotifyEVChargingNeedsResponse(String id, NotifyEVChargingNeedsResponse res, ErrorCode err);

}