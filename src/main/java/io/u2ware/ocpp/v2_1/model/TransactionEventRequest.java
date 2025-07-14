
package io.u2ware.ocpp.v2_1.model;

import java.time.ZonedDateTime;
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

@JsonInclude(JsonInclude.Include.ALWAYS)
@SuperBuilder
@ToString
@Getter
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({
    "costDetails",
    "eventType",
    "meterValue",
    "timestamp",
    "triggerReason",
    "seqNo",
    "offline",
    "numberOfPhasesUsed",
    "cableMaxCurrent",
    "reservationId",
    "preconditioningStatus",
    "evseSleep",
    "transactionInfo",
    "evse",
    "idToken",
    "customData"
})
@Generated("jsonschema2pojo")
public class TransactionEventRequest {

    /**
     * CostDetailsType contains the cost as calculated by Charging Station based on provided TariffType.
     * 
     * NOTE: Reservation is not shown as a _chargingPeriod_, because it took place outside of the transaction.
     * 
     * 
     * 
     */
    @JsonProperty("costDetails")
    @JsonPropertyDescription("CostDetailsType contains the cost as calculated by Charging Station based on provided TariffType.\r\n\r\nNOTE: Reservation is not shown as a _chargingPeriod_, because it took place outside of the transaction.\r\n\r\n")
    @Valid
    private CostDetails costDetails;
    /**
     * This contains the type of this event.
     * The first TransactionEvent of a transaction SHALL contain: "Started" The last TransactionEvent of a transaction SHALL contain: "Ended" All others SHALL contain: "Updated"
     * 
     * (Required)
     * 
     */
    @JsonProperty("eventType")
    @JsonPropertyDescription("This contains the type of this event.\r\nThe first TransactionEvent of a transaction SHALL contain: \"Started\" The last TransactionEvent of a transaction SHALL contain: \"Ended\" All others SHALL contain: \"Updated\"\r\n")
    @NotNull
    private TransactionEventEnum eventType;
    @JsonProperty("meterValue")
    @Singular("meterValue")
    @Size(min = 1)
    @Valid
    private List<MeterValue> meterValue;
    /**
     * The date and time at which this transaction event occurred.
     * 
     * (Required)
     * 
     */
    @JsonProperty("timestamp")
    @JsonPropertyDescription("The date and time at which this transaction event occurred.\r\n")
    @NotNull
    private ZonedDateTime timestamp;
    /**
     * Reason the Charging Station sends this message to the CSMS
     * 
     * (Required)
     * 
     */
    @JsonProperty("triggerReason")
    @JsonPropertyDescription("Reason the Charging Station sends this message to the CSMS\r\n")
    @NotNull
    private TriggerReasonEnum triggerReason;
    /**
     * Incremental sequence number, helps with determining if all messages of a transaction have been received.
     * 
     * (Required)
     * 
     */
    @JsonProperty("seqNo")
    @JsonPropertyDescription("Incremental sequence number, helps with determining if all messages of a transaction have been received.\r\n")
    @DecimalMin("0")
    @NotNull
    private Integer seqNo;
    /**
     * Indication that this transaction event happened when the Charging Station was offline. Default = false, meaning: the event occurred when the Charging Station was online.
     * 
     * 
     */
    @JsonProperty("offline")
    @JsonPropertyDescription("Indication that this transaction event happened when the Charging Station was offline. Default = false, meaning: the event occurred when the Charging Station was online.\r\n")
    @lombok.Builder.Default
    private Boolean offline = false;
    /**
     * If the Charging Station is able to report the number of phases used, then it SHALL provide it.
     * When omitted the CSMS may be able to determine the number of phases used as follows: +
     *  1: The numberPhases in the currently used ChargingSchedule. +
     *  2: The number of phases provided via device management.
     * 
     * 
     */
    @JsonProperty("numberOfPhasesUsed")
    @JsonPropertyDescription("If the Charging Station is able to report the number of phases used, then it SHALL provide it.\r\nWhen omitted the CSMS may be able to determine the number of phases used as follows: +\r\n1: The numberPhases in the currently used ChargingSchedule. +\r\n2: The number of phases provided via device management.\r\n")
    @DecimalMin("0")
    @DecimalMax("3")
    private Integer numberOfPhasesUsed;
    /**
     * The maximum current of the connected cable in Ampere (A).
     * 
     * 
     */
    @JsonProperty("cableMaxCurrent")
    @JsonPropertyDescription("The maximum current of the connected cable in Ampere (A).\r\n")
    private Integer cableMaxCurrent;
    /**
     * This contains the Id of the reservation that terminates as a result of this transaction.
     * 
     * 
     */
    @JsonProperty("reservationId")
    @JsonPropertyDescription("This contains the Id of the reservation that terminates as a result of this transaction.\r\n")
    @DecimalMin("0")
    private Integer reservationId;
    /**
     * *(2.1)* The current preconditioning status of the BMS in the EV. Default value is Unknown.
     * 
     * 
     */
    @JsonProperty("preconditioningStatus")
    @JsonPropertyDescription("*(2.1)* The current preconditioning status of the BMS in the EV. Default value is Unknown.\r\n")
    private PreconditioningStatusEnum preconditioningStatus;
    /**
     * *(2.1)* True when EVSE electronics are in sleep mode for this transaction. Default value (when absent) is false.
     * 
     * 
     * 
     */
    @JsonProperty("evseSleep")
    @JsonPropertyDescription("*(2.1)* True when EVSE electronics are in sleep mode for this transaction. Default value (when absent) is false.\r\n\r\n")
    private Boolean evseSleep;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("transactionInfo")
    @Valid
    @NotNull
    private Transaction transactionInfo;
    /**
     * Electric Vehicle Supply Equipment
     * 
     * 
     */
    @JsonProperty("evse")
    @JsonPropertyDescription("Electric Vehicle Supply Equipment\r\n")
    @Valid
    private EVSE evse;
    /**
     * Contains a case insensitive identifier to use for the authorization and the type of authorization to support multiple forms of identifiers.
     * 
     * 
     */
    @JsonProperty("idToken")
    @JsonPropertyDescription("Contains a case insensitive identifier to use for the authorization and the type of authorization to support multiple forms of identifiers.\r\n")
    @Valid
    private IdToken idToken;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
