
package io.u2ware.ocpp.v2_1.model;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;


/**
 * Charging parameters for ISO 15118-20, also supporting V2X charging/discharging.+
 * All values are greater or equal to zero, with the exception of EVMinEnergyRequest, EVMaxEnergyRequest, EVTargetEnergyRequest, EVMinV2XEnergyRequest and EVMaxV2XEnergyRequest.
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
    "minChargePower",
    "minChargePower_L2",
    "minChargePower_L3",
    "maxChargePower",
    "maxChargePower_L2",
    "maxChargePower_L3",
    "minDischargePower",
    "minDischargePower_L2",
    "minDischargePower_L3",
    "maxDischargePower",
    "maxDischargePower_L2",
    "maxDischargePower_L3",
    "minChargeCurrent",
    "maxChargeCurrent",
    "minDischargeCurrent",
    "maxDischargeCurrent",
    "minVoltage",
    "maxVoltage",
    "evTargetEnergyRequest",
    "evMinEnergyRequest",
    "evMaxEnergyRequest",
    "evMinV2XEnergyRequest",
    "evMaxV2XEnergyRequest",
    "targetSoC",
    "customData"
})
@Generated("jsonschema2pojo")
public class V2XChargingParameters {

    /**
     * Minimum charge power in W, defined by max(EV, EVSE).
     * This field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1.
     * Relates to:
     * *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMinimumChargePower
     * 
     * 
     */
    @JsonProperty("minChargePower")
    @JsonPropertyDescription("Minimum charge power in W, defined by max(EV, EVSE).\r\nThis field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1.\r\nRelates to:\r\n*ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMinimumChargePower\r\n")
    private Double minChargePower;
    /**
     * Minimum charge power on phase L2 in W, defined by max(EV, EVSE).
     * Relates to:
     * *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMinimumChargePower_L2
     * 
     * 
     */
    @JsonProperty("minChargePower_L2")
    @JsonPropertyDescription("Minimum charge power on phase L2 in W, defined by max(EV, EVSE).\r\nRelates to:\r\n*ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMinimumChargePower_L2\r\n")
    private Double minChargePowerL2;
    /**
     * Minimum charge power on phase L3 in W, defined by max(EV, EVSE).
     * Relates to:
     * *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMinimumChargePower_L3
     * 
     * 
     */
    @JsonProperty("minChargePower_L3")
    @JsonPropertyDescription("Minimum charge power on phase L3 in W, defined by max(EV, EVSE).\r\nRelates to:\r\n*ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMinimumChargePower_L3\r\n")
    private Double minChargePowerL3;
    /**
     * Maximum charge (absorbed) power in W, defined by min(EV, EVSE) at unity power factor. +
     * This field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1.
     * It corresponds to the ChaWMax attribute in the IEC 61850.
     * It is usually equivalent to the rated apparent power of the EV when discharging (ChaVAMax) in IEC 61850. +
     * 
     * Relates to: 
     * *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMaximumChargePower
     * 
     * 
     * 
     */
    @JsonProperty("maxChargePower")
    @JsonPropertyDescription("Maximum charge (absorbed) power in W, defined by min(EV, EVSE) at unity power factor. +\r\nThis field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1.\r\nIt corresponds to the ChaWMax attribute in the IEC 61850.\r\nIt is usually equivalent to the rated apparent power of the EV when discharging (ChaVAMax) in IEC 61850. +\r\n\r\nRelates to: \r\n*ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMaximumChargePower\r\n\r\n")
    private Double maxChargePower;
    /**
     * Maximum charge power on phase L2 in W, defined by min(EV, EVSE)
     * Relates to: 
     * *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMaximumChargePower_L2
     * 
     * 
     * 
     * 
     */
    @JsonProperty("maxChargePower_L2")
    @JsonPropertyDescription("Maximum charge power on phase L2 in W, defined by min(EV, EVSE)\r\nRelates to: \r\n*ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMaximumChargePower_L2\r\n\r\n\r\n")
    private Double maxChargePowerL2;
    /**
     * Maximum charge power on phase L3 in W, defined by min(EV, EVSE)
     * Relates to: 
     * *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMaximumChargePower_L3
     * 
     * 
     * 
     * 
     */
    @JsonProperty("maxChargePower_L3")
    @JsonPropertyDescription("Maximum charge power on phase L3 in W, defined by min(EV, EVSE)\r\nRelates to: \r\n*ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMaximumChargePower_L3\r\n\r\n\r\n")
    private Double maxChargePowerL3;
    /**
     * Minimum discharge (injected) power in W, defined by max(EV, EVSE) at unity power factor. Value &gt;= 0. +
     * This field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1. +
     * It corresponds to the WMax attribute in the IEC 61850.
     * It is usually equivalent to the rated apparent power of the EV when discharging (VAMax attribute in the IEC 61850).
     * 
     * Relates to:
     * *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMinimumDischargePower
     * 
     * 
     * 
     */
    @JsonProperty("minDischargePower")
    @JsonPropertyDescription("Minimum discharge (injected) power in W, defined by max(EV, EVSE) at unity power factor. Value &gt;= 0. +\r\nThis field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1. +\r\nIt corresponds to the WMax attribute in the IEC 61850.\r\nIt is usually equivalent to the rated apparent power of the EV when discharging (VAMax attribute in the IEC 61850).\r\n\r\nRelates to:\r\n*ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMinimumDischargePower\r\n\r\n")
    private Double minDischargePower;
    /**
     * Minimum discharge power on phase L2 in W, defined by max(EV, EVSE).  Value &gt;= 0.
     * Relates to:
     * *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMinimumDischargePower_L2
     * 
     * 
     * 
     */
    @JsonProperty("minDischargePower_L2")
    @JsonPropertyDescription("Minimum discharge power on phase L2 in W, defined by max(EV, EVSE).  Value &gt;= 0.\r\nRelates to:\r\n*ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMinimumDischargePower_L2\r\n\r\n")
    private Double minDischargePowerL2;
    /**
     * Minimum discharge power on phase L3 in W, defined by max(EV, EVSE).  Value &gt;= 0.
     * Relates to:
     * *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMinimumDischargePower_L3
     * 
     * 
     * 
     */
    @JsonProperty("minDischargePower_L3")
    @JsonPropertyDescription("Minimum discharge power on phase L3 in W, defined by max(EV, EVSE).  Value &gt;= 0.\r\nRelates to:\r\n*ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMinimumDischargePower_L3\r\n\r\n")
    private Double minDischargePowerL3;
    /**
     * Maximum discharge (injected) power in W, defined by min(EV, EVSE) at unity power factor.  Value &gt;= 0.
     * This field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1.
     * Relates to:
     * *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMaximumDischargePower
     * 
     * 
     * 
     * 
     */
    @JsonProperty("maxDischargePower")
    @JsonPropertyDescription("Maximum discharge (injected) power in W, defined by min(EV, EVSE) at unity power factor.  Value &gt;= 0.\r\nThis field represents the sum of all phases, unless values are provided for L2 and L3, in which case this field represents phase L1.\r\nRelates to:\r\n*ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMaximumDischargePower\r\n\r\n\r\n")
    private Double maxDischargePower;
    /**
     * Maximum discharge power on phase L2 in W, defined by min(EV, EVSE).  Value &gt;= 0.
     * Relates to:
     * *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMaximumDischargePowe_L2
     * 
     * 
     * 
     */
    @JsonProperty("maxDischargePower_L2")
    @JsonPropertyDescription("Maximum discharge power on phase L2 in W, defined by min(EV, EVSE).  Value &gt;= 0.\r\nRelates to:\r\n*ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMaximumDischargePowe_L2\r\n\r\n")
    private Double maxDischargePowerL2;
    /**
     * Maximum discharge power on phase L3 in W, defined by min(EV, EVSE).  Value &gt;= 0.
     * Relates to:
     * *ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMaximumDischargePower_L3
     * 
     * 
     * 
     */
    @JsonProperty("maxDischargePower_L3")
    @JsonPropertyDescription("Maximum discharge power on phase L3 in W, defined by min(EV, EVSE).  Value &gt;= 0.\r\nRelates to:\r\n*ISO 15118-20*: BPT_AC/DC_CPDReqEnergyTransferModeType: EVMaximumDischargePower_L3\r\n\r\n")
    private Double maxDischargePowerL3;
    /**
     * Minimum charge current in A, defined by max(EV, EVSE)
     * Relates to: 
     * *ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: EVMinimumChargeCurrent
     * 
     * 
     * 
     */
    @JsonProperty("minChargeCurrent")
    @JsonPropertyDescription("Minimum charge current in A, defined by max(EV, EVSE)\r\nRelates to: \r\n*ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: EVMinimumChargeCurrent\r\n\r\n")
    private Double minChargeCurrent;
    /**
     * Maximum charge current in A, defined by min(EV, EVSE)
     * Relates to: 
     * *ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: EVMaximumChargeCurrent
     * 
     * 
     * 
     * 
     */
    @JsonProperty("maxChargeCurrent")
    @JsonPropertyDescription("Maximum charge current in A, defined by min(EV, EVSE)\r\nRelates to: \r\n*ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: EVMaximumChargeCurrent\r\n\r\n\r\n")
    private Double maxChargeCurrent;
    /**
     * Minimum discharge current in A, defined by max(EV, EVSE).  Value &gt;= 0.
     * Relates to: 
     * *ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: EVMinimumDischargeCurrent
     * 
     * 
     * 
     * 
     */
    @JsonProperty("minDischargeCurrent")
    @JsonPropertyDescription("Minimum discharge current in A, defined by max(EV, EVSE).  Value &gt;= 0.\r\nRelates to: \r\n*ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: EVMinimumDischargeCurrent\r\n\r\n\r\n")
    private Double minDischargeCurrent;
    /**
     * Maximum discharge current in A, defined by min(EV, EVSE).  Value &gt;= 0.
     * Relates to: 
     * *ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: EVMaximumDischargeCurrent
     * 
     * 
     * 
     */
    @JsonProperty("maxDischargeCurrent")
    @JsonPropertyDescription("Maximum discharge current in A, defined by min(EV, EVSE).  Value &gt;= 0.\r\nRelates to: \r\n*ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: EVMaximumDischargeCurrent\r\n\r\n")
    private Double maxDischargeCurrent;
    /**
     * Minimum voltage in V, defined by max(EV, EVSE)
     * Relates to:
     * *ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: EVMinimumVoltage
     * 
     * 
     * 
     */
    @JsonProperty("minVoltage")
    @JsonPropertyDescription("Minimum voltage in V, defined by max(EV, EVSE)\r\nRelates to:\r\n*ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: EVMinimumVoltage\r\n\r\n")
    private Double minVoltage;
    /**
     * Maximum voltage in V, defined by min(EV, EVSE)
     * Relates to:
     * *ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: EVMaximumVoltage
     * 
     * 
     * 
     */
    @JsonProperty("maxVoltage")
    @JsonPropertyDescription("Maximum voltage in V, defined by min(EV, EVSE)\r\nRelates to:\r\n*ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: EVMaximumVoltage\r\n\r\n")
    private Double maxVoltage;
    /**
     * Energy to requested state of charge in Wh
     * Relates to:
     * *ISO 15118-20*: Dynamic/Scheduled_SEReqControlModeType: EVTargetEnergyRequest
     * 
     * 
     * 
     */
    @JsonProperty("evTargetEnergyRequest")
    @JsonPropertyDescription("Energy to requested state of charge in Wh\r\nRelates to:\r\n*ISO 15118-20*: Dynamic/Scheduled_SEReqControlModeType: EVTargetEnergyRequest\r\n\r\n")
    private Double evTargetEnergyRequest;
    /**
     * Energy to minimum allowed state of charge in Wh
     * Relates to:
     * *ISO 15118-20*: Dynamic/Scheduled_SEReqControlModeType: EVMinimumEnergyRequest
     * 
     * 
     * 
     */
    @JsonProperty("evMinEnergyRequest")
    @JsonPropertyDescription("Energy to minimum allowed state of charge in Wh\r\nRelates to:\r\n*ISO 15118-20*: Dynamic/Scheduled_SEReqControlModeType: EVMinimumEnergyRequest\r\n\r\n")
    private Double evMinEnergyRequest;
    /**
     * Energy to maximum state of charge in Wh
     * Relates to:
     * *ISO 15118-20*: Dynamic/Scheduled_SEReqControlModeType: EVMaximumEnergyRequest
     * 
     * 
     * 
     */
    @JsonProperty("evMaxEnergyRequest")
    @JsonPropertyDescription("Energy to maximum state of charge in Wh\r\nRelates to:\r\n*ISO 15118-20*: Dynamic/Scheduled_SEReqControlModeType: EVMaximumEnergyRequest\r\n\r\n")
    private Double evMaxEnergyRequest;
    /**
     * Energy (in Wh) to minimum state of charge for cycling (V2X) activity. 
     * Positive value means that current state of charge is below V2X range.
     * Relates to:
     * *ISO 15118-20*: Dynamic_SEReqControlModeType: EVMinimumV2XEnergyRequest
     * 
     * 
     * 
     */
    @JsonProperty("evMinV2XEnergyRequest")
    @JsonPropertyDescription("Energy (in Wh) to minimum state of charge for cycling (V2X) activity. \r\nPositive value means that current state of charge is below V2X range.\r\nRelates to:\r\n*ISO 15118-20*: Dynamic_SEReqControlModeType: EVMinimumV2XEnergyRequest\r\n\r\n")
    private Double evMinV2XEnergyRequest;
    /**
     * Energy (in Wh) to maximum state of charge for cycling (V2X) activity.
     * Negative value indicates that current state of charge is above V2X range.
     * Relates to:
     * *ISO 15118-20*: Dynamic_SEReqControlModeType: EVMaximumV2XEnergyRequest
     * 
     * 
     * 
     * 
     */
    @JsonProperty("evMaxV2XEnergyRequest")
    @JsonPropertyDescription("Energy (in Wh) to maximum state of charge for cycling (V2X) activity.\r\nNegative value indicates that current state of charge is above V2X range.\r\nRelates to:\r\n*ISO 15118-20*: Dynamic_SEReqControlModeType: EVMaximumV2XEnergyRequest\r\n\r\n\r\n")
    private Double evMaxV2XEnergyRequest;
    /**
     * Target state of charge at departure as percentage.
     * Relates to:
     * *ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: TargetSOC
     * 
     * 
     * 
     */
    @JsonProperty("targetSoC")
    @JsonPropertyDescription("Target state of charge at departure as percentage.\r\nRelates to:\r\n*ISO 15118-20*: BPT_DC_CPDReqEnergyTransferModeType: TargetSOC\r\n\r\n")
    @DecimalMin("0")
    @DecimalMax("1E+2")
    private Integer targetSoC;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
