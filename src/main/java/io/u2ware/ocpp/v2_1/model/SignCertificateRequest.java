
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
    "csr",
    "certificateType",
    "hashRootCertificate",
    "requestId",
    "customData"
})
@Generated("jsonschema2pojo")
public class SignCertificateRequest {

    /**
     * The Charging Station SHALL send the public key in form of a Certificate Signing Request (CSR) as described in RFC 2986 [22] and then PEM encoded, using the &lt;&lt;signcertificaterequest,SignCertificateRequest&gt;&gt; message.
     * 
     * (Required)
     * 
     */
    @JsonProperty("csr")
    @JsonPropertyDescription("The Charging Station SHALL send the public key in form of a Certificate Signing Request (CSR) as described in RFC 2986 [22] and then PEM encoded, using the &lt;&lt;signcertificaterequest,SignCertificateRequest&gt;&gt; message.\r\n")
    @Size(max = 5500)
    @NotNull
    private String csr;
    /**
     * Indicates the type of certificate that is to be signed. When omitted the certificate is to be used for both the 15118 connection (if implemented) and the Charging Station to CSMS connection.
     * 
     * 
     * 
     */
    @JsonProperty("certificateType")
    @JsonPropertyDescription("Indicates the type of certificate that is to be signed. When omitted the certificate is to be used for both the 15118 connection (if implemented) and the Charging Station to CSMS connection.\r\n\r\n")
    private CertificateSigningUseEnum certificateType;
    @JsonProperty("hashRootCertificate")
    @Valid
    private CertificateHashData hashRootCertificate;
    /**
     * *(2.1)* RequestId to match this message with the CertificateSignedRequest.
     * 
     * 
     */
    @JsonProperty("requestId")
    @JsonPropertyDescription("*(2.1)* RequestId to match this message with the CertificateSignedRequest.\r\n")
    private Integer requestId;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
