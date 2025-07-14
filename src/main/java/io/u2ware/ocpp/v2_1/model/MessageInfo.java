
package io.u2ware.ocpp.v2_1.model;

import java.time.ZonedDateTime;
import java.util.List;
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
import lombok.Singular;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;


/**
 * Contains message details, for a message to be displayed on a Charging Station.
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
    "display",
    "id",
    "priority",
    "state",
    "startDateTime",
    "endDateTime",
    "transactionId",
    "message",
    "messageExtra",
    "customData"
})
@Generated("jsonschema2pojo")
public class MessageInfo {

    /**
     * A physical or logical component
     * 
     * 
     */
    @JsonProperty("display")
    @JsonPropertyDescription("A physical or logical component\r\n")
    @Valid
    private Component display;
    /**
     * Unique id within an exchange context. It is defined within the OCPP context as a positive Integer value (greater or equal to zero).
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("Unique id within an exchange context. It is defined within the OCPP context as a positive Integer value (greater or equal to zero).\r\n")
    @DecimalMin("0")
    @NotNull
    private Integer id;
    /**
     * With what priority should this message be shown
     * 
     * (Required)
     * 
     */
    @JsonProperty("priority")
    @JsonPropertyDescription("With what priority should this message be shown\r\n")
    @NotNull
    private MessagePriorityEnum priority;
    /**
     * During what state should this message be shown. When omitted this message should be shown in any state of the Charging Station.
     * 
     * 
     */
    @JsonProperty("state")
    @JsonPropertyDescription("During what state should this message be shown. When omitted this message should be shown in any state of the Charging Station.\r\n")
    private MessageStateEnum state;
    /**
     * From what date-time should this message be shown. If omitted: directly.
     * 
     * 
     */
    @JsonProperty("startDateTime")
    @JsonPropertyDescription("From what date-time should this message be shown. If omitted: directly.\r\n")
    private ZonedDateTime startDateTime;
    /**
     * Until what date-time should this message be shown, after this date/time this message SHALL be removed.
     * 
     * 
     */
    @JsonProperty("endDateTime")
    @JsonPropertyDescription("Until what date-time should this message be shown, after this date/time this message SHALL be removed.\r\n")
    private ZonedDateTime endDateTime;
    /**
     * During which transaction shall this message be shown.
     * Message SHALL be removed by the Charging Station after transaction has
     * ended.
     * 
     * 
     */
    @JsonProperty("transactionId")
    @JsonPropertyDescription("During which transaction shall this message be shown.\r\nMessage SHALL be removed by the Charging Station after transaction has\r\nended.\r\n")
    @Size(max = 36)
    private String transactionId;
    /**
     * Contains message details, for a message to be displayed on a Charging Station.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("message")
    @JsonPropertyDescription("Contains message details, for a message to be displayed on a Charging Station.\r\n\r\n")
    @Valid
    @NotNull
    private MessageContent message;
    @JsonProperty("messageExtra")
    @Singular("messageExtra")
    @Size(min = 1, max = 4)
    @Valid
    private List<MessageContent> messageExtra;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
