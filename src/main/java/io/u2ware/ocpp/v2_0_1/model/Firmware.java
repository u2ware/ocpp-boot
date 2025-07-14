
package io.u2ware.ocpp.v2_0_1.model;

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
 * Firmware
 * urn:x-enexis:ecdm:uid:2:233291
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
    "customData",
    "location",
    "retrieveDateTime",
    "installDateTime",
    "signingCertificate",
    "signature"
})
@Generated("jsonschema2pojo")
public class Firmware {

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;
    /**
     * Firmware. Location. URI
     * urn:x-enexis:ecdm:uid:1:569460
     * URI defining the origin of the firmware.
     * 
     * (Required)
     * 
     */
    @JsonProperty("location")
    @JsonPropertyDescription("Firmware. Location. URI\r\nurn:x-enexis:ecdm:uid:1:569460\r\nURI defining the origin of the firmware.\r\n")
    @Size(max = 512)
    @NotNull
    private String location;
    /**
     * Firmware. Retrieve. Date_ Time
     * urn:x-enexis:ecdm:uid:1:569461
     * Date and time at which the firmware shall be retrieved.
     * 
     * (Required)
     * 
     */
    @JsonProperty("retrieveDateTime")
    @JsonPropertyDescription("Firmware. Retrieve. Date_ Time\r\nurn:x-enexis:ecdm:uid:1:569461\r\nDate and time at which the firmware shall be retrieved.\r\n")
    @NotNull
    private ZonedDateTime retrieveDateTime;
    /**
     * Firmware. Install. Date_ Time
     * urn:x-enexis:ecdm:uid:1:569462
     * Date and time at which the firmware shall be installed.
     * 
     * 
     */
    @JsonProperty("installDateTime")
    @JsonPropertyDescription("Firmware. Install. Date_ Time\r\nurn:x-enexis:ecdm:uid:1:569462\r\nDate and time at which the firmware shall be installed.\r\n")
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
     * Firmware. Signature. Signature
     * urn:x-enexis:ecdm:uid:1:569464
     * Base64 encoded firmware signature.
     * 
     * 
     */
    @JsonProperty("signature")
    @JsonPropertyDescription("Firmware. Signature. Signature\r\nurn:x-enexis:ecdm:uid:1:569464\r\nBase64 encoded firmware signature.\r\n")
    @Size(max = 800)
    private String signature;

}
