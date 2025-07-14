
package io.u2ware.ocpp.v2_1.model;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
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
    "vRef",
    "autonomousVRefEnable",
    "autonomousVRefTimeConstant",
    "customData"
})
@Generated("jsonschema2pojo")
public class ReactivePowerParams {

    /**
     * Only for VoltVar curve: The nominal ac voltage (rms) adjustment to the voltage curve points for Volt-Var curves (percentage).
     * 
     * 
     * 
     * 
     */
    @JsonProperty("vRef")
    @JsonPropertyDescription("Only for VoltVar curve: The nominal ac voltage (rms) adjustment to the voltage curve points for Volt-Var curves (percentage).\r\n\r\n\r\n")
    private Double vRef;
    /**
     * Only for VoltVar: Enable/disable autonomous VRef adjustment
     * 
     * 
     * 
     * 
     */
    @JsonProperty("autonomousVRefEnable")
    @JsonPropertyDescription("Only for VoltVar: Enable/disable autonomous VRef adjustment\r\n\r\n\r\n")
    private Boolean autonomousVRefEnable;
    /**
     * Only for VoltVar: Adjustment range for VRef time constant
     * 
     * 
     * 
     * 
     */
    @JsonProperty("autonomousVRefTimeConstant")
    @JsonPropertyDescription("Only for VoltVar: Adjustment range for VRef time constant\r\n\r\n\r\n")
    private Double autonomousVRefTimeConstant;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
