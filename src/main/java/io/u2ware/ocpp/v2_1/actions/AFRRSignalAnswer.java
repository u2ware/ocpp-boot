package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.model.AFRRSignalRequest;
import io.u2ware.ocpp.v2_1.model.AFRRSignalResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface AFRRSignalAnswer { 

    public AFRRSignalResponse receivedAFRRSignalRequest(String id, AFRRSignalRequest req);

    public void sendAFRRSignalResponse(String id, AFRRSignalResponse res, ErrorCode err);

}