
package io.u2ware.ocpp.v2_1.model;

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
    "configurationSlot",
    "connectionData",
    "customData"
})
@Generated("jsonschema2pojo")
public class SetNetworkProfileRequest {

    /**
     * Slot in which the configuration should be stored.
     * 
     * (Required)
     * 
     */
    @JsonProperty("configurationSlot")
    @JsonPropertyDescription("Slot in which the configuration should be stored.\r\n")
    @NotNull
    private Integer configurationSlot;
    /**
     * The NetworkConnectionProfile defines the functional and technical parameters of a communication link.
     * 
     * (Required)
     * 
     */
    @JsonProperty("connectionData")
    @JsonPropertyDescription("The NetworkConnectionProfile defines the functional and technical parameters of a communication link.\r\n")
    @Valid
    @NotNull
    private NetworkConnectionProfile connectionData;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
