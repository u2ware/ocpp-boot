
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
 * Message_ Info
 * urn:x-enexis:ecdm:uid:2:233264
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
    "customData",
    "display",
    "id",
    "priority",
    "state",
    "startDateTime",
    "endDateTime",
    "transactionId",
    "message"
})
@Generated("jsonschema2pojo")
public class MessageInfo {

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;
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
     * Identified_ Object. MRID. Numeric_ Identifier
     * urn:x-enexis:ecdm:uid:1:569198
     * Master resource identifier, unique within an exchange context. It is defined within the OCPP context as a positive Integer value (greater or equal to zero).
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("Identified_ Object. MRID. Numeric_ Identifier\r\nurn:x-enexis:ecdm:uid:1:569198\r\nMaster resource identifier, unique within an exchange context. It is defined within the OCPP context as a positive Integer value (greater or equal to zero).\r\n")
    @NotNull
    private Integer id;
    /**
     * Message_ Info. Priority. Message_ Priority_ Code
     * urn:x-enexis:ecdm:uid:1:569253
     * With what priority should this message be shown
     * 
     * (Required)
     * 
     */
    @JsonProperty("priority")
    @JsonPropertyDescription("Message_ Info. Priority. Message_ Priority_ Code\r\nurn:x-enexis:ecdm:uid:1:569253\r\nWith what priority should this message be shown\r\n")
    @NotNull
    private MessagePriorityEnum priority;
    /**
     * Message_ Info. State. Message_ State_ Code
     * urn:x-enexis:ecdm:uid:1:569254
     * During what state should this message be shown. When omitted this message should be shown in any state of the Charging Station.
     * 
     * 
     */
    @JsonProperty("state")
    @JsonPropertyDescription("Message_ Info. State. Message_ State_ Code\r\nurn:x-enexis:ecdm:uid:1:569254\r\nDuring what state should this message be shown. When omitted this message should be shown in any state of the Charging Station.\r\n")
    private MessageStateEnum state;
    /**
     * Message_ Info. Start. Date_ Time
     * urn:x-enexis:ecdm:uid:1:569256
     * From what date-time should this message be shown. If omitted: directly.
     * 
     * 
     */
    @JsonProperty("startDateTime")
    @JsonPropertyDescription("Message_ Info. Start. Date_ Time\r\nurn:x-enexis:ecdm:uid:1:569256\r\nFrom what date-time should this message be shown. If omitted: directly.\r\n")
    private ZonedDateTime startDateTime;
    /**
     * Message_ Info. End. Date_ Time
     * urn:x-enexis:ecdm:uid:1:569257
     * Until what date-time should this message be shown, after this date/time this message SHALL be removed.
     * 
     * 
     */
    @JsonProperty("endDateTime")
    @JsonPropertyDescription("Message_ Info. End. Date_ Time\r\nurn:x-enexis:ecdm:uid:1:569257\r\nUntil what date-time should this message be shown, after this date/time this message SHALL be removed.\r\n")
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
     * Message_ Content
     * urn:x-enexis:ecdm:uid:2:234490
     * Contains message details, for a message to be displayed on a Charging Station.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("message")
    @JsonPropertyDescription("Message_ Content\r\nurn:x-enexis:ecdm:uid:2:234490\r\nContains message details, for a message to be displayed on a Charging Station.\r\n\r\n")
    @Valid
    @NotNull
    private MessageContent message;

}
