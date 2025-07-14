
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


/**
 * Class to report components, variables and variable attributes and characteristics.
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
    "component",
    "variable",
    "variableAttribute",
    "variableCharacteristics",
    "customData"
})
@Generated("jsonschema2pojo")
public class ReportData {

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
     * 
     * (Required)
     * 
     */
    @JsonProperty("variableAttribute")
    @Singular("variableAttribute")
    @Size(min = 1, max = 4)
    @Valid
    @NotNull
    private List<VariableAttribute> variableAttribute;
    /**
     * Fixed read-only parameters of a variable.
     * 
     * 
     */
    @JsonProperty("variableCharacteristics")
    @JsonPropertyDescription("Fixed read-only parameters of a variable.\r\n")
    @Valid
    private VariableCharacteristics variableCharacteristics;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
