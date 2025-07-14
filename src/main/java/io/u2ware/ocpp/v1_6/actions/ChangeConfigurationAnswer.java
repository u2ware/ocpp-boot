package io.u2ware.ocpp.v1_6.actions;

import io.u2ware.ocpp.v1_6.exception.ErrorCode;
import io.u2ware.ocpp.v1_6.model.ChangeConfigurationRequest;
import io.u2ware.ocpp.v1_6.model.ChangeConfigurationResponse;

public interface ChangeConfigurationAnswer { 

    public ChangeConfigurationResponse receivedChangeConfigurationRequest(String id, ChangeConfigurationRequest req);

    public void sendChangeConfigurationResponse(String id, ChangeConfigurationResponse res, ErrorCode err);

}