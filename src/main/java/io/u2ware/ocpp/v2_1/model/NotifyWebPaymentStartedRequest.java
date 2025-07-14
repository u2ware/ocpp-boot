
package io.u2ware.ocpp.v2_1.model;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
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
    "evseId",
    "timeout",
    "customData"
})
@Generated("jsonschema2pojo")
public class NotifyWebPaymentStartedRequest {

    /**
     * EVSE id for which transaction is requested.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("evseId")
    @JsonPropertyDescription("EVSE id for which transaction is requested.\r\n\r\n")
    @DecimalMin("0")
    @NotNull
    private Integer evseId;
    /**
     * Timeout value in seconds after which no result of web payment process (e.g. QR code scanning) is to be expected anymore.
     * 
     * (Required)
     * 
     */
    @JsonProperty("timeout")
    @JsonPropertyDescription("Timeout value in seconds after which no result of web payment process (e.g. QR code scanning) is to be expected anymore.\r\n")
    @NotNull
    private Integer timeout;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
