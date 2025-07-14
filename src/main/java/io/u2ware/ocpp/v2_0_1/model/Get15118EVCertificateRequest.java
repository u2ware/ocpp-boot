
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
    "iso15118SchemaVersion",
    "action",
    "exiRequest"
})
@Generated("jsonschema2pojo")
public class Get15118EVCertificateRequest {

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;
    /**
     * Schema version currently used for the 15118 session between EV and Charging Station. Needed for parsing of the EXI stream by the CSMS.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("iso15118SchemaVersion")
    @JsonPropertyDescription("Schema version currently used for the 15118 session between EV and Charging Station. Needed for parsing of the EXI stream by the CSMS.\r\n\r\n")
    @Size(max = 50)
    @NotNull
    private String iso15118SchemaVersion;
    /**
     * Defines whether certificate needs to be installed or updated.
     * 
     * (Required)
     * 
     */
    @JsonProperty("action")
    @JsonPropertyDescription("Defines whether certificate needs to be installed or updated.\r\n")
    @NotNull
    private CertificateActionEnum action;
    /**
     * Raw CertificateInstallationReq request from EV, Base64 encoded.
     * 
     * (Required)
     * 
     */
    @JsonProperty("exiRequest")
    @JsonPropertyDescription("Raw CertificateInstallationReq request from EV, Base64 encoded.\r\n")
    @Size(max = 5600)
    @NotNull
    private String exiRequest;

}
