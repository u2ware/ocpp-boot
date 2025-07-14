package io.u2ware.ocpp.v2_0_1.actions;

import io.u2ware.ocpp.v2_0_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_0_1.model.SetMonitoringBaseRequest;
import io.u2ware.ocpp.v2_0_1.model.SetMonitoringBaseResponse;

public interface SetMonitoringBaseAnswer { 

    public SetMonitoringBaseResponse receivedSetMonitoringBaseRequest(String id, SetMonitoringBaseRequest req);

    public void sendSetMonitoringBaseResponse(String id, SetMonitoringBaseResponse res, ErrorCode err);

}