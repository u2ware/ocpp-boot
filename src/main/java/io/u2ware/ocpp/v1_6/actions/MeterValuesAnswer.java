package io.u2ware.ocpp.v1_6.actions;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.model.MeterValuesRequest;
import io.u2ware.ocpp.v1_6.model.MeterValuesResponse;

public interface MeterValuesAnswer { 

    public MeterValuesResponse receivedMeterValuesRequest(String id, MeterValuesRequest req);

    public void sendMeterValuesResponse(String id, MeterValuesResponse res, ErrorCode err);

}