
package io.u2ware.ocpp.v2_1.model;

import java.time.ZonedDateTime;
import java.util.List;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Singular;
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
    "curveData",
    "hysteresis",
    "priority",
    "reactivePowerParams",
    "voltageParams",
    "yUnit",
    "responseTime",
    "startTime",
    "duration",
    "customData"
})
@Generated("jsonschema2pojo")
public class DERCurve {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("curveData")
    @Singular("curveData")
    @Size(min = 1, max = 10)
    @Valid
    @NotNull
    private List<DERCurvePoints> curveData;
    @JsonProperty("hysteresis")
    @Valid
    private Hysteresis hysteresis;
    /**
     * Priority of curve (0=highest)
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("priority")
    @JsonPropertyDescription("Priority of curve (0=highest)\r\n\r\n\r\n")
    @DecimalMin("0")
    @NotNull
    private Integer priority;
    @JsonProperty("reactivePowerParams")
    @Valid
    private ReactivePowerParams reactivePowerParams;
    @JsonProperty("voltageParams")
    @Valid
    private VoltageParams voltageParams;
    /**
     * Unit of the Y-axis of DER curve
     * 
     * (Required)
     * 
     */
    @JsonProperty("yUnit")
    @JsonPropertyDescription("Unit of the Y-axis of DER curve\r\n")
    @NotNull
    private DERUnitEnum yUnit;
    /**
     * Open loop response time, the time to ramp up to 90% of the new target in response to the change in voltage, in seconds. A value of 0 is used to mean no limit. When not present, the device should follow its default behavior.
     * 
     * 
     * 
     * 
     */
    @JsonProperty("responseTime")
    @JsonPropertyDescription("Open loop response time, the time to ramp up to 90% of the new target in response to the change in voltage, in seconds. A value of 0 is used to mean no limit. When not present, the device should follow its default behavior.\r\n\r\n\r\n")
    private Double responseTime;
    /**
     * Point in time when this curve will become activated. Only absent when _default_ is true.
     * 
     * 
     * 
     */
    @JsonProperty("startTime")
    @JsonPropertyDescription("Point in time when this curve will become activated. Only absent when _default_ is true.\r\n\r\n")
    private ZonedDateTime startTime;
    /**
     * Duration in seconds that this curve will be active. Only absent when _default_ is true.
     * 
     * 
     * 
     * 
     */
    @JsonProperty("duration")
    @JsonPropertyDescription("Duration in seconds that this curve will be active. Only absent when _default_ is true.\r\n\r\n\r\n")
    private Double duration;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
