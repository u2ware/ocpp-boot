package io.u2ware.ocpp.v1_6.actions;

import java.util.Map;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.model.GetConfigurationRequest;
import io.u2ware.ocpp.v1_6.model.GetConfigurationResponse;

public interface GetConfigurationOffer { 

    public GetConfigurationRequest sendGetConfigurationRequest(String id, Map<String,Object> req);

    public void receivedGetConfigurationResponse(String id, GetConfigurationResponse res, ErrorCode err);

}