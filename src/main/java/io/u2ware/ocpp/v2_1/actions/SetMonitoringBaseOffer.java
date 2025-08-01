package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.model.SetMonitoringBaseRequest;
import io.u2ware.ocpp.v2_1.model.SetMonitoringBaseResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface SetMonitoringBaseOffer { 

    public SetMonitoringBaseRequest sendSetMonitoringBaseRequest(String id, Map<String,Object> req);

    public void receivedSetMonitoringBaseResponse(String id, SetMonitoringBaseResponse res, ErrorCode err);

}