package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.model.ClearedChargingLimitRequest;
import io.u2ware.ocpp.v2_1.model.ClearedChargingLimitResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface ClearedChargingLimitOffer { 

    public ClearedChargingLimitRequest sendClearedChargingLimitRequest(String id, Map<String,Object> req);

    public void receivedClearedChargingLimitResponse(String id, ClearedChargingLimitResponse res, ErrorCode err);

}