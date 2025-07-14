
package io.u2ware.ocpp.v2_1.model;

import java.time.ZonedDateTime;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;


/**
 * Revocation status of certificate
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
    "status",
    "nextUpdate",
    "customData"
})
@Generated("jsonschema2pojo")
public class CertificateStatus {

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
     * Status of certificate: good, revoked or unknown.
     * 
     * (Required)
     * 
     */
    @JsonProperty("status")
    @JsonPropertyDescription("Status of certificate: good, revoked or unknown.\r\n")
    @NotNull
    private CertificateStatusEnum status;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("nextUpdate")
    @NotNull
    private ZonedDateTime nextUpdate;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
