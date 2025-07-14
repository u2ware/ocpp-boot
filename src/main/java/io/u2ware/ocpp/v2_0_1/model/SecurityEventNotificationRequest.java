
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

@JsonInclude(JsonInclude.Include.ALWAYS)
@SuperBuilder
@ToString
@Getter
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({
    "customData",
    "type",
    "timestamp",
    "techInfo"
})
@Generated("jsonschema2pojo")
public class SecurityEventNotificationRequest {

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;
    /**
     * Type of the security event. This value should be taken from the Security events list.
     * 
     * (Required)
     * 
     */
    @JsonProperty("type")
    @JsonPropertyDescription("Type of the security event. This value should be taken from the Security events list.\r\n")
    @Size(max = 50)
    @NotNull
    private String type;
    /**
     * Date and time at which the event occurred.
     * 
     * (Required)
     * 
     */
    @JsonProperty("timestamp")
    @JsonPropertyDescription("Date and time at which the event occurred.\r\n")
    @NotNull
    private ZonedDateTime timestamp;
    /**
     * Additional information about the occurred security event.
     * 
     * 
     */
    @JsonProperty("techInfo")
    @JsonPropertyDescription("Additional information about the occurred security event.\r\n")
    @Size(max = 255)
    private String techInfo;

}
