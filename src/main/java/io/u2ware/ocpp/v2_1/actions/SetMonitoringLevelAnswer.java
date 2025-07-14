package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.SetMonitoringLevelRequest;
import io.u2ware.ocpp.v2_1.model.SetMonitoringLevelResponse;

public interface SetMonitoringLevelAnswer { 

    public SetMonitoringLevelResponse receivedSetMonitoringLevelRequest(String id, SetMonitoringLevelRequest req);

    public void sendSetMonitoringLevelResponse(String id, SetMonitoringLevelResponse res, ErrorCode err);

}