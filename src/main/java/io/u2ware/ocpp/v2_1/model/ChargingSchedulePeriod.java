
package io.u2ware.ocpp.v2_1.model;

import java.util.List;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
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


/**
 * Charging schedule period structure defines a time period in a charging schedule. It is used in: CompositeScheduleType and in ChargingScheduleType. When used in a NotifyEVChargingScheduleRequest only _startPeriod_, _limit_, _limit_L2_, _limit_L3_ are relevant.
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.ALWAYS)
@SuperBuilder
@ToString
@Getter
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({
    "startPeriod",
    "limit",
    "limit_L2",
    "limit_L3",
    "numberPhases",
    "phaseToUse",
    "dischargeLimit",
    "dischargeLimit_L2",
    "dischargeLimit_L3",
    "setpoint",
    "setpoint_L2",
    "setpoint_L3",
    "setpointReactive",
    "setpointReactive_L2",
    "setpointReactive_L3",
    "preconditioningRequest",
    "evseSleep",
    "v2xBaseline",
    "operationMode",
    "v2xFreqWattCurve",
    "v2xSignalWattCurve",
    "customData"
})
@Generated("jsonschema2pojo")
public class ChargingSchedulePeriod {

    /**
     * Start of the period, in seconds from the start of schedule. The value of StartPeriod also defines the stop time of the previous period.
     * 
     * (Required)
     * 
     */
    @JsonProperty("startPeriod")
    @JsonPropertyDescription("Start of the period, in seconds from the start of schedule. The value of StartPeriod also defines the stop time of the previous period.\r\n")
    @NotNull
    private Integer startPeriod;
    /**
     * Optional only when not required by the _operationMode_, as in CentralSetpoint, ExternalSetpoint, ExternalLimits, LocalFrequency,  LocalLoadBalancing. +
     * Charging rate limit during the schedule period, in the applicable _chargingRateUnit_. 
     * This SHOULD be a non-negative value; a negative value is only supported for backwards compatibility with older systems that use a negative value to specify a discharging limit.
     * When using _chargingRateUnit_ = `W`, this field represents the sum of the power of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1.
     * 
     * 
     */
    @JsonProperty("limit")
    @JsonPropertyDescription("Optional only when not required by the _operationMode_, as in CentralSetpoint, ExternalSetpoint, ExternalLimits, LocalFrequency,  LocalLoadBalancing. +\r\nCharging rate limit during the schedule period, in the applicable _chargingRateUnit_. \r\nThis SHOULD be a non-negative value; a negative value is only supported for backwards compatibility with older systems that use a negative value to specify a discharging limit.\r\nWhen using _chargingRateUnit_ = `W`, this field represents the sum of the power of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1.\r\n")
    private Double limit;
    /**
     * *(2.1)* Charging rate limit on phase L2  in the applicable _chargingRateUnit_. 
     * 
     * 
     */
    @JsonProperty("limit_L2")
    @JsonPropertyDescription("*(2.1)* Charging rate limit on phase L2  in the applicable _chargingRateUnit_. \r\n")
    private Double limitL2;
    /**
     * *(2.1)* Charging rate limit on phase L3  in the applicable _chargingRateUnit_. 
     * 
     * 
     */
    @JsonProperty("limit_L3")
    @JsonPropertyDescription("*(2.1)* Charging rate limit on phase L3  in the applicable _chargingRateUnit_. \r\n")
    private Double limitL3;
    /**
     * The number of phases that can be used for charging. +
     * For a DC EVSE this field should be omitted. +
     * For an AC EVSE a default value of _numberPhases_ = 3 will be assumed if the field is absent.
     * 
     * 
     */
    @JsonProperty("numberPhases")
    @JsonPropertyDescription("The number of phases that can be used for charging. +\r\nFor a DC EVSE this field should be omitted. +\r\nFor an AC EVSE a default value of _numberPhases_ = 3 will be assumed if the field is absent.\r\n")
    @DecimalMin("0")
    @DecimalMax("3")
    private Integer numberPhases;
    /**
     * Values: 1..3, Used if numberPhases=1 and if the EVSE is capable of switching the phase connected to the EV, i.e. ACPhaseSwitchingSupported is defined and true. It’s not allowed unless both conditions above are true. If both conditions are true, and phaseToUse is omitted, the Charging Station / EVSE will make the selection on its own.
     * 
     * 
     * 
     */
    @JsonProperty("phaseToUse")
    @JsonPropertyDescription("Values: 1..3, Used if numberPhases=1 and if the EVSE is capable of switching the phase connected to the EV, i.e. ACPhaseSwitchingSupported is defined and true. It\u2019s not allowed unless both conditions above are true. If both conditions are true, and phaseToUse is omitted, the Charging Station / EVSE will make the selection on its own.\r\n\r\n")
    @DecimalMin("0")
    @DecimalMax("3")
    private Integer phaseToUse;
    /**
     * *(2.1)* Limit in _chargingRateUnit_ that the EV is allowed to discharge with. Note, these are negative values in order to be consistent with _setpoint_, which can be positive and negative.  +
     * For AC this field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1.
     * 
     * 
     */
    @JsonProperty("dischargeLimit")
    @JsonPropertyDescription("*(2.1)* Limit in _chargingRateUnit_ that the EV is allowed to discharge with. Note, these are negative values in order to be consistent with _setpoint_, which can be positive and negative.  +\r\nFor AC this field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1.\r\n")
    private Double dischargeLimit;
    /**
     * *(2.1)* Limit in _chargingRateUnit_ on phase L2 that the EV is allowed to discharge with. 
     * 
     * 
     */
    @JsonProperty("dischargeLimit_L2")
    @JsonPropertyDescription("*(2.1)* Limit in _chargingRateUnit_ on phase L2 that the EV is allowed to discharge with. \r\n")
    private Double dischargeLimitL2;
    /**
     * *(2.1)* Limit in _chargingRateUnit_ on phase L3 that the EV is allowed to discharge with. 
     * 
     * 
     */
    @JsonProperty("dischargeLimit_L3")
    @JsonPropertyDescription("*(2.1)* Limit in _chargingRateUnit_ on phase L3 that the EV is allowed to discharge with. \r\n")
    private Double dischargeLimitL3;
    /**
     * *(2.1)* Setpoint in _chargingRateUnit_ that the EV should follow as close as possible. Use negative values for discharging. +
     * When a limit and/or _dischargeLimit_ are given the overshoot when following _setpoint_ must remain within these values.
     * This field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1.
     * 
     * 
     */
    @JsonProperty("setpoint")
    @JsonPropertyDescription("*(2.1)* Setpoint in _chargingRateUnit_ that the EV should follow as close as possible. Use negative values for discharging. +\r\nWhen a limit and/or _dischargeLimit_ are given the overshoot when following _setpoint_ must remain within these values.\r\nThis field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1.\r\n")
    private Double setpoint;
    /**
     * *(2.1)* Setpoint in _chargingRateUnit_ that the EV should follow on phase L2 as close as possible.
     * 
     * 
     */
    @JsonProperty("setpoint_L2")
    @JsonPropertyDescription("*(2.1)* Setpoint in _chargingRateUnit_ that the EV should follow on phase L2 as close as possible.\r\n")
    private Double setpointL2;
    /**
     * *(2.1)* Setpoint in _chargingRateUnit_ that the EV should follow on phase L3 as close as possible. 
     * 
     * 
     */
    @JsonProperty("setpoint_L3")
    @JsonPropertyDescription("*(2.1)* Setpoint in _chargingRateUnit_ that the EV should follow on phase L3 as close as possible. \r\n")
    private Double setpointL3;
    /**
     * *(2.1)* Setpoint for reactive power (or current) in _chargingRateUnit_ that the EV should follow as closely as possible. Positive values for inductive, negative for capacitive reactive power or current.  +
     * This field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1.
     * 
     * 
     */
    @JsonProperty("setpointReactive")
    @JsonPropertyDescription("*(2.1)* Setpoint for reactive power (or current) in _chargingRateUnit_ that the EV should follow as closely as possible. Positive values for inductive, negative for capacitive reactive power or current.  +\r\nThis field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1.\r\n")
    private Double setpointReactive;
    /**
     * *(2.1)* Setpoint for reactive power (or current) in _chargingRateUnit_ that the EV should follow on phase L2 as closely as possible. 
     * 
     * 
     */
    @JsonProperty("setpointReactive_L2")
    @JsonPropertyDescription("*(2.1)* Setpoint for reactive power (or current) in _chargingRateUnit_ that the EV should follow on phase L2 as closely as possible. \r\n")
    private Double setpointReactiveL2;
    /**
     * *(2.1)* Setpoint for reactive power (or current) in _chargingRateUnit_ that the EV should follow on phase L3 as closely as possible. 
     * 
     * 
     */
    @JsonProperty("setpointReactive_L3")
    @JsonPropertyDescription("*(2.1)* Setpoint for reactive power (or current) in _chargingRateUnit_ that the EV should follow on phase L3 as closely as possible. \r\n")
    private Double setpointReactiveL3;
    /**
     * *(2.1)* If  true, the EV should attempt to keep the BMS preconditioned for this time interval.
     * 
     * 
     */
    @JsonProperty("preconditioningRequest")
    @JsonPropertyDescription("*(2.1)* If  true, the EV should attempt to keep the BMS preconditioned for this time interval.\r\n")
    private Boolean preconditioningRequest;
    /**
     * *(2.1)* If true, the EVSE must turn off power electronics/modules associated with this transaction. Default value when absent is false.
     * 
     * 
     */
    @JsonProperty("evseSleep")
    @JsonPropertyDescription("*(2.1)* If true, the EVSE must turn off power electronics/modules associated with this transaction. Default value when absent is false.\r\n")
    private Boolean evseSleep;
    /**
     * *(2.1)* Power value that, when present, is used as a baseline on top of which values from _v2xFreqWattCurve_ and _v2xSignalWattCurve_ are added.
     * 
     * 
     * 
     */
    @JsonProperty("v2xBaseline")
    @JsonPropertyDescription("*(2.1)* Power value that, when present, is used as a baseline on top of which values from _v2xFreqWattCurve_ and _v2xSignalWattCurve_ are added.\r\n\r\n")
    private Double v2xBaseline;
    /**
     * *(2.1)* Charging operation mode to use during this time interval. When absent defaults to `ChargingOnly`.
     * 
     * 
     */
    @JsonProperty("operationMode")
    @JsonPropertyDescription("*(2.1)* Charging operation mode to use during this time interval. When absent defaults to `ChargingOnly`.\r\n")
    private OperationModeEnum operationMode;
    @JsonProperty("v2xFreqWattCurve")
    @Singular("v2xFreqWattCurve")
    @Size(min = 1, max = 20)
    @Valid
    private List<V2XFreqWattPoint> v2xFreqWattCurve;
    @JsonProperty("v2xSignalWattCurve")
    @Singular("v2xSignalWattCurve")
    @Size(min = 1, max = 20)
    @Valid
    private List<V2XSignalWattPoint> v2xSignalWattCurve;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
