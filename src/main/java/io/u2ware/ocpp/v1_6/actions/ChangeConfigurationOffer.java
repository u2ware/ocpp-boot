package io.u2ware.ocpp.v1_6.actions;

import java.util.Map;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.model.ChangeConfigurationRequest;
import io.u2ware.ocpp.v1_6.model.ChangeConfigurationResponse;

public interface ChangeConfigurationOffer { 

    public ChangeConfigurationRequest sendChangeConfigurationRequest(String id, Map<String,Object> req);

    public void receivedChangeConfigurationResponse(String id, ChangeConfigurationResponse res, ErrorCode err);

}