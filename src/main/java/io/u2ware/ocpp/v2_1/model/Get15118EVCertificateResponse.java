
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
    "status",
    "statusInfo",
    "exiResponse",
    "remainingContracts",
    "customData"
})
@Generated("jsonschema2pojo")
public class Get15118EVCertificateResponse {

    /**
     * Indicates whether the message was processed properly.
     * 
     * (Required)
     * 
     */
    @JsonProperty("status")
    @JsonPropertyDescription("Indicates whether the message was processed properly.\r\n")
    @NotNull
    private Iso15118EVCertificateStatusEnum status;
    /**
     * Element providing more information about the status.
     * 
     * 
     */
    @JsonProperty("statusInfo")
    @JsonPropertyDescription("Element providing more information about the status.\r\n")
    @Valid
    private StatusInfo statusInfo;
    /**
     * *(2/1)* Raw CertificateInstallationRes response for the EV, Base64 encoded. +
     * Extended to support ISO 15118-20 certificates. The minimum supported length is 17000. If a longer _exiResponse_ is supported, then the supported length must be communicated in variable OCPPCommCtrlr.FieldLength[ "Get15118EVCertificateResponse.exiResponse" ].
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("exiResponse")
    @JsonPropertyDescription("*(2/1)* Raw CertificateInstallationRes response for the EV, Base64 encoded. +\r\nExtended to support ISO 15118-20 certificates. The minimum supported length is 17000. If a longer _exiResponse_ is supported, then the supported length must be communicated in variable OCPPCommCtrlr.FieldLength[ \"Get15118EVCertificateResponse.exiResponse\" ].\r\n\r\n")
    @Size(max = 17000)
    @NotNull
    private String exiResponse;
    /**
     * *(2.1)* Number of contracts that can be retrieved with additional requests.
     * 
     * 
     */
    @JsonProperty("remainingContracts")
    @JsonPropertyDescription("*(2.1)* Number of contracts that can be retrieved with additional requests.\r\n")
    @DecimalMin("0")
    private Integer remainingContracts;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
