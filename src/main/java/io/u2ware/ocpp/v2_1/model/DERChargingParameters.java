
package io.u2ware.ocpp.v2_1.model;

import java.util.List;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;


/**
 * *(2.1)* DERChargingParametersType is used in ChargingNeedsType during an ISO 15118-20 session for AC_BPT_DER to report the inverter settings related to DER control that were agreed between EVSE and EV.
 * 
 * Fields starting with "ev" contain values from the EV.
 * Other fields contain a value that is supported by both EV and EVSE.
 * 
 * DERChargingParametersType type is only relevant in case of an ISO 15118-20 AC_BPT_DER/AC_DER charging session.
 * 
 * NOTE: All these fields have values greater or equal to zero (i.e. are non-negative)
 * 
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
    "evSupportedDERControl",
    "evOverExcitedMaxDischargePower",
    "evOverExcitedPowerFactor",
    "evUnderExcitedMaxDischargePower",
    "evUnderExcitedPowerFactor",
    "maxApparentPower",
    "maxChargeApparentPower",
    "maxChargeApparentPower_L2",
    "maxChargeApparentPower_L3",
    "maxDischargeApparentPower",
    "maxDischargeApparentPower_L2",
    "maxDischargeApparentPower_L3",
    "maxChargeReactivePower",
    "maxChargeReactivePower_L2",
    "maxChargeReactivePower_L3",
    "minChargeReactivePower",
    "minChargeReactivePower_L2",
    "minChargeReactivePower_L3",
    "maxDischargeReactivePower",
    "maxDischargeReactivePower_L2",
    "maxDischargeReactivePower_L3",
    "minDischargeReactivePower",
    "minDischargeReactivePower_L2",
    "minDischargeReactivePower_L3",
    "nominalVoltage",
    "nominalVoltageOffset",
    "maxNominalVoltage",
    "minNominalVoltage",
    "evInverterManufacturer",
    "evInverterModel",
    "evInverterSerialNumber",
    "evInverterSwVersion",
    "evInverterHwVersion",
    "evIslandingDetectionMethod",
    "evIslandingTripTime",
    "evMaximumLevel1DCInjection",
    "evDurationLevel1DCInjection",
    "evMaximumLevel2DCInjection",
    "evDurationLevel2DCInjection",
    "evReactiveSusceptance",
    "evSessionTotalDischargeEnergyAvailable",
    "customData"
})
@Generated("jsonschema2pojo")
public class DERChargingParameters {

    /**
     * DER control functions supported by EV. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType:DERControlFunctions (bitmap)
     * 
     * 
     */
    @JsonProperty("evSupportedDERControl")
    @JsonPropertyDescription("DER control functions supported by EV. +\r\n    *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType:DERControlFunctions (bitmap)\r\n")
    @Singular("evSupportedDERControl")
    @Size(min = 1)
    @Valid
    private List<DERControlEnum> evSupportedDERControl;
    /**
     * Rated maximum injected active power by EV, at specified over-excited power factor (overExcitedPowerFactor). +
     * It can also be defined as the rated maximum discharge power at the rated minimum injected reactive power value. This means that if the EV is providing reactive power support, and it is requested to discharge at max power (e.g. to satisfy an EMS request), the EV may override the request and discharge up to overExcitedMaximumDischargePower to meet the minimum reactive power requirements. +
     * Corresponds to the WOvPF attribute in IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVOverExcitedMaximumDischargePower
     * 
     * 
     */
    @JsonProperty("evOverExcitedMaxDischargePower")
    @JsonPropertyDescription("Rated maximum injected active power by EV, at specified over-excited power factor (overExcitedPowerFactor). +\r\nIt can also be defined as the rated maximum discharge power at the rated minimum injected reactive power value. This means that if the EV is providing reactive power support, and it is requested to discharge at max power (e.g. to satisfy an EMS request), the EV may override the request and discharge up to overExcitedMaximumDischargePower to meet the minimum reactive power requirements. +\r\nCorresponds to the WOvPF attribute in IEC 61850. +\r\n    *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVOverExcitedMaximumDischargePower\r\n")
    private Double evOverExcitedMaxDischargePower;
    /**
     * EV power factor when injecting (over excited) the minimum reactive power. +
     * Corresponds to the OvPF attribute in IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVOverExcitedPowerFactor
     * 
     * 
     */
    @JsonProperty("evOverExcitedPowerFactor")
    @JsonPropertyDescription("EV power factor when injecting (over excited) the minimum reactive power. +\r\nCorresponds to the OvPF attribute in IEC 61850. +\r\n    *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVOverExcitedPowerFactor\r\n")
    private Double evOverExcitedPowerFactor;
    /**
     * Rated maximum injected active power by EV supported at specified under-excited power factor (EVUnderExcitedPowerFactor). +
     * It can also be defined as the rated maximum dischargePower at the rated minimum absorbed reactive power value.
     * This means that if the EV is providing reactive power support, and it is requested to discharge at max power (e.g. to satisfy an EMS request), the EV may override the request and discharge up to underExcitedMaximumDischargePower to meet the minimum reactive power requirements. +
     * This corresponds to the WUnPF attribute in the IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVUnderExcitedMaximumDischargePower
     * 
     * 
     */
    @JsonProperty("evUnderExcitedMaxDischargePower")
    @JsonPropertyDescription("Rated maximum injected active power by EV supported at specified under-excited power factor (EVUnderExcitedPowerFactor). +\r\nIt can also be defined as the rated maximum dischargePower at the rated minimum absorbed reactive power value.\r\nThis means that if the EV is providing reactive power support, and it is requested to discharge at max power (e.g. to satisfy an EMS request), the EV may override the request and discharge up to underExcitedMaximumDischargePower to meet the minimum reactive power requirements. +\r\nThis corresponds to the WUnPF attribute in the IEC 61850. +\r\n    *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVUnderExcitedMaximumDischargePower\r\n")
    private Double evUnderExcitedMaxDischargePower;
    /**
     * EV power factor when injecting (under excited) the minimum reactive power. +
     * Corresponds to the OvPF attribute in IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVUnderExcitedPowerFactor
     * 
     * 
     */
    @JsonProperty("evUnderExcitedPowerFactor")
    @JsonPropertyDescription("EV power factor when injecting (under excited) the minimum reactive power. +\r\nCorresponds to the OvPF attribute in IEC 61850. +\r\n    *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVUnderExcitedPowerFactor\r\n")
    private Double evUnderExcitedPowerFactor;
    /**
     * Rated maximum total apparent power, defined by min(EV, EVSE) in va.
     * Corresponds to the VAMaxRtg in IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumApparentPower
     * 
     * 
     */
    @JsonProperty("maxApparentPower")
    @JsonPropertyDescription("Rated maximum total apparent power, defined by min(EV, EVSE) in va.\r\nCorresponds to the VAMaxRtg in IEC 61850. +\r\n    *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumApparentPower\r\n")
    private Double maxApparentPower;
    /**
     * Rated maximum absorbed apparent power, defined by min(EV, EVSE) in va. +
     *     This field represents the sum of all phases, unless values are provided for L2 and L3,
     *     in which case this field represents phase L1. +
     *     Corresponds to the ChaVAMaxRtg in IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumChargeApparentPower
     * 
     * 
     */
    @JsonProperty("maxChargeApparentPower")
    @JsonPropertyDescription("Rated maximum absorbed apparent power, defined by min(EV, EVSE) in va. +\r\n    This field represents the sum of all phases, unless values are provided for L2 and L3,\r\n    in which case this field represents phase L1. +\r\n    Corresponds to the ChaVAMaxRtg in IEC 61850. +\r\n    *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumChargeApparentPower\r\n")
    private Double maxChargeApparentPower;
    /**
     * Rated maximum absorbed apparent power on phase L2, defined by min(EV, EVSE) in va.
     * Corresponds to the ChaVAMaxRtg in IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumChargeApparentPower_L2
     * 
     * 
     */
    @JsonProperty("maxChargeApparentPower_L2")
    @JsonPropertyDescription("Rated maximum absorbed apparent power on phase L2, defined by min(EV, EVSE) in va.\r\nCorresponds to the ChaVAMaxRtg in IEC 61850. +\r\n    *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumChargeApparentPower_L2\r\n")
    private Double maxChargeApparentPowerL2;
    /**
     * Rated maximum absorbed apparent power on phase L3, defined by min(EV, EVSE) in va.
     * Corresponds to the ChaVAMaxRtg in IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumChargeApparentPower_L3
     * 
     * 
     */
    @JsonProperty("maxChargeApparentPower_L3")
    @JsonPropertyDescription("Rated maximum absorbed apparent power on phase L3, defined by min(EV, EVSE) in va.\r\nCorresponds to the ChaVAMaxRtg in IEC 61850. +\r\n    *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumChargeApparentPower_L3\r\n")
    private Double maxChargeApparentPowerL3;
    /**
     * Rated maximum injected apparent power, defined by min(EV, EVSE) in va. +
     *     This field represents the sum of all phases, unless values are provided for L2 and L3,
     *     in which case this field represents phase L1. +
     *     Corresponds to the DisVAMaxRtg in IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumDischargeApparentPower
     * 
     * 
     */
    @JsonProperty("maxDischargeApparentPower")
    @JsonPropertyDescription("Rated maximum injected apparent power, defined by min(EV, EVSE) in va. +\r\n    This field represents the sum of all phases, unless values are provided for L2 and L3,\r\n    in which case this field represents phase L1. +\r\n    Corresponds to the DisVAMaxRtg in IEC 61850. +\r\n    *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumDischargeApparentPower\r\n")
    private Double maxDischargeApparentPower;
    /**
     * Rated maximum injected apparent power on phase L2, defined by min(EV, EVSE) in va. +
     *     Corresponds to the DisVAMaxRtg in IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumDischargeApparentPower_L2
     * 
     * 
     */
    @JsonProperty("maxDischargeApparentPower_L2")
    @JsonPropertyDescription("Rated maximum injected apparent power on phase L2, defined by min(EV, EVSE) in va. +\r\n    Corresponds to the DisVAMaxRtg in IEC 61850. +\r\n    *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumDischargeApparentPower_L2\r\n")
    private Double maxDischargeApparentPowerL2;
    /**
     * Rated maximum injected apparent power on phase L3, defined by min(EV, EVSE) in va. +
     *     Corresponds to the DisVAMaxRtg in IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumDischargeApparentPower_L3
     * 
     * 
     */
    @JsonProperty("maxDischargeApparentPower_L3")
    @JsonPropertyDescription("Rated maximum injected apparent power on phase L3, defined by min(EV, EVSE) in va. +\r\n    Corresponds to the DisVAMaxRtg in IEC 61850. +\r\n    *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumDischargeApparentPower_L3\r\n")
    private Double maxDischargeApparentPowerL3;
    /**
     * Rated maximum absorbed reactive power, defined by min(EV, EVSE), in vars. +
     *     This field represents the sum of all phases, unless values are provided for L2 and L3,
     *     in which case this field represents phase L1. +
     * Corresponds to the AvarMax attribute in the IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumChargeReactivePower
     * 
     * 
     */
    @JsonProperty("maxChargeReactivePower")
    @JsonPropertyDescription("Rated maximum absorbed reactive power, defined by min(EV, EVSE), in vars. +\r\n    This field represents the sum of all phases, unless values are provided for L2 and L3,\r\n    in which case this field represents phase L1. +\r\nCorresponds to the AvarMax attribute in the IEC 61850. +\r\n    *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumChargeReactivePower\r\n")
    private Double maxChargeReactivePower;
    /**
     * Rated maximum absorbed reactive power, defined by min(EV, EVSE), in vars on phase L2. +
     * Corresponds to the AvarMax attribute in the IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumChargeReactivePower_L2
     * 
     * 
     */
    @JsonProperty("maxChargeReactivePower_L2")
    @JsonPropertyDescription("Rated maximum absorbed reactive power, defined by min(EV, EVSE), in vars on phase L2. +\r\nCorresponds to the AvarMax attribute in the IEC 61850. +\r\n    *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumChargeReactivePower_L2\r\n")
    private Double maxChargeReactivePowerL2;
    /**
     * Rated maximum absorbed reactive power, defined by min(EV, EVSE), in vars on phase L3. +
     * Corresponds to the AvarMax attribute in the IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumChargeReactivePower_L3
     * 
     * 
     */
    @JsonProperty("maxChargeReactivePower_L3")
    @JsonPropertyDescription("Rated maximum absorbed reactive power, defined by min(EV, EVSE), in vars on phase L3. +\r\nCorresponds to the AvarMax attribute in the IEC 61850. +\r\n    *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumChargeReactivePower_L3\r\n")
    private Double maxChargeReactivePowerL3;
    /**
     * Rated minimum absorbed reactive power, defined by max(EV, EVSE), in vars. +
     *     This field represents the sum of all phases, unless values are provided for L2 and L3,
     *     in which case this field represents phase L1. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMinimumChargeReactivePower
     * 
     * 
     */
    @JsonProperty("minChargeReactivePower")
    @JsonPropertyDescription("Rated minimum absorbed reactive power, defined by max(EV, EVSE), in vars. +\r\n    This field represents the sum of all phases, unless values are provided for L2 and L3,\r\n    in which case this field represents phase L1. +\r\n    *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMinimumChargeReactivePower\r\n")
    private Double minChargeReactivePower;
    /**
     * Rated minimum absorbed reactive power, defined by max(EV, EVSE), in vars on phase L2. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMinimumChargeReactivePower_L2
     * 
     * 
     */
    @JsonProperty("minChargeReactivePower_L2")
    @JsonPropertyDescription("Rated minimum absorbed reactive power, defined by max(EV, EVSE), in vars on phase L2. +\r\n    *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMinimumChargeReactivePower_L2\r\n")
    private Double minChargeReactivePowerL2;
    /**
     * Rated minimum absorbed reactive power, defined by max(EV, EVSE), in vars on phase L3. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMinimumChargeReactivePower_L3
     * 
     * 
     */
    @JsonProperty("minChargeReactivePower_L3")
    @JsonPropertyDescription("Rated minimum absorbed reactive power, defined by max(EV, EVSE), in vars on phase L3. +\r\n    *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMinimumChargeReactivePower_L3\r\n")
    private Double minChargeReactivePowerL3;
    /**
     * Rated maximum injected reactive power, defined by min(EV, EVSE), in vars. +
     *     This field represents the sum of all phases, unless values are provided for L2 and L3,
     *     in which case this field represents phase L1. +
     * Corresponds to the IvarMax attribute in the IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumDischargeReactivePower
     * 
     * 
     */
    @JsonProperty("maxDischargeReactivePower")
    @JsonPropertyDescription("Rated maximum injected reactive power, defined by min(EV, EVSE), in vars. +\r\n    This field represents the sum of all phases, unless values are provided for L2 and L3,\r\n    in which case this field represents phase L1. +\r\nCorresponds to the IvarMax attribute in the IEC 61850. +\r\n    *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumDischargeReactivePower\r\n")
    private Double maxDischargeReactivePower;
    /**
     * Rated maximum injected reactive power, defined by min(EV, EVSE), in vars on phase L2. +
     * Corresponds to the IvarMax attribute in the IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumDischargeReactivePower_L2
     * 
     * 
     */
    @JsonProperty("maxDischargeReactivePower_L2")
    @JsonPropertyDescription("Rated maximum injected reactive power, defined by min(EV, EVSE), in vars on phase L2. +\r\nCorresponds to the IvarMax attribute in the IEC 61850. +\r\n    *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumDischargeReactivePower_L2\r\n")
    private Double maxDischargeReactivePowerL2;
    /**
     * Rated maximum injected reactive power, defined by min(EV, EVSE), in vars on phase L3. +
     * Corresponds to the IvarMax attribute in the IEC 61850. +
     *     *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumDischargeReactivePower_L3
     * 
     * 
     */
    @JsonProperty("maxDischargeReactivePower_L3")
    @JsonPropertyDescription("Rated maximum injected reactive power, defined by min(EV, EVSE), in vars on phase L3. +\r\nCorresponds to the IvarMax attribute in the IEC 61850. +\r\n    *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumDischargeReactivePower_L3\r\n")
    private Double maxDischargeReactivePowerL3;
    /**
     * Rated minimum injected reactive power, defined by max(EV, EVSE), in vars. +
     *     This field represents the sum of all phases, unless values are provided for L2 and L3,
     *     in which case this field represents phase L1. +
     *         *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMinimumDischargeReactivePower
     * 
     * 
     */
    @JsonProperty("minDischargeReactivePower")
    @JsonPropertyDescription("Rated minimum injected reactive power, defined by max(EV, EVSE), in vars. +\r\n    This field represents the sum of all phases, unless values are provided for L2 and L3,\r\n    in which case this field represents phase L1. +\r\n        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMinimumDischargeReactivePower\r\n")
    private Double minDischargeReactivePower;
    /**
     * Rated minimum injected reactive power, defined by max(EV, EVSE), in var on phase L2. +
     *         *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMinimumDischargeReactivePower_L2
     * 
     * 
     */
    @JsonProperty("minDischargeReactivePower_L2")
    @JsonPropertyDescription("Rated minimum injected reactive power, defined by max(EV, EVSE), in var on phase L2. +\r\n        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMinimumDischargeReactivePower_L2\r\n")
    private Double minDischargeReactivePowerL2;
    /**
     * Rated minimum injected reactive power, defined by max(EV, EVSE), in var on phase L3. +
     *         *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMinimumDischargeReactivePower_L3
     * 
     * 
     */
    @JsonProperty("minDischargeReactivePower_L3")
    @JsonPropertyDescription("Rated minimum injected reactive power, defined by max(EV, EVSE), in var on phase L3. +\r\n        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMinimumDischargeReactivePower_L3\r\n")
    private Double minDischargeReactivePowerL3;
    /**
     * Line voltage supported by EVSE and EV.
     *         *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVNominalVoltage
     * 
     * 
     */
    @JsonProperty("nominalVoltage")
    @JsonPropertyDescription("Line voltage supported by EVSE and EV.\r\n        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVNominalVoltage\r\n")
    private Double nominalVoltage;
    /**
     * The nominal AC voltage (rms) offset between the Charging Station's electrical connection point and the utility’s point of common coupling. +
     *         *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVNominalVoltageOffset
     * 
     * 
     */
    @JsonProperty("nominalVoltageOffset")
    @JsonPropertyDescription("The nominal AC voltage (rms) offset between the Charging Station's electrical connection point and the utility\u2019s point of common coupling. +\r\n        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVNominalVoltageOffset\r\n")
    private Double nominalVoltageOffset;
    /**
     * Maximum AC rms voltage, as defined by min(EV, EVSE)  to operate with. +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumNominalVoltage
     * 
     * 
     */
    @JsonProperty("maxNominalVoltage")
    @JsonPropertyDescription("Maximum AC rms voltage, as defined by min(EV, EVSE)  to operate with. +\r\n       *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumNominalVoltage\r\n")
    private Double maxNominalVoltage;
    /**
     * Minimum AC rms voltage, as defined by max(EV, EVSE)  to operate with. +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMinimumNominalVoltage
     * 
     * 
     */
    @JsonProperty("minNominalVoltage")
    @JsonPropertyDescription("Minimum AC rms voltage, as defined by max(EV, EVSE)  to operate with. +\r\n       *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMinimumNominalVoltage\r\n")
    private Double minNominalVoltage;
    /**
     * Manufacturer of the EV inverter. +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVInverterManufacturer
     * 
     * 
     */
    @JsonProperty("evInverterManufacturer")
    @JsonPropertyDescription("Manufacturer of the EV inverter. +\r\n       *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVInverterManufacturer\r\n")
    @Size(max = 50)
    private String evInverterManufacturer;
    /**
     * Model name of the EV inverter. +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVInverterModel
     * 
     * 
     */
    @JsonProperty("evInverterModel")
    @JsonPropertyDescription("Model name of the EV inverter. +\r\n       *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVInverterModel\r\n")
    @Size(max = 50)
    private String evInverterModel;
    /**
     * Serial number of the EV inverter. +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVInverterSerialNumber
     * 
     * 
     */
    @JsonProperty("evInverterSerialNumber")
    @JsonPropertyDescription("Serial number of the EV inverter. +\r\n       *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVInverterSerialNumber\r\n")
    @Size(max = 50)
    private String evInverterSerialNumber;
    /**
     * Software version of EV inverter. +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVInverterSwVersion
     * 
     * 
     */
    @JsonProperty("evInverterSwVersion")
    @JsonPropertyDescription("Software version of EV inverter. +\r\n       *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVInverterSwVersion\r\n")
    @Size(max = 50)
    private String evInverterSwVersion;
    /**
     * Hardware version of EV inverter. +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVInverterHwVersion
     * 
     * 
     */
    @JsonProperty("evInverterHwVersion")
    @JsonPropertyDescription("Hardware version of EV inverter. +\r\n       *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVInverterHwVersion\r\n")
    @Size(max = 50)
    private String evInverterHwVersion;
    /**
     * Type of islanding detection method. Only mandatory when islanding detection is required at the site, as set in the ISO 15118 Service Details configuration. +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVIslandingDetectionMethod
     * 
     * 
     */
    @JsonProperty("evIslandingDetectionMethod")
    @JsonPropertyDescription("Type of islanding detection method. Only mandatory when islanding detection is required at the site, as set in the ISO 15118 Service Details configuration. +\r\n       *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVIslandingDetectionMethod\r\n")
    @Singular("evIslandingDetectionMethod")
    @Size(min = 1)
    @Valid
    private List<IslandingDetectionEnum> evIslandingDetectionMethod;
    /**
     * Time after which EV will trip if an island has been detected. +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVIslandingTripTime
     * 
     * 
     */
    @JsonProperty("evIslandingTripTime")
    @JsonPropertyDescription("Time after which EV will trip if an island has been detected. +\r\n       *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVIslandingTripTime\r\n")
    private Double evIslandingTripTime;
    /**
     * Maximum injected DC current allowed at level 1 charging. +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumLevel1DCInjection
     * 
     * 
     */
    @JsonProperty("evMaximumLevel1DCInjection")
    @JsonPropertyDescription("Maximum injected DC current allowed at level 1 charging. +\r\n       *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumLevel1DCInjection\r\n")
    private Double evMaximumLevel1DCInjection;
    /**
     * Maximum allowed duration of DC injection at level 1 charging. +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVDurationLevel1DCInjection
     * 
     * 
     */
    @JsonProperty("evDurationLevel1DCInjection")
    @JsonPropertyDescription("Maximum allowed duration of DC injection at level 1 charging. +\r\n       *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVDurationLevel1DCInjection\r\n")
    private Double evDurationLevel1DCInjection;
    /**
     * Maximum injected DC current allowed at level 2 charging. +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumLevel2DCInjection
     * 
     * 
     */
    @JsonProperty("evMaximumLevel2DCInjection")
    @JsonPropertyDescription("Maximum injected DC current allowed at level 2 charging. +\r\n       *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVMaximumLevel2DCInjection\r\n")
    private Double evMaximumLevel2DCInjection;
    /**
     * Maximum allowed duration of DC injection at level 2 charging. +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVDurationLevel2DCInjection
     * 
     * 
     */
    @JsonProperty("evDurationLevel2DCInjection")
    @JsonPropertyDescription("Maximum allowed duration of DC injection at level 2 charging. +\r\n       *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVDurationLevel2DCInjection\r\n")
    private Double evDurationLevel2DCInjection;
    /**
     * 	Measure of the susceptibility of the circuit to reactance, in Siemens (S). +
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVReactiveSusceptance
     * 
     * 
     * 
     * 
     */
    @JsonProperty("evReactiveSusceptance")
    @JsonPropertyDescription("\tMeasure of the susceptibility of the circuit to reactance, in Siemens (S). +\r\n       *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVReactiveSusceptance\r\n\r\n\r\n")
    private Double evReactiveSusceptance;
    /**
     * Total energy value, in Wh, that EV is allowed to provide during the entire V2G session. The value is independent of the V2X Cycling area. Once this value reaches the value of 0, the EV may block any attempt to discharge in order to protect the battery health.
     *        *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVSessionTotalDischargeEnergyAvailable
     * 
     * 
     * 
     * 
     */
    @JsonProperty("evSessionTotalDischargeEnergyAvailable")
    @JsonPropertyDescription("Total energy value, in Wh, that EV is allowed to provide during the entire V2G session. The value is independent of the V2X Cycling area. Once this value reaches the value of 0, the EV may block any attempt to discharge in order to protect the battery health.\r\n       *ISO 15118-20*: DER_BPT_AC_CPDReqEnergyTransferModeType: EVSessionTotalDischargeEnergyAvailable\r\n\r\n\r\n")
    private Double evSessionTotalDischargeEnergyAvailable;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
