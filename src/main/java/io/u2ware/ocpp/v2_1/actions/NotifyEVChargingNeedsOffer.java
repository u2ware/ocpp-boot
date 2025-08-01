package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.model.NotifyEVChargingNeedsRequest;
import io.u2ware.ocpp.v2_1.model.NotifyEVChargingNeedsResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface NotifyEVChargingNeedsOffer { 

    public NotifyEVChargingNeedsRequest sendNotifyEVChargingNeedsRequest(String id, Map<String,Object> req);

    public void receivedNotifyEVChargingNeedsResponse(String id, NotifyEVChargingNeedsResponse res, ErrorCode err);

}