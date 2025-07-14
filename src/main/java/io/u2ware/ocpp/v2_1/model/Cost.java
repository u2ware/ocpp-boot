
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
    "costKind",
    "amount",
    "amountMultiplier",
    "customData"
})
@Generated("jsonschema2pojo")
public class Cost {

    /**
     * The kind of cost referred to in the message element amount
     * 
     * (Required)
     * 
     */
    @JsonProperty("costKind")
    @JsonPropertyDescription("The kind of cost referred to in the message element amount\r\n")
    @NotNull
    private CostKindEnum costKind;
    /**
     * The estimated or actual cost per kWh
     * 
     * (Required)
     * 
     */
    @JsonProperty("amount")
    @JsonPropertyDescription("The estimated or actual cost per kWh\r\n")
    @NotNull
    private Integer amount;
    /**
     * Values: -3..3, The amountMultiplier defines the exponent to base 10 (dec). The final value is determined by: amount * 10 ^ amountMultiplier
     * 
     * 
     */
    @JsonProperty("amountMultiplier")
    @JsonPropertyDescription("Values: -3..3, The amountMultiplier defines the exponent to base 10 (dec). The final value is determined by: amount * 10 ^ amountMultiplier\r\n")
    private Integer amountMultiplier;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
