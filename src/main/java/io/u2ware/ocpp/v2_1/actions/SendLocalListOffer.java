package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.model.SendLocalListRequest;
import io.u2ware.ocpp.v2_1.model.SendLocalListResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface SendLocalListOffer { 

    public SendLocalListRequest sendSendLocalListRequest(String id, Map<String,Object> req);

    public void receivedSendLocalListResponse(String id, SendLocalListResponse res, ErrorCode err);

}