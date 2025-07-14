package io.u2ware.ocpp.v2_0_1.actions;

import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_0_1.model.CostUpdatedRequest;
import io.u2ware.ocpp.v2_0_1.model.CostUpdatedResponse;

public interface CostUpdatedAnswer { 

    public CostUpdatedResponse receivedCostUpdatedRequest(String id, CostUpdatedRequest req);

    public void sendCostUpdatedResponse(String id, CostUpdatedResponse res, ErrorCode err);

}