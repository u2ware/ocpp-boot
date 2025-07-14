
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

@JsonInclude(JsonInclude.Include.ALWAYS)
@SuperBuilder
@ToString
@Getter
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({
    "controlType",
    "gridEventFault",
    "alarmEnded",
    "timestamp",
    "extraInfo",
    "customData"
})
@Generated("jsonschema2pojo")
public class NotifyDERAlarmRequest {

    /**
     * Name of DER control, e.g. LFMustTrip
     * 
     * (Required)
     * 
     */
    @JsonProperty("controlType")
    @JsonPropertyDescription("Name of DER control, e.g. LFMustTrip\r\n")
    @NotNull
    private DERControlEnum controlType;
    /**
     * Type of grid event that caused this
     * 
     * 
     * 
     */
    @JsonProperty("gridEventFault")
    @JsonPropertyDescription("Type of grid event that caused this\r\n\r\n")
    private GridEventFaultEnum gridEventFault;
    /**
     * True when error condition has ended.
     * Absent or false when alarm has started.
     * 
     * 
     * 
     */
    @JsonProperty("alarmEnded")
    @JsonPropertyDescription("True when error condition has ended.\r\nAbsent or false when alarm has started.\r\n\r\n")
    private Boolean alarmEnded;
    /**
     * Time of start or end of alarm.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("timestamp")
    @JsonPropertyDescription("Time of start or end of alarm.\r\n\r\n")
    @NotNull
    private ZonedDateTime timestamp;
    /**
     * Optional info provided by EV.
     * 
     * 
     * 
     */
    @JsonProperty("extraInfo")
    @JsonPropertyDescription("Optional info provided by EV.\r\n\r\n")
    @Size(max = 200)
    private String extraInfo;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
