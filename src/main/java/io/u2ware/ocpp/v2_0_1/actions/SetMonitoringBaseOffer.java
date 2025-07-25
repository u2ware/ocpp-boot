package io.u2ware.ocpp.v2_0_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_0_1.model.SetMonitoringBaseRequest;
import io.u2ware.ocpp.v2_0_1.model.SetMonitoringBaseResponse;

public interface SetMonitoringBaseOffer { 

    public SetMonitoringBaseRequest sendSetMonitoringBaseRequest(String id, Map<String,Object> req);

    public void receivedSetMonitoringBaseResponse(String id, SetMonitoringBaseResponse res, ErrorCode err);

}