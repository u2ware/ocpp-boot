
package io.u2ware.ocpp.v2_1.model;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
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
    "ongoingIndicator",
    "messagesInQueue",
    "customData"
})
@Generated("jsonschema2pojo")
public class GetTransactionStatusResponse {

    /**
     * Whether the transaction is still ongoing.
     * 
     * 
     */
    @JsonProperty("ongoingIndicator")
    @JsonPropertyDescription("Whether the transaction is still ongoing.\r\n")
    private Boolean ongoingIndicator;
    /**
     * Whether there are still message to be delivered.
     * 
     * (Required)
     * 
     */
    @JsonProperty("messagesInQueue")
    @JsonPropertyDescription("Whether there are still message to be delivered.\r\n")
    @NotNull
    private Boolean messagesInQueue;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
