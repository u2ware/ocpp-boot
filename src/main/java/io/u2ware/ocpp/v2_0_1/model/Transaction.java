
package io.u2ware.ocpp.v2_0_1.model;

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


/**
 * Transaction
 * urn:x-oca:ocpp:uid:2:233318
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
    "customData",
    "transactionId",
    "chargingState",
    "timeSpentCharging",
    "stoppedReason",
    "remoteStartId"
})
@Generated("jsonschema2pojo")
public class Transaction {

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;
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
     * Transaction. State. Transaction_ State_ Code
     * urn:x-oca:ocpp:uid:1:569419
     * Current charging state, is required when state
     * has changed.
     * 
     * 
     */
    @JsonProperty("chargingState")
    @JsonPropertyDescription("Transaction. State. Transaction_ State_ Code\r\nurn:x-oca:ocpp:uid:1:569419\r\nCurrent charging state, is required when state\r\nhas changed.\r\n")
    private ChargingStateEnum chargingState;
    /**
     * Transaction. Time_ Spent_ Charging. Elapsed_ Time
     * urn:x-oca:ocpp:uid:1:569415
     * Contains the total time that energy flowed from EVSE to EV during the transaction (in seconds). Note that timeSpentCharging is smaller or equal to the duration of the transaction.
     * 
     * 
     */
    @JsonProperty("timeSpentCharging")
    @JsonPropertyDescription("Transaction. Time_ Spent_ Charging. Elapsed_ Time\r\nurn:x-oca:ocpp:uid:1:569415\r\nContains the total time that energy flowed from EVSE to EV during the transaction (in seconds). Note that timeSpentCharging is smaller or equal to the duration of the transaction.\r\n")
    private Integer timeSpentCharging;
    /**
     * Transaction. Stopped_ Reason. EOT_ Reason_ Code
     * urn:x-oca:ocpp:uid:1:569413
     * This contains the reason why the transaction was stopped. MAY only be omitted when Reason is "Local".
     * 
     * 
     */
    @JsonProperty("stoppedReason")
    @JsonPropertyDescription("Transaction. Stopped_ Reason. EOT_ Reason_ Code\r\nurn:x-oca:ocpp:uid:1:569413\r\nThis contains the reason why the transaction was stopped. MAY only be omitted when Reason is \"Local\".\r\n")
    private ReasonEnum stoppedReason;
    /**
     * The ID given to remote start request (&lt;&lt;requeststarttransactionrequest, RequestStartTransactionRequest&gt;&gt;. This enables to CSMS to match the started transaction to the given start request.
     * 
     * 
     */
    @JsonProperty("remoteStartId")
    @JsonPropertyDescription("The ID given to remote start request (&lt;&lt;requeststarttransactionrequest, RequestStartTransactionRequest&gt;&gt;. This enables to CSMS to match the started transaction to the given start request.\r\n")
    private Integer remoteStartId;

}
