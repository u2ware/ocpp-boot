
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

@JsonInclude(JsonInclude.Include.ALWAYS)
@SuperBuilder
@ToString
@Getter
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({
    "startValue",
    "cost",
    "customData"
})
@Generated("jsonschema2pojo")
public class ConsumptionCost {

    /**
     * The lowest level of consumption that defines the starting point of this consumption block. The block interval extends to the start of the next interval.
     * 
     * (Required)
     * 
     */
    @JsonProperty("startValue")
    @JsonPropertyDescription("The lowest level of consumption that defines the starting point of this consumption block. The block interval extends to the start of the next interval.\r\n")
    @NotNull
    private Double startValue;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("cost")
    @Singular("cost")
    @Size(min = 1, max = 3)
    @Valid
    @NotNull
    private List<Cost> cost;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
