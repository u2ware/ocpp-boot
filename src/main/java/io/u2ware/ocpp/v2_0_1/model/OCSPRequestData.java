
package io.u2ware.ocpp.v2_0_1.model;

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
    "customData",
    "hashAlgorithm",
    "issuerNameHash",
    "issuerKeyHash",
    "serialNumber",
    "responderURL"
})
@Generated("jsonschema2pojo")
public class OCSPRequestData {

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;
    /**
     * Used algorithms for the hashes provided.
     * 
     * (Required)
     * 
     */
    @JsonProperty("hashAlgorithm")
    @JsonPropertyDescription("Used algorithms for the hashes provided.\r\n")
    @NotNull
    private HashAlgorithmEnum hashAlgorithm;
    /**
     * Hashed value of the Issuer DN (Distinguished Name).
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("issuerNameHash")
    @JsonPropertyDescription("Hashed value of the Issuer DN (Distinguished Name).\r\n\r\n")
    @Size(max = 128)
    @NotNull
    private String issuerNameHash;
    /**
     * Hashed value of the issuers public key
     * 
     * (Required)
     * 
     */
    @JsonProperty("issuerKeyHash")
    @JsonPropertyDescription("Hashed value of the issuers public key\r\n")
    @Size(max = 128)
    @NotNull
    private String issuerKeyHash;
    /**
     * The serial number of the certificate.
     * 
     * (Required)
     * 
     */
    @JsonProperty("serialNumber")
    @JsonPropertyDescription("The serial number of the certificate.\r\n")
    @Size(max = 40)
    @NotNull
    private String serialNumber;
    /**
     * This contains the responder URL (Case insensitive). 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("responderURL")
    @JsonPropertyDescription("This contains the responder URL (Case insensitive). \r\n\r\n")
    @Size(max = 512)
    @NotNull
    private String responderURL;

}
