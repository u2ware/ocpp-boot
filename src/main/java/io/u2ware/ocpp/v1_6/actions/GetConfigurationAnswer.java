package io.u2ware.ocpp.v1_6.actions;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.model.GetConfigurationRequest;
import io.u2ware.ocpp.v1_6.model.GetConfigurationResponse;

public interface GetConfigurationAnswer { 

    public GetConfigurationResponse receivedGetConfigurationRequest(String id, GetConfigurationRequest req);

    public void sendGetConfigurationResponse(String id, GetConfigurationResponse res, ErrorCode err);

}