package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.model.SetVariableMonitoringRequest;
import io.u2ware.ocpp.v2_1.model.SetVariableMonitoringResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface SetVariableMonitoringAnswer { 

    public SetVariableMonitoringResponse receivedSetVariableMonitoringRequest(String id, SetVariableMonitoringRequest req);

    public void sendSetVariableMonitoringResponse(String id, SetVariableMonitoringResponse res, ErrorCode err);

}