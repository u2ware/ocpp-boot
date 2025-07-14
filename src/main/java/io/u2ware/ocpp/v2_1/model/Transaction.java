
package io.u2ware.ocpp.v2_1.model;

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
    "transactionId",
    "chargingState",
    "timeSpentCharging",
    "stoppedReason",
    "remoteStartId",
    "operationMode",
    "tariffId",
    "transactionLimit",
    "customData"
})
@Generated("jsonschema2pojo")
public class Transaction {

    /**
     * This contains the Id of the transaction.
     * 
     * (Required)
     * 
     */
    @JsonProperty("transactionId")
    @JsonPropertyDescription("This contains the Id of the transaction.\r\n")
    @Size(max = 36)
    @NotNull
    private String transactionId;
    /**
     * Current charging state, is required when state
     * has changed. Omitted when there is no communication between EVSE and EV, because no cable is plugged in.
     * 
     * 
     */
    @JsonProperty("chargingState")
    @JsonPropertyDescription("Current charging state, is required when state\r\nhas changed. Omitted when there is no communication between EVSE and EV, because no cable is plugged in.\r\n")
    private ChargingStateEnum chargingState;
    /**
     * Contains the total time that energy flowed from EVSE to EV during the transaction (in seconds). Note that timeSpentCharging is smaller or equal to the duration of the transaction.
     * 
     * 
     */
    @JsonProperty("timeSpentCharging")
    @JsonPropertyDescription("Contains the total time that energy flowed from EVSE to EV during the transaction (in seconds). Note that timeSpentCharging is smaller or equal to the duration of the transaction.\r\n")
    private Integer timeSpentCharging;
    /**
     * The _stoppedReason_ is the reason/event that initiated the process of stopping the transaction. It will normally be the user stopping authorization via card (Local or MasterPass) or app (Remote), but it can also be CSMS revoking authorization (DeAuthorized), or disconnecting the EV when TxStopPoint = EVConnected (EVDisconnected). Most other reasons are related to technical faults or energy limitations. +
     * MAY only be omitted when _stoppedReason_ is "Local"
     * 
     * 
     * 
     * 
     */
    @JsonProperty("stoppedReason")
    @JsonPropertyDescription("The _stoppedReason_ is the reason/event that initiated the process of stopping the transaction. It will normally be the user stopping authorization via card (Local or MasterPass) or app (Remote), but it can also be CSMS revoking authorization (DeAuthorized), or disconnecting the EV when TxStopPoint = EVConnected (EVDisconnected). Most other reasons are related to technical faults or energy limitations. +\r\nMAY only be omitted when _stoppedReason_ is \"Local\"\r\n\r\n\r\n")
    private ReasonEnum stoppedReason;
    /**
     * The ID given to remote start request (&lt;&lt;requeststarttransactionrequest, RequestStartTransactionRequest&gt;&gt;. This enables to CSMS to match the started transaction to the given start request.
     * 
     * 
     */
    @JsonProperty("remoteStartId")
    @JsonPropertyDescription("The ID given to remote start request (&lt;&lt;requeststarttransactionrequest, RequestStartTransactionRequest&gt;&gt;. This enables to CSMS to match the started transaction to the given start request.\r\n")
    private Integer remoteStartId;
    /**
     * *(2.1)* The _operationMode_ that is currently in effect for the transaction.
     * 
     * 
     */
    @JsonProperty("operationMode")
    @JsonPropertyDescription("*(2.1)* The _operationMode_ that is currently in effect for the transaction.\r\n")
    private OperationModeEnum operationMode;
    /**
     * *(2.1)* Id of tariff in use for transaction
     * 
     * 
     */
    @JsonProperty("tariffId")
    @JsonPropertyDescription("*(2.1)* Id of tariff in use for transaction\r\n")
    @Size(max = 60)
    private String tariffId;
    /**
     * Cost, energy, time or SoC limit for a transaction.
     * 
     * 
     */
    @JsonProperty("transactionLimit")
    @JsonPropertyDescription("Cost, energy, time or SoC limit for a transaction.\r\n")
    @Valid
    private TransactionLimit transactionLimit;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
