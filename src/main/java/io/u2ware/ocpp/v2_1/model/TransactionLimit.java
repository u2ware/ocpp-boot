
package io.u2ware.ocpp.v2_1.model;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;


/**
 * Cost, energy, time or SoC limit for a transaction.
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
    "maxCost",
    "maxEnergy",
    "maxTime",
    "maxSoC",
    "customData"
})
@Generated("jsonschema2pojo")
public class TransactionLimit {

    /**
     * Maximum allowed cost of transaction in currency of tariff.
     * 
     * 
     */
    @JsonProperty("maxCost")
    @JsonPropertyDescription("Maximum allowed cost of transaction in currency of tariff.\r\n")
    private Double maxCost;
    /**
     * Maximum allowed energy in Wh to charge in transaction.
     * 
     * 
     */
    @JsonProperty("maxEnergy")
    @JsonPropertyDescription("Maximum allowed energy in Wh to charge in transaction.\r\n")
    private Double maxEnergy;
    /**
     * Maximum duration of transaction in seconds from start to end.
     * 
     * 
     */
    @JsonProperty("maxTime")
    @JsonPropertyDescription("Maximum duration of transaction in seconds from start to end.\r\n")
    private Integer maxTime;
    /**
     * Maximum State of Charge of EV in percentage.
     * 
     * 
     */
    @JsonProperty("maxSoC")
    @JsonPropertyDescription("Maximum State of Charge of EV in percentage.\r\n")
    @DecimalMin("0")
    @DecimalMax("1E+2")
    private Integer maxSoC;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
