
package io.u2ware.ocpp.v2_0_1.model;

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
    "customData",
    "eventType",
    "meterValue",
    "timestamp",
    "triggerReason",
    "seqNo",
    "offline",
    "numberOfPhasesUsed",
    "cableMaxCurrent",
    "reservationId",
    "transactionInfo",
    "evse",
    "idToken"
})
@Generated("jsonschema2pojo")
public class TransactionEventRequest {

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;
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
     * If the Charging Station is able to report the number of phases used, then it SHALL provide it. When omitted the CSMS may be able to determine the number of phases used via device management.
     * 
     * 
     */
    @JsonProperty("numberOfPhasesUsed")
    @JsonPropertyDescription("If the Charging Station is able to report the number of phases used, then it SHALL provide it. When omitted the CSMS may be able to determine the number of phases used via device management.\r\n")
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
    private Integer reservationId;
    /**
     * Transaction
     * urn:x-oca:ocpp:uid:2:233318
     * 
     * (Required)
     * 
     */
    @JsonProperty("transactionInfo")
    @JsonPropertyDescription("Transaction\r\nurn:x-oca:ocpp:uid:2:233318\r\n")
    @Valid
    @NotNull
    private Transaction transactionInfo;
    /**
     * EVSE
     * urn:x-oca:ocpp:uid:2:233123
     * Electric Vehicle Supply Equipment
     * 
     * 
     */
    @JsonProperty("evse")
    @JsonPropertyDescription("EVSE\r\nurn:x-oca:ocpp:uid:2:233123\r\nElectric Vehicle Supply Equipment\r\n")
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

}
