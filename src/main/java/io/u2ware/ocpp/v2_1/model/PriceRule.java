
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


/**
 * Part of ISO 15118-20 price schedule.
 * 
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
    "parkingFeePeriod",
    "carbonDioxideEmission",
    "renewableGenerationPercentage",
    "energyFee",
    "parkingFee",
    "powerRangeStart",
    "customData"
})
@Generated("jsonschema2pojo")
public class PriceRule {

    /**
     * The duration of the parking fee period (in seconds).
     * When the time enters into a ParkingFeePeriod, the ParkingFee will apply to the session. .
     * 
     * 
     */
    @JsonProperty("parkingFeePeriod")
    @JsonPropertyDescription("The duration of the parking fee period (in seconds).\r\nWhen the time enters into a ParkingFeePeriod, the ParkingFee will apply to the session. .\r\n")
    private Integer parkingFeePeriod;
    /**
     * Number of grams of CO2 per kWh.
     * 
     * 
     */
    @JsonProperty("carbonDioxideEmission")
    @JsonPropertyDescription("Number of grams of CO2 per kWh.\r\n")
    @DecimalMin("0")
    private Integer carbonDioxideEmission;
    /**
     * Percentage of the power that is created by renewable resources.
     * 
     * 
     */
    @JsonProperty("renewableGenerationPercentage")
    @JsonPropertyDescription("Percentage of the power that is created by renewable resources.\r\n")
    @DecimalMin("0")
    @DecimalMax("1E+2")
    private Integer renewableGenerationPercentage;
    /**
     * Part of ISO 15118-20 price schedule.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("energyFee")
    @JsonPropertyDescription("Part of ISO 15118-20 price schedule.\r\n\r\n")
    @Valid
    @NotNull
    private RationalNumber energyFee;
    /**
     * Part of ISO 15118-20 price schedule.
     * 
     * 
     * 
     */
    @JsonProperty("parkingFee")
    @JsonPropertyDescription("Part of ISO 15118-20 price schedule.\r\n\r\n")
    @Valid
    private RationalNumber parkingFee;
    /**
     * Part of ISO 15118-20 price schedule.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("powerRangeStart")
    @JsonPropertyDescription("Part of ISO 15118-20 price schedule.\r\n\r\n")
    @Valid
    @NotNull
    private RationalNumber powerRangeStart;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
