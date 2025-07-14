
package io.u2ware.ocpp.v1_6.model;

import java.net.URI;
import java.time.ZonedDateTime;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;


/**
 * UpdateFirmwareRequest
 * <p>
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
    "location",
    "retries",
    "retrieveDate",
    "retryInterval"
})
@Generated("jsonschema2pojo")
public class UpdateFirmwareRequest {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("location")
    @NotNull
    private URI location;
    @JsonProperty("retries")
    private Integer retries;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("retrieveDate")
    @NotNull
    private ZonedDateTime retrieveDate;
    @JsonProperty("retryInterval")
    private Integer retryInterval;

}
