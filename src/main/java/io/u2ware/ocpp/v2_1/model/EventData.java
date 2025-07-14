
package io.u2ware.ocpp.v2_1.model;

import java.time.ZonedDateTime;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;


/**
 * Class to report an event notification for a component-variable.
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
    "eventId",
    "timestamp",
    "trigger",
    "cause",
    "actualValue",
    "techCode",
    "techInfo",
    "cleared",
    "transactionId",
    "component",
    "variableMonitoringId",
    "eventNotificationType",
    "variable",
    "severity",
    "customData"
})
@Generated("jsonschema2pojo")
public class EventData {

    /**
     * Identifies the event. This field can be referred to as a cause by other events.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("eventId")
    @JsonPropertyDescription("Identifies the event. This field can be referred to as a cause by other events.\r\n\r\n")
    @DecimalMin("0")
    @NotNull
    private Integer eventId;
    /**
     * Timestamp of the moment the report was generated.
     * 
     * (Required)
     * 
     */
    @JsonProperty("timestamp")
    @JsonPropertyDescription("Timestamp of the moment the report was generated.\r\n")
    @NotNull
    private ZonedDateTime timestamp;
    /**
     * Type of trigger for this event, e.g. exceeding a threshold value.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("trigger")
    @JsonPropertyDescription("Type of trigger for this event, e.g. exceeding a threshold value.\r\n\r\n")
    @NotNull
    private EventTriggerEnum trigger;
    /**
     * Refers to the Id of an event that is considered to be the cause for this event.
     * 
     * 
     * 
     */
    @JsonProperty("cause")
    @JsonPropertyDescription("Refers to the Id of an event that is considered to be the cause for this event.\r\n\r\n")
    @DecimalMin("0")
    private Integer cause;
    /**
     * Actual value (_attributeType_ Actual) of the variable.
     * 
     * The Configuration Variable &lt;&lt;configkey-reporting-value-size,ReportingValueSize&gt;&gt; can be used to limit GetVariableResult.attributeValue, VariableAttribute.value and EventData.actualValue. The max size of these values will always remain equal. 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("actualValue")
    @JsonPropertyDescription("Actual value (_attributeType_ Actual) of the variable.\r\n\r\nThe Configuration Variable &lt;&lt;configkey-reporting-value-size,ReportingValueSize&gt;&gt; can be used to limit GetVariableResult.attributeValue, VariableAttribute.value and EventData.actualValue. The max size of these values will always remain equal. \r\n\r\n")
    @Size(max = 2500)
    @NotNull
    private String actualValue;
    /**
     * Technical (error) code as reported by component.
     * 
     * 
     */
    @JsonProperty("techCode")
    @JsonPropertyDescription("Technical (error) code as reported by component.\r\n")
    @Size(max = 50)
    private String techCode;
    /**
     * Technical detail information as reported by component.
     * 
     * 
     */
    @JsonProperty("techInfo")
    @JsonPropertyDescription("Technical detail information as reported by component.\r\n")
    @Size(max = 500)
    private String techInfo;
    /**
     * _Cleared_ is set to true to report the clearing of a monitored situation, i.e. a 'return to normal'. 
     * 
     * 
     * 
     */
    @JsonProperty("cleared")
    @JsonPropertyDescription("_Cleared_ is set to true to report the clearing of a monitored situation, i.e. a 'return to normal'. \r\n\r\n")
    private Boolean cleared;
    /**
     * If an event notification is linked to a specific transaction, this field can be used to specify its transactionId.
     * 
     * 
     */
    @JsonProperty("transactionId")
    @JsonPropertyDescription("If an event notification is linked to a specific transaction, this field can be used to specify its transactionId.\r\n")
    @Size(max = 36)
    private String transactionId;
    /**
     * A physical or logical component
     * 
     * (Required)
     * 
     */
    @JsonProperty("component")
    @JsonPropertyDescription("A physical or logical component\r\n")
    @Valid
    @NotNull
    private Component component;
    /**
     * Identifies the VariableMonitoring which triggered the event.
     * 
     * 
     */
    @JsonProperty("variableMonitoringId")
    @JsonPropertyDescription("Identifies the VariableMonitoring which triggered the event.\r\n")
    @DecimalMin("0")
    private Integer variableMonitoringId;
    /**
     * Specifies the event notification type of the message.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("eventNotificationType")
    @JsonPropertyDescription("Specifies the event notification type of the message.\r\n\r\n")
    @NotNull
    private EventNotificationEnum eventNotificationType;
    /**
     * Reference key to a component-variable.
     * 
     * (Required)
     * 
     */
    @JsonProperty("variable")
    @JsonPropertyDescription("Reference key to a component-variable.\r\n")
    @Valid
    @NotNull
    private Variable variable;
    /**
     * *(2.1)* Severity associated with the monitor in _variableMonitoringId_ or with the hardwired notification.
     * 
     * 
     */
    @JsonProperty("severity")
    @JsonPropertyDescription("*(2.1)* Severity associated with the monitor in _variableMonitoringId_ or with the hardwired notification.\r\n")
    @DecimalMin("0")
    private Integer severity;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
