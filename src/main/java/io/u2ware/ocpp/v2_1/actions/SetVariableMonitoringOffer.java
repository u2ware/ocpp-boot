package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.SetVariableMonitoringRequest;
import io.u2ware.ocpp.v2_1.model.SetVariableMonitoringResponse;

public interface SetVariableMonitoringOffer { 

    public SetVariableMonitoringRequest sendSetVariableMonitoringRequest(String id, Map<String,Object> req);

    public void receivedSetVariableMonitoringResponse(String id, SetVariableMonitoringResponse res, ErrorCode err);

}