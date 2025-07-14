
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


/**
 * Tariff with optional conditions for a fixed price.
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
    "conditions",
    "priceFixed",
    "customData"
})
@Generated("jsonschema2pojo")
public class TariffFixedPrice {

    /**
     * These conditions describe if a FixedPrice applies at start of the transaction.
     * 
     * When more than one restriction is set, they are to be treated as a logical AND. All need to be valid before this price is active.
     * 
     * NOTE: _startTimeOfDay_ and _endTimeOfDay_ are in local time, because it is the time in the tariff as it is shown to the EV driver at the Charging Station.
     * A Charging Station will convert this to the internal time zone that it uses (which is recommended to be UTC, see section Generic chapter 3.1) when performing cost calculation.
     * 
     * 
     * 
     */
    @JsonProperty("conditions")
    @JsonPropertyDescription("These conditions describe if a FixedPrice applies at start of the transaction.\r\n\r\nWhen more than one restriction is set, they are to be treated as a logical AND. All need to be valid before this price is active.\r\n\r\nNOTE: _startTimeOfDay_ and _endTimeOfDay_ are in local time, because it is the time in the tariff as it is shown to the EV driver at the Charging Station.\r\nA Charging Station will convert this to the internal time zone that it uses (which is recommended to be UTC, see section Generic chapter 3.1) when performing cost calculation.\r\n\r\n")
    @Valid
    private TariffConditionsFixed conditions;
    /**
     * Fixed price  for this element e.g. a start fee.
     * 
     * (Required)
     * 
     */
    @JsonProperty("priceFixed")
    @JsonPropertyDescription("Fixed price  for this element e.g. a start fee.\r\n")
    @NotNull
    private Double priceFixed;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
