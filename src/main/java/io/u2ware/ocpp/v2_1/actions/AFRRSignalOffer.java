package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.exception.ErrorCode;
import io.u2ware.ocpp.v2_1.model.AFRRSignalRequest;
import io.u2ware.ocpp.v2_1.model.AFRRSignalResponse;

public interface AFRRSignalOffer { 

    public AFRRSignalRequest sendAFRRSignalRequest(String id, Map<String,Object> req);

    public void receivedAFRRSignalResponse(String id, AFRRSignalResponse res, ErrorCode err);

}