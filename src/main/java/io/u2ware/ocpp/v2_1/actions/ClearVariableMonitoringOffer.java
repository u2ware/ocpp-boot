package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.model.ClearVariableMonitoringRequest;
import io.u2ware.ocpp.v2_1.model.ClearVariableMonitoringResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface ClearVariableMonitoringOffer { 

    public ClearVariableMonitoringRequest sendClearVariableMonitoringRequest(String id, Map<String,Object> req);

    public void receivedClearVariableMonitoringResponse(String id, ClearVariableMonitoringResponse res, ErrorCode err);

}