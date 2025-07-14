
package io.u2ware.ocpp.v2_1.model;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
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
    "id",
    "params",
    "variableMonitoringId",
    "customData"
})
@Generated("jsonschema2pojo")
public class ConstantStreamData {

    /**
     * Uniquely identifies the stream
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("Uniquely identifies the stream\r\n")
    @DecimalMin("0")
    @NotNull
    private Integer id;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("params")
    @Valid
    @NotNull
    private PeriodicEventStreamParams params;
    /**
     * Id of monitor used to report his event. It can be a preconfigured or hardwired monitor.
     * 
     * (Required)
     * 
     */
    @JsonProperty("variableMonitoringId")
    @JsonPropertyDescription("Id of monitor used to report his event. It can be a preconfigured or hardwired monitor.\r\n")
    @DecimalMin("0")
    @NotNull
    private Integer variableMonitoringId;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
