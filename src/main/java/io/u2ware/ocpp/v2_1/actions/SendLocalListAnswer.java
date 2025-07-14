package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.SendLocalListRequest;
import io.u2ware.ocpp.v2_1.model.SendLocalListResponse;

public interface SendLocalListAnswer { 

    public SendLocalListResponse receivedSendLocalListRequest(String id, SendLocalListRequest req);

    public void sendSendLocalListResponse(String id, SendLocalListResponse res, ErrorCode err);

}