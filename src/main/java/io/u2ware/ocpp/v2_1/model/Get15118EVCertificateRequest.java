
package io.u2ware.ocpp.v2_1.model;

import java.util.List;
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
import lombok.Singular;
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
    "iso15118SchemaVersion",
    "action",
    "exiRequest",
    "maximumContractCertificateChains",
    "prioritizedEMAIDs",
    "customData"
})
@Generated("jsonschema2pojo")
public class Get15118EVCertificateRequest {

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
     * *(2.1)* Raw CertificateInstallationReq request from EV, Base64 encoded. +
     * Extended to support ISO 15118-20 certificates. The minimum supported length is 11000. If a longer _exiRequest_ is supported, then the supported length must be communicated in variable OCPPCommCtrlr.FieldLength[ "Get15118EVCertificateRequest.exiRequest" ].
     * 
     * (Required)
     * 
     */
    @JsonProperty("exiRequest")
    @JsonPropertyDescription("*(2.1)* Raw CertificateInstallationReq request from EV, Base64 encoded. +\r\nExtended to support ISO 15118-20 certificates. The minimum supported length is 11000. If a longer _exiRequest_ is supported, then the supported length must be communicated in variable OCPPCommCtrlr.FieldLength[ \"Get15118EVCertificateRequest.exiRequest\" ].\r\n")
    @Size(max = 11000)
    @NotNull
    private String exiRequest;
    /**
     * *(2.1)* Absent during ISO 15118-2 session. Required during ISO 15118-20 session. +
     * Maximum number of contracts that EV wants to install.
     * 
     * 
     */
    @JsonProperty("maximumContractCertificateChains")
    @JsonPropertyDescription("*(2.1)* Absent during ISO 15118-2 session. Required during ISO 15118-20 session. +\r\nMaximum number of contracts that EV wants to install.\r\n")
    @DecimalMin("0")
    private Integer maximumContractCertificateChains;
    /**
     * *(2.1)*  Absent during ISO 15118-2 session. Optional during ISO 15118-20 session. List of EMAIDs for which contract certificates must be requested first, in case there are more certificates than allowed by _maximumContractCertificateChains_.
     * 
     * 
     */
    @JsonProperty("prioritizedEMAIDs")
    @JsonPropertyDescription("*(2.1)*  Absent during ISO 15118-2 session. Optional during ISO 15118-20 session. List of EMAIDs for which contract certificates must be requested first, in case there are more certificates than allowed by _maximumContractCertificateChains_.\r\n")
    @Singular("prioritizedEMAIDs")
    @Size(min = 1, max = 8)
    @Valid
    private List<String> prioritizedEMAIDs;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
