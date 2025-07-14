
package io.u2ware.ocpp.v2_1.model;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;


/**
 * Attribute data of a variable.
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
    "type",
    "value",
    "mutability",
    "persistent",
    "constant",
    "customData"
})
@Generated("jsonschema2pojo")
public class VariableAttribute {

    /**
     * Attribute: Actual, MinSet, MaxSet, etc.
     * Defaults to Actual if absent.
     * 
     * 
     */
    @JsonProperty("type")
    @JsonPropertyDescription("Attribute: Actual, MinSet, MaxSet, etc.\r\nDefaults to Actual if absent.\r\n")
    @lombok.Builder.Default
    private AttributeEnum type = AttributeEnum.fromValue("Actual");
    /**
     * Value of the attribute. May only be omitted when mutability is set to 'WriteOnly'.
     * 
     * The Configuration Variable &lt;&lt;configkey-reporting-value-size,ReportingValueSize&gt;&gt; can be used to limit GetVariableResult.attributeValue, VariableAttribute.value and EventData.actualValue. The max size of these values will always remain equal. 
     * 
     * 
     */
    @JsonProperty("value")
    @JsonPropertyDescription("Value of the attribute. May only be omitted when mutability is set to 'WriteOnly'.\r\n\r\nThe Configuration Variable &lt;&lt;configkey-reporting-value-size,ReportingValueSize&gt;&gt; can be used to limit GetVariableResult.attributeValue, VariableAttribute.value and EventData.actualValue. The max size of these values will always remain equal. \r\n")
    @Size(max = 2500)
    private String value;
    /**
     * Defines the mutability of this attribute. Default is ReadWrite when omitted.
     * 
     * 
     */
    @JsonProperty("mutability")
    @JsonPropertyDescription("Defines the mutability of this attribute. Default is ReadWrite when omitted.\r\n")
    @lombok.Builder.Default
    private MutabilityEnum mutability = MutabilityEnum.fromValue("ReadWrite");
    /**
     * If true, value will be persistent across system reboots or power down. Default when omitted is false.
     * 
     * 
     */
    @JsonProperty("persistent")
    @JsonPropertyDescription("If true, value will be persistent across system reboots or power down. Default when omitted is false.\r\n")
    @lombok.Builder.Default
    private Boolean persistent = false;
    /**
     * If true, value that will never be changed by the Charging Station at runtime. Default when omitted is false.
     * 
     * 
     */
    @JsonProperty("constant")
    @JsonPropertyDescription("If true, value that will never be changed by the Charging Station at runtime. Default when omitted is false.\r\n")
    @lombok.Builder.Default
    private Boolean constant = false;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
