
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

@JsonInclude(JsonInclude.Include.ALWAYS)
@SuperBuilder
@ToString
@Getter
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({
    "controlId",
    "started",
    "timestamp",
    "supersededIds",
    "customData"
})
@Generated("jsonschema2pojo")
public class NotifyDERStartStopRequest {

    /**
     * Id of the started or stopped DER control.
     * Corresponds to the _controlId_ of the SetDERControlRequest.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("controlId")
    @JsonPropertyDescription("Id of the started or stopped DER control.\r\nCorresponds to the _controlId_ of the SetDERControlRequest.\r\n\r\n")
    @Size(max = 36)
    @NotNull
    private String controlId;
    /**
     * True if DER control has started. False if it has ended.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("started")
    @JsonPropertyDescription("True if DER control has started. False if it has ended.\r\n\r\n")
    @NotNull
    private Boolean started;
    /**
     * Time of start or end of event.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("timestamp")
    @JsonPropertyDescription("Time of start or end of event.\r\n\r\n")
    @NotNull
    private ZonedDateTime timestamp;
    /**
     * List of controlIds that are superseded as a result of this control starting.
     * 
     * 
     * 
     */
    @JsonProperty("supersededIds")
    @JsonPropertyDescription("List of controlIds that are superseded as a result of this control starting.\r\n\r\n")
    @Singular("supersededIds")
    @Size(min = 1, max = 24)
    @Valid
    private List<String> supersededIds;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
