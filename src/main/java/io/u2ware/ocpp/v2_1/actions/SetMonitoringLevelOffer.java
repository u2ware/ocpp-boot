package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.model.SetMonitoringLevelRequest;
import io.u2ware.ocpp.v2_1.model.SetMonitoringLevelResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface SetMonitoringLevelOffer { 

    public SetMonitoringLevelRequest sendSetMonitoringLevelRequest(String id, Map<String,Object> req);

    public void receivedSetMonitoringLevelResponse(String id, SetMonitoringLevelResponse res, ErrorCode err);

}