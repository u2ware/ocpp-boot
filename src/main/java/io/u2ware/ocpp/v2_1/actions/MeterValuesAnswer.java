package io.u2ware.ocpp.v2_1.actions;

import io.u2ware.ocpp.v2_1.model.MeterValuesRequest;
import io.u2ware.ocpp.v2_1.model.MeterValuesResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface MeterValuesAnswer { 

    public MeterValuesResponse receivedMeterValuesRequest(String id, MeterValuesRequest req);

    public void sendMeterValuesResponse(String id, MeterValuesResponse res, ErrorCode err);

}