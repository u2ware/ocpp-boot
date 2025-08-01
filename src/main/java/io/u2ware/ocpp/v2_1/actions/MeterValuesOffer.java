package io.u2ware.ocpp.v2_1.actions;

import java.util.Map;

import io.u2ware.ocpp.v2_1.model.MeterValuesRequest;
import io.u2ware.ocpp.v2_1.model.MeterValuesResponse;
import io.u2ware.ocpp.v2_1.exception.ErrorCode;

public interface MeterValuesOffer { 

    public MeterValuesRequest sendMeterValuesRequest(String id, Map<String,Object> req);

    public void receivedMeterValuesResponse(String id, MeterValuesResponse res, ErrorCode err);

}