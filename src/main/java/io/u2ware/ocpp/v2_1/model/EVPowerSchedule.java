
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
 * *(2.1)* Schedule of EV energy offer.
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
    "evPowerScheduleEntries",
    "timeAnchor",
    "customData"
})
@Generated("jsonschema2pojo")
public class EVPowerSchedule {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("evPowerScheduleEntries")
    @Singular("evPowerScheduleEntries")
    @Size(min = 1, max = 1024)
    @Valid
    @NotNull
    private List<EVPowerScheduleEntry> evPowerScheduleEntries;
    /**
     * The time that defines the starting point for the EVEnergyOffer.
     * 
     * (Required)
     * 
     */
    @JsonProperty("timeAnchor")
    @JsonPropertyDescription("The time that defines the starting point for the EVEnergyOffer.\r\n")
    @NotNull
    private ZonedDateTime timeAnchor;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
