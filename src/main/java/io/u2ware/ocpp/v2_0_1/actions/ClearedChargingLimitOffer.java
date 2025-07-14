package io.u2ware.ocpp.v2_0_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_0_1.model.ClearedChargingLimitRequest;
import io.u2ware.ocpp.v2_0_1.model.ClearedChargingLimitResponse;

public interface ClearedChargingLimitOffer { 

    public ClearedChargingLimitRequest sendClearedChargingLimitRequest(String id, Map<String,Object> req);

    public void receivedClearedChargingLimitResponse(String id, ClearedChargingLimitResponse res, ErrorCode err);

}