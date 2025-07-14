
package io.u2ware.ocpp.v2_1.model;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
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
    "location",
    "retries",
    "checksum",
    "requestId",
    "retryInterval",
    "customData"
})
@Generated("jsonschema2pojo")
public class PublishFirmwareRequest {

    /**
     * This contains a string containing a URI pointing to a
     * location from which to retrieve the firmware.
     * 
     * (Required)
     * 
     */
    @JsonProperty("location")
    @JsonPropertyDescription("This contains a string containing a URI pointing to a\r\nlocation from which to retrieve the firmware.\r\n")
    @Size(max = 2000)
    @NotNull
    private String location;
    /**
     * This specifies how many times Charging Station must retry
     * to download the firmware before giving up. If this field is not
     * present, it is left to Charging Station to decide how many times it wants to retry.
     * If the value is 0, it means: no retries.
     * 
     * 
     */
    @JsonProperty("retries")
    @JsonPropertyDescription("This specifies how many times Charging Station must retry\r\nto download the firmware before giving up. If this field is not\r\npresent, it is left to Charging Station to decide how many times it wants to retry.\r\nIf the value is 0, it means: no retries.\r\n")
    @DecimalMin("0")
    private Integer retries;
    /**
     * The MD5 checksum over the entire firmware file as a hexadecimal string of length 32. 
     * 
     * (Required)
     * 
     */
    @JsonProperty("checksum")
    @JsonPropertyDescription("The MD5 checksum over the entire firmware file as a hexadecimal string of length 32. \r\n")
    @Size(max = 32)
    @NotNull
    private String checksum;
    /**
     * The Id of the request.
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestId")
    @JsonPropertyDescription("The Id of the request.\r\n")
    @DecimalMin("0")
    @NotNull
    private Integer requestId;
    /**
     * The interval in seconds
     * after which a retry may be
     * attempted. If this field is not
     * present, it is left to Charging
     * Station to decide how long to wait
     * between attempts.
     * 
     * 
     */
    @JsonProperty("retryInterval")
    @JsonPropertyDescription("The interval in seconds\r\nafter which a retry may be\r\nattempted. If this field is not\r\npresent, it is left to Charging\r\nStation to decide how long to wait\r\nbetween attempts.\r\n")
    @DecimalMin("0")
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
