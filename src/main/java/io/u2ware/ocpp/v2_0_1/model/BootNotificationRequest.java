
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
    "chargingStation",
    "reason"
})
@Generated("jsonschema2pojo")
public class BootNotificationRequest {

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;
    /**
     * Charge_ Point
     * urn:x-oca:ocpp:uid:2:233122
     * The physical system where an Electrical Vehicle (EV) can be charged.
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingStation")
    @JsonPropertyDescription("Charge_ Point\r\nurn:x-oca:ocpp:uid:2:233122\r\nThe physical system where an Electrical Vehicle (EV) can be charged.\r\n")
    @Valid
    @NotNull
    private ChargingStation chargingStation;
    /**
     * This contains the reason for sending this message to the CSMS.
     * 
     * (Required)
     * 
     */
    @JsonProperty("reason")
    @JsonPropertyDescription("This contains the reason for sending this message to the CSMS.\r\n")
    @NotNull
    private BootReasonEnum reason;

}
