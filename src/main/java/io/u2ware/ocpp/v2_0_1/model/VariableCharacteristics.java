
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
 * Fixed read-only parameters of a variable.
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
    "unit",
    "dataType",
    "minLimit",
    "maxLimit",
    "valuesList",
    "supportsMonitoring"
})
@Generated("jsonschema2pojo")
public class VariableCharacteristics {

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;
    /**
     * Unit of the variable. When the transmitted value has a unit, this field SHALL be included.
     * 
     * 
     */
    @JsonProperty("unit")
    @JsonPropertyDescription("Unit of the variable. When the transmitted value has a unit, this field SHALL be included.\r\n")
    @Size(max = 16)
    private String unit;
    /**
     * Data type of this variable.
     * 
     * (Required)
     * 
     */
    @JsonProperty("dataType")
    @JsonPropertyDescription("Data type of this variable.\r\n")
    @NotNull
    private DataEnum dataType;
    /**
     * Minimum possible value of this variable.
     * 
     * 
     */
    @JsonProperty("minLimit")
    @JsonPropertyDescription("Minimum possible value of this variable.\r\n")
    private Double minLimit;
    /**
     * Maximum possible value of this variable. When the datatype of this Variable is String, OptionList, SequenceList or MemberList, this field defines the maximum length of the (CSV) string.
     * 
     * 
     */
    @JsonProperty("maxLimit")
    @JsonPropertyDescription("Maximum possible value of this variable. When the datatype of this Variable is String, OptionList, SequenceList or MemberList, this field defines the maximum length of the (CSV) string.\r\n")
    private Double maxLimit;
    /**
     * Allowed values when variable is Option/Member/SequenceList. 
     * 
     * * OptionList: The (Actual) Variable value must be a single value from the reported (CSV) enumeration list.
     * 
     * * MemberList: The (Actual) Variable value  may be an (unordered) (sub-)set of the reported (CSV) valid values list.
     * 
     * * SequenceList: The (Actual) Variable value  may be an ordered (priority, etc)  (sub-)set of the reported (CSV) valid values.
     * 
     * This is a comma separated list.
     * 
     * The Configuration Variable &lt;&lt;configkey-configuration-value-size,ConfigurationValueSize&gt;&gt; can be used to limit SetVariableData.attributeValue and VariableCharacteristics.valueList. The max size of these values will always remain equal. 
     * 
     * 
     * 
     */
    @JsonProperty("valuesList")
    @JsonPropertyDescription("Allowed values when variable is Option/Member/SequenceList. \r\n\r\n* OptionList: The (Actual) Variable value must be a single value from the reported (CSV) enumeration list.\r\n\r\n* MemberList: The (Actual) Variable value  may be an (unordered) (sub-)set of the reported (CSV) valid values list.\r\n\r\n* SequenceList: The (Actual) Variable value  may be an ordered (priority, etc)  (sub-)set of the reported (CSV) valid values.\r\n\r\nThis is a comma separated list.\r\n\r\nThe Configuration Variable &lt;&lt;configkey-configuration-value-size,ConfigurationValueSize&gt;&gt; can be used to limit SetVariableData.attributeValue and VariableCharacteristics.valueList. The max size of these values will always remain equal. \r\n\r\n")
    @Size(max = 1000)
    private String valuesList;
    /**
     * Flag indicating if this variable supports monitoring. 
     * 
     * (Required)
     * 
     */
    @JsonProperty("supportsMonitoring")
    @JsonPropertyDescription("Flag indicating if this variable supports monitoring. \r\n")
    @NotNull
    private Boolean supportsMonitoring;

}
