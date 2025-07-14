
package io.u2ware.ocpp.v2_0_1.model;

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
 * Message_ Content
 * urn:x-enexis:ecdm:uid:2:234490
 * Contains message details, for a message to be displayed on a Charging Station.
 * 
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
    "format",
    "language",
    "content"
})
@Generated("jsonschema2pojo")
public class MessageContent {

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;
    /**
     * Message_ Content. Format. Message_ Format_ Code
     * urn:x-enexis:ecdm:uid:1:570848
     * Format of the message.
     * 
     * (Required)
     * 
     */
    @JsonProperty("format")
    @JsonPropertyDescription("Message_ Content. Format. Message_ Format_ Code\r\nurn:x-enexis:ecdm:uid:1:570848\r\nFormat of the message.\r\n")
    @NotNull
    private MessageFormatEnum format;
    /**
     * Message_ Content. Language. Language_ Code
     * urn:x-enexis:ecdm:uid:1:570849
     * Message language identifier. Contains a language code as defined in &lt;&lt;ref-RFC5646,[RFC5646]&gt;&gt;.
     * 
     * 
     */
    @JsonProperty("language")
    @JsonPropertyDescription("Message_ Content. Language. Language_ Code\r\nurn:x-enexis:ecdm:uid:1:570849\r\nMessage language identifier. Contains a language code as defined in &lt;&lt;ref-RFC5646,[RFC5646]&gt;&gt;.\r\n")
    @Size(max = 8)
    private String language;
    /**
     * Message_ Content. Content. Message
     * urn:x-enexis:ecdm:uid:1:570852
     * Message contents.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("content")
    @JsonPropertyDescription("Message_ Content. Content. Message\r\nurn:x-enexis:ecdm:uid:1:570852\r\nMessage contents.\r\n\r\n")
    @Size(max = 512)
    @NotNull
    private String content;

}
