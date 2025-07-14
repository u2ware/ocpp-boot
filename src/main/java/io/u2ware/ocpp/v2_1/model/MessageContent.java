
package io.u2ware.ocpp.v2_1.model;

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
    "format",
    "language",
    "content",
    "customData"
})
@Generated("jsonschema2pojo")
public class MessageContent {

    /**
     * Format of the message.
     * 
     * (Required)
     * 
     */
    @JsonProperty("format")
    @JsonPropertyDescription("Format of the message.\r\n")
    @NotNull
    private MessageFormatEnum format;
    /**
     * Message language identifier. Contains a language code as defined in &lt;&lt;ref-RFC5646,[RFC5646]&gt;&gt;.
     * 
     * 
     */
    @JsonProperty("language")
    @JsonPropertyDescription("Message language identifier. Contains a language code as defined in &lt;&lt;ref-RFC5646,[RFC5646]&gt;&gt;.\r\n")
    @Size(max = 8)
    private String language;
    /**
     * *(2.1)* Required. Message contents. +
     * Maximum length supported by Charging Station is given in OCPPCommCtrlr.FieldLength["MessageContentType.content"].
     *     Maximum length defaults to 1024.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("content")
    @JsonPropertyDescription("*(2.1)* Required. Message contents. +\r\nMaximum length supported by Charging Station is given in OCPPCommCtrlr.FieldLength[\"MessageContentType.content\"].\r\n    Maximum length defaults to 1024.\r\n\r\n")
    @Size(max = 1024)
    @NotNull
    private String content;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
