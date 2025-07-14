
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
    "isDefault",
    "controlId",
    "controlType",
    "curve",
    "enterService",
    "fixedPFAbsorb",
    "fixedPFInject",
    "fixedVar",
    "freqDroop",
    "gradient",
    "limitMaxDischarge",
    "customData"
})
@Generated("jsonschema2pojo")
public class SetDERControlRequest {

    /**
     * True if this is a default DER control
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("isDefault")
    @JsonPropertyDescription("True if this is a default DER control\r\n\r\n")
    @NotNull
    private Boolean isDefault;
    /**
     * Unique id of this control, e.g. UUID
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("controlId")
    @JsonPropertyDescription("Unique id of this control, e.g. UUID\r\n\r\n")
    @Size(max = 36)
    @NotNull
    private String controlId;
    /**
     * Type of control.  Determines which setting field below is used.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("controlType")
    @JsonPropertyDescription("Type of control.  Determines which setting field below is used.\r\n\r\n")
    @NotNull
    private DERControlEnum controlType;
    @JsonProperty("curve")
    @Valid
    private DERCurve curve;
    @JsonProperty("enterService")
    @Valid
    private EnterService enterService;
    @JsonProperty("fixedPFAbsorb")
    @Valid
    private FixedPF fixedPFAbsorb;
    @JsonProperty("fixedPFInject")
    @Valid
    private FixedPF fixedPFInject;
    @JsonProperty("fixedVar")
    @Valid
    private FixedVar fixedVar;
    @JsonProperty("freqDroop")
    @Valid
    private FreqDroop freqDroop;
    @JsonProperty("gradient")
    @Valid
    private Gradient gradient;
    @JsonProperty("limitMaxDischarge")
    @Valid
    private LimitMaxDischarge limitMaxDischarge;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
