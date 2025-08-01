package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.model.NotifySettlementRequest;
import io.u2ware.ocpp.v2_1.model.NotifySettlementResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface NotifySettlementAnswer { 

    public NotifySettlementResponse receivedNotifySettlementRequest(String id, NotifySettlementRequest req);

    public void sendNotifySettlementResponse(String id, NotifySettlementResponse res, ErrorCode err);

}