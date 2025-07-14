
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

@JsonInclude(JsonInclude.Include.ALWAYS)
@SuperBuilder
@ToString
@Getter
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({
    "customData",
    "status",
    "statusInfo",
    "schedule"
})
@Generated("jsonschema2pojo")
public class GetCompositeScheduleResponse {

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;
    /**
     * The Charging Station will indicate if it was
     * able to process the request
     * 
     * (Required)
     * 
     */
    @JsonProperty("status")
    @JsonPropertyDescription("The Charging Station will indicate if it was\r\nable to process the request\r\n")
    @NotNull
    private GenericStatusEnum status;
    /**
     * Element providing more information about the status.
     * 
     * 
     */
    @JsonProperty("statusInfo")
    @JsonPropertyDescription("Element providing more information about the status.\r\n")
    @Valid
    private StatusInfo statusInfo;
    /**
     * Composite_ Schedule
     * urn:x-oca:ocpp:uid:2:233362
     * 
     * 
     */
    @JsonProperty("schedule")
    @JsonPropertyDescription("Composite_ Schedule\r\nurn:x-oca:ocpp:uid:2:233362\r\n")
    @Valid
    private CompositeSchedule schedule;

}
