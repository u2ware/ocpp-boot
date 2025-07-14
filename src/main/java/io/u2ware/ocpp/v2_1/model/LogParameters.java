
package io.u2ware.ocpp.v2_1.model;

import java.time.ZonedDateTime;
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
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;


/**
 * Generic class for the configuration of logging entries.
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
    "remoteLocation",
    "oldestTimestamp",
    "latestTimestamp",
    "customData"
})
@Generated("jsonschema2pojo")
public class LogParameters {

    /**
     * The URL of the location at the remote system where the log should be stored.
     * 
     * (Required)
     * 
     */
    @JsonProperty("remoteLocation")
    @JsonPropertyDescription("The URL of the location at the remote system where the log should be stored.\r\n")
    @Size(max = 2000)
    @NotNull
    private String remoteLocation;
    /**
     * This contains the date and time of the oldest logging information to include in the diagnostics.
     * 
     * 
     */
    @JsonProperty("oldestTimestamp")
    @JsonPropertyDescription("This contains the date and time of the oldest logging information to include in the diagnostics.\r\n")
    private ZonedDateTime oldestTimestamp;
    /**
     * This contains the date and time of the latest logging information to include in the diagnostics.
     * 
     * 
     */
    @JsonProperty("latestTimestamp")
    @JsonPropertyDescription("This contains the date and time of the latest logging information to include in the diagnostics.\r\n")
    private ZonedDateTime latestTimestamp;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
