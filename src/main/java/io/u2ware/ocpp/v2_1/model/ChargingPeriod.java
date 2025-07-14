
package io.u2ware.ocpp.v2_1.model;

import java.time.ZonedDateTime;
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
 * A ChargingPeriodType consists of a start time, and a list of possible values that influence this period, for example: amount of energy charged this period, maximum current during this period etc.
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
    "dimensions",
    "tariffId",
    "startPeriod",
    "customData"
})
@Generated("jsonschema2pojo")
public class ChargingPeriod {

    @JsonProperty("dimensions")
    @Singular("dimensions")
    @Size(min = 1)
    @Valid
    private List<CostDimension> dimensions;
    /**
     * Unique identifier of the Tariff that was used to calculate cost. If not provided, then cost was calculated by some other means.
     * 
     * 
     * 
     */
    @JsonProperty("tariffId")
    @JsonPropertyDescription("Unique identifier of the Tariff that was used to calculate cost. If not provided, then cost was calculated by some other means.\r\n\r\n")
    @Size(max = 60)
    private String tariffId;
    /**
     * Start timestamp of charging period. A period ends when the next period starts. The last period ends when the session ends.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("startPeriod")
    @JsonPropertyDescription("Start timestamp of charging period. A period ends when the next period starts. The last period ends when the session ends.\r\n\r\n")
    @NotNull
    private ZonedDateTime startPeriod;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
