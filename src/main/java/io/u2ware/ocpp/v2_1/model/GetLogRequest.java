
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
    "log",
    "logType",
    "requestId",
    "retries",
    "retryInterval",
    "customData"
})
@Generated("jsonschema2pojo")
public class GetLogRequest {

    /**
     * Generic class for the configuration of logging entries.
     * 
     * (Required)
     * 
     */
    @JsonProperty("log")
    @JsonPropertyDescription("Generic class for the configuration of logging entries.\r\n")
    @Valid
    @NotNull
    private LogParameters log;
    /**
     * This contains the type of log file that the Charging Station
     * should send.
     * 
     * (Required)
     * 
     */
    @JsonProperty("logType")
    @JsonPropertyDescription("This contains the type of log file that the Charging Station\r\nshould send.\r\n")
    @NotNull
    private LogEnum logType;
    /**
     * The Id of this request
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestId")
    @JsonPropertyDescription("The Id of this request\r\n")
    @NotNull
    private Integer requestId;
    /**
     * This specifies how many times the Charging Station must retry to upload the log before giving up. If this field is not present, it is left to Charging Station to decide how many times it wants to retry. If the value is 0, it means: no retries.
     * 
     * 
     */
    @JsonProperty("retries")
    @JsonPropertyDescription("This specifies how many times the Charging Station must retry to upload the log before giving up. If this field is not present, it is left to Charging Station to decide how many times it wants to retry. If the value is 0, it means: no retries.\r\n")
    @DecimalMin("0")
    private Integer retries;
    /**
     * The interval in seconds after which a retry may be attempted. If this field is not present, it is left to Charging Station to decide how long to wait between attempts.
     * 
     * 
     */
    @JsonProperty("retryInterval")
    @JsonPropertyDescription("The interval in seconds after which a retry may be attempted. If this field is not present, it is left to Charging Station to decide how long to wait between attempts.\r\n")
    private Integer retryInterval;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
