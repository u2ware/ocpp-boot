
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
    "duration",
    "chargingRateUnit",
    "evseId",
    "customData"
})
@Generated("jsonschema2pojo")
public class GetCompositeScheduleRequest {

    /**
     * Length of the requested schedule in seconds.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("duration")
    @JsonPropertyDescription("Length of the requested schedule in seconds.\r\n\r\n")
    @NotNull
    private Integer duration;
    /**
     * Can be used to force a power or current profile.
     * 
     * 
     * 
     */
    @JsonProperty("chargingRateUnit")
    @JsonPropertyDescription("Can be used to force a power or current profile.\r\n\r\n")
    private ChargingRateUnitEnum chargingRateUnit;
    /**
     * The ID of the EVSE for which the schedule is requested. When evseid=0, the Charging Station will calculate the expected consumption for the grid connection.
     * 
     * (Required)
     * 
     */
    @JsonProperty("evseId")
    @JsonPropertyDescription("The ID of the EVSE for which the schedule is requested. When evseid=0, the Charging Station will calculate the expected consumption for the grid connection.\r\n")
    @DecimalMin("0")
    @NotNull
    private Integer evseId;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
