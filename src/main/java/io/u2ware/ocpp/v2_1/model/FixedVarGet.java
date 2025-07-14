
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
    "fixedVar",
    "id",
    "isDefault",
    "isSuperseded",
    "customData"
})
@Generated("jsonschema2pojo")
public class FixedVarGet {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("fixedVar")
    @Valid
    @NotNull
    private FixedVar fixedVar;
    /**
     * Id of setting
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("Id of setting\r\n\r\n")
    @Size(max = 36)
    @NotNull
    private String id;
    /**
     * True if setting is a default control.
     * 
     * (Required)
     * 
     */
    @JsonProperty("isDefault")
    @JsonPropertyDescription("True if setting is a default control.\r\n")
    @NotNull
    private Boolean isDefault;
    /**
     * True if this setting is superseded by a lower priority setting
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("isSuperseded")
    @JsonPropertyDescription("True if this setting is superseded by a lower priority setting\r\n\r\n")
    @NotNull
    private Boolean isSuperseded;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
