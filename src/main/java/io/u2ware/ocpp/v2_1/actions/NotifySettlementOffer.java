package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.model.NotifySettlementRequest;
import io.u2ware.ocpp.v2_1.model.NotifySettlementResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface NotifySettlementOffer { 

    public NotifySettlementRequest sendNotifySettlementRequest(String id, Map<String,Object> req);

    public void receivedNotifySettlementResponse(String id, NotifySettlementResponse res, ErrorCode err);

}