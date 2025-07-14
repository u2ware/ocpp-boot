
package io.u2ware.ocpp.v2_1.model;

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


/**
 * Part of ISO 15118-20 price schedule.
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
    "duration",
    "priceRule",
    "customData"
})
@Generated("jsonschema2pojo")
public class PriceRuleStack {

    /**
     * Duration of the stack of price rules.  he amount of seconds that define the duration of the given PriceRule(s).
     * 
     * (Required)
     * 
     */
    @JsonProperty("duration")
    @JsonPropertyDescription("Duration of the stack of price rules.  he amount of seconds that define the duration of the given PriceRule(s).\r\n")
    @NotNull
    private Integer duration;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("priceRule")
    @Singular("priceRule")
    @Size(min = 1, max = 8)
    @Valid
    @NotNull
    private List<PriceRule> priceRule;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
