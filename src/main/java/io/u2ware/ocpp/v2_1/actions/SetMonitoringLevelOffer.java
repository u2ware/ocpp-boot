package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.SetMonitoringLevelRequest;
import io.u2ware.ocpp.v2_1.model.SetMonitoringLevelResponse;

public interface SetMonitoringLevelOffer { 

    public SetMonitoringLevelRequest sendSetMonitoringLevelRequest(String id, Map<String,Object> req);

    public void receivedSetMonitoringLevelResponse(String id, SetMonitoringLevelResponse res, ErrorCode err);

}