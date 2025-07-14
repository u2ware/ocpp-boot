package io.u2ware.ocpp.v2_0_1.actions;

import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_0_1.model.ClearedChargingLimitRequest;
import io.u2ware.ocpp.v2_0_1.model.ClearedChargingLimitResponse;

public interface ClearedChargingLimitAnswer { 

    public ClearedChargingLimitResponse receivedClearedChargingLimitRequest(String id, ClearedChargingLimitRequest req);

    public void sendClearedChargingLimitResponse(String id, ClearedChargingLimitResponse res, ErrorCode err);

}