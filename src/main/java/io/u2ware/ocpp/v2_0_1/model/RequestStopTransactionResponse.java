
package io.u2ware.ocpp.v2_0_1.model;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

@JsonInclude(JsonInclude.Include.ALWAYS)
@SuperBuilder
@ToString
@Getter
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({
    "customData",
    "status",
    "statusInfo"
})
@Generated("jsonschema2pojo")
public class RequestStopTransactionResponse {

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;
    /**
     * Status indicating whether Charging Station accepts the request to stop a transaction.
     * 
     * (Required)
     * 
     */
    @JsonProperty("status")
    @JsonPropertyDescription("Status indicating whether Charging Station accepts the request to stop a transaction.\r\n")
    @NotNull
    private RequestStartStopStatusEnum status;
    /**
     * Element providing more information about the status.
     * 
     * 
     */
    @JsonProperty("statusInfo")
    @JsonPropertyDescription("Element providing more information about the status.\r\n")
    @Valid
    private StatusInfo statusInfo;

}
