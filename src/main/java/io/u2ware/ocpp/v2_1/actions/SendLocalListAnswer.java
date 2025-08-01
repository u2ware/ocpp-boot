package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.model.SendLocalListRequest;
import io.u2ware.ocpp.v2_1.model.SendLocalListResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface SendLocalListAnswer { 

    public SendLocalListResponse receivedSendLocalListRequest(String id, SendLocalListRequest req);

    public void sendSendLocalListResponse(String id, SendLocalListResponse res, ErrorCode err);

}