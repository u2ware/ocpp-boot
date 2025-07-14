
package io.u2ware.ocpp.v2_0_1.model;

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
 * Relative_ Timer_ Interval
 * urn:x-oca:ocpp:uid:2:233270
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
    "start",
    "duration"
})
@Generated("jsonschema2pojo")
public class RelativeTimeInterval {

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;
    /**
     * Relative_ Timer_ Interval. Start. Elapsed_ Time
     * urn:x-oca:ocpp:uid:1:569279
     * Start of the interval, in seconds from NOW.
     * 
     * (Required)
     * 
     */
    @JsonProperty("start")
    @JsonPropertyDescription("Relative_ Timer_ Interval. Start. Elapsed_ Time\r\nurn:x-oca:ocpp:uid:1:569279\r\nStart of the interval, in seconds from NOW.\r\n")
    @NotNull
    private Integer start;
    /**
     * Relative_ Timer_ Interval. Duration. Elapsed_ Time
     * urn:x-oca:ocpp:uid:1:569280
     * Duration of the interval, in seconds.
     * 
     * 
     */
    @JsonProperty("duration")
    @JsonPropertyDescription("Relative_ Timer_ Interval. Duration. Elapsed_ Time\r\nurn:x-oca:ocpp:uid:1:569280\r\nDuration of the interval, in seconds.\r\n")
    private Integer duration;

}
