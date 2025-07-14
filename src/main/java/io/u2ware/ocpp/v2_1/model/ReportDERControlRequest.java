
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

@JsonInclude(JsonInclude.Include.ALWAYS)
@SuperBuilder
@ToString
@Getter
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({
    "curve",
    "enterService",
    "fixedPFAbsorb",
    "fixedPFInject",
    "fixedVar",
    "freqDroop",
    "gradient",
    "limitMaxDischarge",
    "requestId",
    "tbc",
    "customData"
})
@Generated("jsonschema2pojo")
public class ReportDERControlRequest {

    @JsonProperty("curve")
    @Singular("curve")
    @Size(min = 1, max = 24)
    @Valid
    private List<DERCurveGet> curve;
    @JsonProperty("enterService")
    @Singular("enterService")
    @Size(min = 1, max = 24)
    @Valid
    private List<EnterServiceGet> enterService;
    @JsonProperty("fixedPFAbsorb")
    @Singular("fixedPFAbsorb")
    @Size(min = 1, max = 24)
    @Valid
    private List<FixedPFGet> fixedPFAbsorb;
    @JsonProperty("fixedPFInject")
    @Singular("fixedPFInject")
    @Size(min = 1, max = 24)
    @Valid
    private List<FixedPFGet> fixedPFInject;
    @JsonProperty("fixedVar")
    @Singular("fixedVar")
    @Size(min = 1, max = 24)
    @Valid
    private List<FixedVarGet> fixedVar;
    @JsonProperty("freqDroop")
    @Singular("freqDroop")
    @Size(min = 1, max = 24)
    @Valid
    private List<FreqDroopGet> freqDroop;
    @JsonProperty("gradient")
    @Singular("gradient")
    @Size(min = 1, max = 24)
    @Valid
    private List<GradientGet> gradient;
    @JsonProperty("limitMaxDischarge")
    @Singular("limitMaxDischarge")
    @Size(min = 1, max = 24)
    @Valid
    private List<LimitMaxDischargeGet> limitMaxDischarge;
    /**
     * RequestId from GetDERControlRequest.
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestId")
    @JsonPropertyDescription("RequestId from GetDERControlRequest.\r\n")
    @NotNull
    private Integer requestId;
    /**
     * To Be Continued. Default value when omitted: false. +
     * False indicates that there are no further messages as part of this report.
     * 
     * 
     */
    @JsonProperty("tbc")
    @JsonPropertyDescription("To Be Continued. Default value when omitted: false. +\r\nFalse indicates that there are no further messages as part of this report.\r\n")
    private Boolean tbc;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
