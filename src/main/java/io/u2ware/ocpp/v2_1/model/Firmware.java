
package io.u2ware.ocpp.v2_1.model;

import java.time.ZonedDateTime;
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
 * Represents a copy of the firmware that can be loaded/updated on the Charging Station.
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
    "location",
    "retrieveDateTime",
    "installDateTime",
    "signingCertificate",
    "signature",
    "customData"
})
@Generated("jsonschema2pojo")
public class Firmware {

    /**
     * URI defining the origin of the firmware.
     * 
     * (Required)
     * 
     */
    @JsonProperty("location")
    @JsonPropertyDescription("URI defining the origin of the firmware.\r\n")
    @Size(max = 2000)
    @NotNull
    private String location;
    /**
     * Date and time at which the firmware shall be retrieved.
     * 
     * (Required)
     * 
     */
    @JsonProperty("retrieveDateTime")
    @JsonPropertyDescription("Date and time at which the firmware shall be retrieved.\r\n")
    @NotNull
    private ZonedDateTime retrieveDateTime;
    /**
     * Date and time at which the firmware shall be installed.
     * 
     * 
     */
    @JsonProperty("installDateTime")
    @JsonPropertyDescription("Date and time at which the firmware shall be installed.\r\n")
    private ZonedDateTime installDateTime;
    /**
     * Certificate with which the firmware was signed.
     * PEM encoded X.509 certificate.
     * 
     * 
     */
    @JsonProperty("signingCertificate")
    @JsonPropertyDescription("Certificate with which the firmware was signed.\r\nPEM encoded X.509 certificate.\r\n")
    @Size(max = 5500)
    private String signingCertificate;
    /**
     * Base64 encoded firmware signature.
     * 
     * 
     */
    @JsonProperty("signature")
    @JsonPropertyDescription("Base64 encoded firmware signature.\r\n")
    @Size(max = 800)
    private String signature;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
