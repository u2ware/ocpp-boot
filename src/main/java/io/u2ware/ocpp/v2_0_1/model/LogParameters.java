
package io.u2ware.ocpp.v2_0_1.model;

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
 * Log
 * urn:x-enexis:ecdm:uid:2:233373
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
    "customData",
    "remoteLocation",
    "oldestTimestamp",
    "latestTimestamp"
})
@Generated("jsonschema2pojo")
public class LogParameters {

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;
    /**
     * Log. Remote_ Location. URI
     * urn:x-enexis:ecdm:uid:1:569484
     * The URL of the location at the remote system where the log should be stored.
     * 
     * (Required)
     * 
     */
    @JsonProperty("remoteLocation")
    @JsonPropertyDescription("Log. Remote_ Location. URI\r\nurn:x-enexis:ecdm:uid:1:569484\r\nThe URL of the location at the remote system where the log should be stored.\r\n")
    @Size(max = 512)
    @NotNull
    private String remoteLocation;
    /**
     * Log. Oldest_ Timestamp. Date_ Time
     * urn:x-enexis:ecdm:uid:1:569477
     * This contains the date and time of the oldest logging information to include in the diagnostics.
     * 
     * 
     */
    @JsonProperty("oldestTimestamp")
    @JsonPropertyDescription("Log. Oldest_ Timestamp. Date_ Time\r\nurn:x-enexis:ecdm:uid:1:569477\r\nThis contains the date and time of the oldest logging information to include in the diagnostics.\r\n")
    private ZonedDateTime oldestTimestamp;
    /**
     * Log. Latest_ Timestamp. Date_ Time
     * urn:x-enexis:ecdm:uid:1:569482
     * This contains the date and time of the latest logging information to include in the diagnostics.
     * 
     * 
     */
    @JsonProperty("latestTimestamp")
    @JsonPropertyDescription("Log. Latest_ Timestamp. Date_ Time\r\nurn:x-enexis:ecdm:uid:1:569482\r\nThis contains the date and time of the latest logging information to include in the diagnostics.\r\n")
    private ZonedDateTime latestTimestamp;

}
