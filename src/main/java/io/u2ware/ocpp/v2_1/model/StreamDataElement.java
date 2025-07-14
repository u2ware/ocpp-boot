
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

@JsonInclude(JsonInclude.Include.ALWAYS)
@SuperBuilder
@ToString
@Getter
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({
    "t",
    "v",
    "customData"
})
@Generated("jsonschema2pojo")
public class StreamDataElement {

    /**
     * Offset relative to _basetime_ of this message. _basetime_ + _t_ is timestamp of recorded value.
     * 
     * (Required)
     * 
     */
    @JsonProperty("t")
    @JsonPropertyDescription("Offset relative to _basetime_ of this message. _basetime_ + _t_ is timestamp of recorded value.\r\n")
    @NotNull
    private Double t;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("v")
    @Size(max = 2500)
    @NotNull
    private String v;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
