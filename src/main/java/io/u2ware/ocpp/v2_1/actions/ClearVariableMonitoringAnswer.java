package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.ClearVariableMonitoringRequest;
import io.u2ware.ocpp.v2_1.model.ClearVariableMonitoringResponse;

public interface ClearVariableMonitoringAnswer { 

    public ClearVariableMonitoringResponse receivedClearVariableMonitoringRequest(String id, ClearVariableMonitoringRequest req);

    public void sendClearVariableMonitoringResponse(String id, ClearVariableMonitoringResponse res, ErrorCode err);

}