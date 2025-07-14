
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
 * A physical or logical component
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
    "evse",
    "name",
    "instance",
    "customData"
})
@Generated("jsonschema2pojo")
public class Component {

    /**
     * Electric Vehicle Supply Equipment
     * 
     * 
     */
    @JsonProperty("evse")
    @JsonPropertyDescription("Electric Vehicle Supply Equipment\r\n")
    @Valid
    private EVSE evse;
    /**
     * Name of the component. Name should be taken from the list of standardized component names whenever possible. Case Insensitive. strongly advised to use Camel Case.
     * 
     * (Required)
     * 
     */
    @JsonProperty("name")
    @JsonPropertyDescription("Name of the component. Name should be taken from the list of standardized component names whenever possible. Case Insensitive. strongly advised to use Camel Case.\r\n")
    @Size(max = 50)
    @NotNull
    private String name;
    /**
     * Name of instance in case the component exists as multiple instances. Case Insensitive. strongly advised to use Camel Case.
     * 
     * 
     */
    @JsonProperty("instance")
    @JsonPropertyDescription("Name of instance in case the component exists as multiple instances. Case Insensitive. strongly advised to use Camel Case.\r\n")
    @Size(max = 50)
    private String instance;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
