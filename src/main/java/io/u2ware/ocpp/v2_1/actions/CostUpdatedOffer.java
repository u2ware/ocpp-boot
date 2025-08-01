package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.model.CostUpdatedRequest;
import io.u2ware.ocpp.v2_1.model.CostUpdatedResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface CostUpdatedOffer { 

    public CostUpdatedRequest sendCostUpdatedRequest(String id, Map<String,Object> req);

    public void receivedCostUpdatedResponse(String id, CostUpdatedResponse res, ErrorCode err);

}