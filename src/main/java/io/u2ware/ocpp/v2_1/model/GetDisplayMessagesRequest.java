
package io.u2ware.ocpp.v2_1.model;

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
    "id",
    "requestId",
    "priority",
    "state",
    "customData"
})
@Generated("jsonschema2pojo")
public class GetDisplayMessagesRequest {

    /**
     * If provided the Charging Station shall return Display Messages of the given ids. This field SHALL NOT contain more ids than set in &lt;&lt;configkey-number-of-display-messages,NumberOfDisplayMessages.maxLimit&gt;&gt;
     * 
     * 
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("If provided the Charging Station shall return Display Messages of the given ids. This field SHALL NOT contain more ids than set in &lt;&lt;configkey-number-of-display-messages,NumberOfDisplayMessages.maxLimit&gt;&gt;\r\n\r\n")
    @Singular("id")
    @Size(min = 1)
    @Valid
    private List<Integer> id;
    /**
     * The Id of this request.
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestId")
    @JsonPropertyDescription("The Id of this request.\r\n")
    @NotNull
    private Integer requestId;
    /**
     * If provided the Charging Station shall return Display Messages with the given priority only.
     * 
     * 
     */
    @JsonProperty("priority")
    @JsonPropertyDescription("If provided the Charging Station shall return Display Messages with the given priority only.\r\n")
    private MessagePriorityEnum priority;
    /**
     * If provided the Charging Station shall return Display Messages with the given state only. 
     * 
     * 
     */
    @JsonProperty("state")
    @JsonPropertyDescription("If provided the Charging Station shall return Display Messages with the given state only. \r\n")
    private MessageStateEnum state;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
