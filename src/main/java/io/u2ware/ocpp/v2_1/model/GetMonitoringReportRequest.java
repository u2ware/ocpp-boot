
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
    "componentVariable",
    "requestId",
    "monitoringCriteria",
    "customData"
})
@Generated("jsonschema2pojo")
public class GetMonitoringReportRequest {

    @JsonProperty("componentVariable")
    @Singular("componentVariable")
    @Size(min = 1)
    @Valid
    private List<ComponentVariable> componentVariable;
    /**
     * The Id of the request.
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestId")
    @JsonPropertyDescription("The Id of the request.\r\n")
    @NotNull
    private Integer requestId;
    /**
     * This field contains criteria for components for which a monitoring report is requested
     * 
     * 
     */
    @JsonProperty("monitoringCriteria")
    @JsonPropertyDescription("This field contains criteria for components for which a monitoring report is requested\r\n")
    @Singular("monitoringCriteria")
    @Size(min = 1, max = 3)
    @Valid
    private List<MonitoringCriterionEnum> monitoringCriteria;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
