
package io.u2ware.ocpp.v2_1.model;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
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
    "soc",
    "limit",
    "customData"
})
@Generated("jsonschema2pojo")
public class LimitAtSoC {

    /**
     * The SoC value beyond which the charging rate limit should be applied.
     * 
     * (Required)
     * 
     */
    @JsonProperty("soc")
    @JsonPropertyDescription("The SoC value beyond which the charging rate limit should be applied.\r\n")
    @DecimalMin("0")
    @DecimalMax("1E+2")
    @NotNull
    private Integer soc;
    /**
     * Charging rate limit beyond the SoC value.
     * The unit is defined by _chargingSchedule.chargingRateUnit_.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("limit")
    @JsonPropertyDescription("Charging rate limit beyond the SoC value.\r\nThe unit is defined by _chargingSchedule.chargingRateUnit_.\r\n\r\n")
    @NotNull
    private Double limit;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
