
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
    "attributeType",
    "attributeStatus",
    "attributeStatusInfo",
    "component",
    "variable",
    "customData"
})
@Generated("jsonschema2pojo")
public class SetVariableResult {

    /**
     * Type of attribute: Actual, Target, MinSet, MaxSet. Default is Actual when omitted.
     * 
     * 
     */
    @JsonProperty("attributeType")
    @JsonPropertyDescription("Type of attribute: Actual, Target, MinSet, MaxSet. Default is Actual when omitted.\r\n")
    @lombok.Builder.Default
    private AttributeEnum attributeType = AttributeEnum.fromValue("Actual");
    /**
     * Result status of setting the variable.
     * 
     * (Required)
     * 
     */
    @JsonProperty("attributeStatus")
    @JsonPropertyDescription("Result status of setting the variable.\r\n")
    @NotNull
    private SetVariableStatusEnum attributeStatus;
    /**
     * Element providing more information about the status.
     * 
     * 
     */
    @JsonProperty("attributeStatusInfo")
    @JsonPropertyDescription("Element providing more information about the status.\r\n")
    @Valid
    private StatusInfo attributeStatusInfo;
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
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
