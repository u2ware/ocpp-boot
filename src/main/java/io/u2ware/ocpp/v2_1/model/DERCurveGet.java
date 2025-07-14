
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
    "curve",
    "id",
    "curveType",
    "isDefault",
    "isSuperseded",
    "customData"
})
@Generated("jsonschema2pojo")
public class DERCurveGet {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("curve")
    @Valid
    @NotNull
    private DERCurve curve;
    /**
     * Id of DER curve
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("Id of DER curve\r\n\r\n")
    @Size(max = 36)
    @NotNull
    private String id;
    /**
     * Type of DER curve
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("curveType")
    @JsonPropertyDescription("Type of DER curve\r\n\r\n")
    @NotNull
    private DERControlEnum curveType;
    /**
     * True if this is a default curve
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("isDefault")
    @JsonPropertyDescription("True if this is a default curve\r\n\r\n")
    @NotNull
    private Boolean isDefault;
    /**
     * True if this setting is superseded by a higher priority setting (i.e. lower value of _priority_)
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("isSuperseded")
    @JsonPropertyDescription("True if this setting is superseded by a higher priority setting (i.e. lower value of _priority_)\r\n\r\n")
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
