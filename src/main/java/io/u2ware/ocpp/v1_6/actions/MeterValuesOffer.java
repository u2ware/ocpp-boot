package io.u2ware.ocpp.v1_6.actions;

import java.util.Map;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.model.MeterValuesRequest;
import io.u2ware.ocpp.v1_6.model.MeterValuesResponse;

public interface MeterValuesOffer { 

    public MeterValuesRequest sendMeterValuesRequest(String id, Map<String,Object> req);

    public void receivedMeterValuesResponse(String id, MeterValuesResponse res, ErrorCode err);

}