
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


/**
 * Data necessary to request the revocation status of a certificate.
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
    "certificateHashData",
    "source",
    "urls",
    "customData"
})
@Generated("jsonschema2pojo")
public class CertificateStatusRequestInfo {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("certificateHashData")
    @Valid
    @NotNull
    private CertificateHashData certificateHashData;
    /**
     * Source of status: OCSP, CRL
     * 
     * (Required)
     * 
     */
    @JsonProperty("source")
    @JsonPropertyDescription("Source of status: OCSP, CRL\r\n")
    @NotNull
    private CertificateStatusSourceEnum source;
    /**
     * URL(s) of _source_.
     * 
     * (Required)
     * 
     */
    @JsonProperty("urls")
    @JsonPropertyDescription("URL(s) of _source_.\r\n")
    @Singular("urls")
    @Size(min = 1, max = 5)
    @Valid
    @NotNull
    private List<String> urls;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
