package io.u2ware.ocpp.v1_6.actions;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.model.SendLocalListRequest;
import io.u2ware.ocpp.v1_6.model.SendLocalListResponse;

public interface SendLocalListAnswer { 

    public SendLocalListResponse receivedSendLocalListRequest(String id, SendLocalListRequest req);

    public void sendSendLocalListResponse(String id, SendLocalListResponse res, ErrorCode err);

}