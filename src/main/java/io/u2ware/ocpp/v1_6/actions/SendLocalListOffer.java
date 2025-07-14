package io.u2ware.ocpp.v1_6.actions;

import java.util.Map;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.model.SendLocalListRequest;
import io.u2ware.ocpp.v1_6.model.SendLocalListResponse;

public interface SendLocalListOffer { 

    public SendLocalListRequest sendSendLocalListRequest(String id, Map<String,Object> req);

    public void receivedSendLocalListResponse(String id, SendLocalListResponse res, ErrorCode err);

}