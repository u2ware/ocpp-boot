
package io.u2ware.ocpp.v2_1.model;

import java.time.ZonedDateTime;
import java.util.List;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
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
    "acChargingParameters",
    "derChargingParameters",
    "evEnergyOffer",
    "requestedEnergyTransfer",
    "dcChargingParameters",
    "v2xChargingParameters",
    "availableEnergyTransfer",
    "controlMode",
    "mobilityNeedsMode",
    "departureTime",
    "customData"
})
@Generated("jsonschema2pojo")
public class ChargingNeeds {

    /**
     * EV AC charging parameters for ISO 15118-2
     * 
     * 
     * 
     */
    @JsonProperty("acChargingParameters")
    @JsonPropertyDescription("EV AC charging parameters for ISO 15118-2\r\n\r\n")
    @Valid
    private ACChargingParameters acChargingParameters;
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
    @JsonProperty("derChargingParameters")
    @JsonPropertyDescription("*(2.1)* DERChargingParametersType is used in ChargingNeedsType during an ISO 15118-20 session for AC_BPT_DER to report the inverter settings related to DER control that were agreed between EVSE and EV.\r\n\r\nFields starting with \"ev\" contain values from the EV.\r\nOther fields contain a value that is supported by both EV and EVSE.\r\n\r\nDERChargingParametersType type is only relevant in case of an ISO 15118-20 AC_BPT_DER/AC_DER charging session.\r\n\r\nNOTE: All these fields have values greater or equal to zero (i.e. are non-negative)\r\n\r\n")
    @Valid
    private DERChargingParameters derChargingParameters;
    /**
     * *(2.1)* A schedule of the energy amount over time that EV is willing to discharge. A negative value indicates the willingness to discharge under specific conditions, a positive value indicates that the EV currently is not able to offer energy to discharge. 
     * 
     * 
     */
    @JsonProperty("evEnergyOffer")
    @JsonPropertyDescription("*(2.1)* A schedule of the energy amount over time that EV is willing to discharge. A negative value indicates the willingness to discharge under specific conditions, a positive value indicates that the EV currently is not able to offer energy to discharge. \r\n")
    @Valid
    private EVEnergyOffer evEnergyOffer;
    /**
     * Mode of energy transfer requested by the EV.
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestedEnergyTransfer")
    @JsonPropertyDescription("Mode of energy transfer requested by the EV.\r\n")
    @NotNull
    private EnergyTransferModeEnum requestedEnergyTransfer;
    /**
     * EV DC charging parameters for ISO 15118-2
     * 
     * 
     */
    @JsonProperty("dcChargingParameters")
    @JsonPropertyDescription("EV DC charging parameters for ISO 15118-2\r\n")
    @Valid
    private DCChargingParameters dcChargingParameters;
    /**
     * Charging parameters for ISO 15118-20, also supporting V2X charging/discharging.+
     * All values are greater or equal to zero, with the exception of EVMinEnergyRequest, EVMaxEnergyRequest, EVTargetEnergyRequest, EVMinV2XEnergyRequest and EVMaxV2XEnergyRequest.
     * 
     * 
     */
    @JsonProperty("v2xChargingParameters")
    @JsonPropertyDescription("Charging parameters for ISO 15118-20, also supporting V2X charging/discharging.+\r\nAll values are greater or equal to zero, with the exception of EVMinEnergyRequest, EVMaxEnergyRequest, EVTargetEnergyRequest, EVMinV2XEnergyRequest and EVMaxV2XEnergyRequest.\r\n")
    @Valid
    private V2XChargingParameters v2xChargingParameters;
    /**
     * *(2.1)* Modes of energy transfer that are marked as available by EV.
     * 
     * 
     */
    @JsonProperty("availableEnergyTransfer")
    @JsonPropertyDescription("*(2.1)* Modes of energy transfer that are marked as available by EV.\r\n")
    @Singular("availableEnergyTransfer")
    @Size(min = 1)
    @Valid
    private List<EnergyTransferModeEnum> availableEnergyTransfer;
    /**
     * *(2.1)* Indicates whether EV wants to operate in Dynamic or Scheduled mode. When absent, Scheduled mode is assumed for backwards compatibility. +
     * *ISO 15118-20:* +
     * ServiceSelectionReq(SelectedEnergyTransferService)
     * 
     * 
     */
    @JsonProperty("controlMode")
    @JsonPropertyDescription("*(2.1)* Indicates whether EV wants to operate in Dynamic or Scheduled mode. When absent, Scheduled mode is assumed for backwards compatibility. +\r\n*ISO 15118-20:* +\r\nServiceSelectionReq(SelectedEnergyTransferService)\r\n")
    private ControlModeEnum controlMode;
    /**
     * *(2.1)* Value of EVCC indicates that EV determines min/target SOC and departure time. +
     * A value of EVCC_SECC indicates that charging station or CSMS may also update min/target SOC and departure time. +
     * *ISO 15118-20:* +
     * ServiceSelectionReq(SelectedEnergyTransferService)
     * 
     * 
     */
    @JsonProperty("mobilityNeedsMode")
    @JsonPropertyDescription("*(2.1)* Value of EVCC indicates that EV determines min/target SOC and departure time. +\r\nA value of EVCC_SECC indicates that charging station or CSMS may also update min/target SOC and departure time. +\r\n*ISO 15118-20:* +\r\nServiceSelectionReq(SelectedEnergyTransferService)\r\n")
    private MobilityNeedsModeEnum mobilityNeedsMode;
    /**
     * Estimated departure time of the EV. +
     * *ISO 15118-2:* AC/DC_EVChargeParameterType: DepartureTime +
     * *ISO 15118-20:* Dynamic/Scheduled_SEReqControlModeType: DepartureTIme
     * 
     * 
     */
    @JsonProperty("departureTime")
    @JsonPropertyDescription("Estimated departure time of the EV. +\r\n*ISO 15118-2:* AC/DC_EVChargeParameterType: DepartureTime +\r\n*ISO 15118-20:* Dynamic/Scheduled_SEReqControlModeType: DepartureTIme\r\n")
    private ZonedDateTime departureTime;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
