
package io.u2ware.ocpp.v2_0_1.model;

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


/**
 * Sampled_ Value
 * urn:x-oca:ocpp:uid:2:233266
 * Single sampled value in MeterValues. Each value can be accompanied by optional fields.
 * 
 * To save on mobile data usage, default values of all of the optional fields are such that. The value without any additional fields will be interpreted, as a register reading of active import energy in Wh (Watt-hour) units.
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
    "value",
    "context",
    "measurand",
    "phase",
    "location",
    "signedMeterValue",
    "unitOfMeasure"
})
@Generated("jsonschema2pojo")
public class SampledValue {

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;
    /**
     * Sampled_ Value. Value. Measure
     * urn:x-oca:ocpp:uid:1:569260
     * Indicates the measured value.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("value")
    @JsonPropertyDescription("Sampled_ Value. Value. Measure\r\nurn:x-oca:ocpp:uid:1:569260\r\nIndicates the measured value.\r\n\r\n")
    @NotNull
    private Double value;
    /**
     * Sampled_ Value. Context. Reading_ Context_ Code
     * urn:x-oca:ocpp:uid:1:569261
     * Type of detail value: start, end or sample. Default = "Sample.Periodic"
     * 
     * 
     */
    @JsonProperty("context")
    @JsonPropertyDescription("Sampled_ Value. Context. Reading_ Context_ Code\r\nurn:x-oca:ocpp:uid:1:569261\r\nType of detail value: start, end or sample. Default = \"Sample.Periodic\"\r\n")
    @lombok.Builder.Default
    private ReadingContextEnum context = ReadingContextEnum.fromValue("Sample.Periodic");
    /**
     * Sampled_ Value. Measurand. Measurand_ Code
     * urn:x-oca:ocpp:uid:1:569263
     * Type of measurement. Default = "Energy.Active.Import.Register"
     * 
     * 
     */
    @JsonProperty("measurand")
    @JsonPropertyDescription("Sampled_ Value. Measurand. Measurand_ Code\r\nurn:x-oca:ocpp:uid:1:569263\r\nType of measurement. Default = \"Energy.Active.Import.Register\"\r\n")
    @lombok.Builder.Default
    private MeasurandEnum measurand = MeasurandEnum.fromValue("Energy.Active.Import.Register");
    /**
     * Sampled_ Value. Phase. Phase_ Code
     * urn:x-oca:ocpp:uid:1:569264
     * Indicates how the measured value is to be interpreted. For instance between L1 and neutral (L1-N) Please note that not all values of phase are applicable to all Measurands. When phase is absent, the measured value is interpreted as an overall value.
     * 
     * 
     */
    @JsonProperty("phase")
    @JsonPropertyDescription("Sampled_ Value. Phase. Phase_ Code\r\nurn:x-oca:ocpp:uid:1:569264\r\nIndicates how the measured value is to be interpreted. For instance between L1 and neutral (L1-N) Please note that not all values of phase are applicable to all Measurands. When phase is absent, the measured value is interpreted as an overall value.\r\n")
    private PhaseEnum phase;
    /**
     * Sampled_ Value. Location. Location_ Code
     * urn:x-oca:ocpp:uid:1:569265
     * Indicates where the measured value has been sampled. Default =  "Outlet"
     * 
     * 
     * 
     */
    @JsonProperty("location")
    @JsonPropertyDescription("Sampled_ Value. Location. Location_ Code\r\nurn:x-oca:ocpp:uid:1:569265\r\nIndicates where the measured value has been sampled. Default =  \"Outlet\"\r\n\r\n")
    @lombok.Builder.Default
    private LocationEnum location = LocationEnum.fromValue("Outlet");
    /**
     * Represent a signed version of the meter value.
     * 
     * 
     */
    @JsonProperty("signedMeterValue")
    @JsonPropertyDescription("Represent a signed version of the meter value.\r\n")
    @Valid
    private SignedMeterValue signedMeterValue;
    /**
     * Represents a UnitOfMeasure with a multiplier
     * 
     * 
     */
    @JsonProperty("unitOfMeasure")
    @JsonPropertyDescription("Represents a UnitOfMeasure with a multiplier\r\n")
    @Valid
    private UnitOfMeasure unitOfMeasure;

}
