
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
    "customerCertificate",
    "idToken",
    "requestId",
    "report",
    "clear",
    "customerIdentifier"
})
@Generated("jsonschema2pojo")
public class CustomerInformationRequest {

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;
    @JsonProperty("customerCertificate")
    @Valid
    private CertificateHashData customerCertificate;
    /**
     * Contains a case insensitive identifier to use for the authorization and the type of authorization to support multiple forms of identifiers.
     * 
     * 
     */
    @JsonProperty("idToken")
    @JsonPropertyDescription("Contains a case insensitive identifier to use for the authorization and the type of authorization to support multiple forms of identifiers.\r\n")
    @Valid
    private IdToken idToken;
    /**
     * The Id of the request.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestId")
    @JsonPropertyDescription("The Id of the request.\r\n\r\n")
    @NotNull
    private Integer requestId;
    /**
     * Flag indicating whether the Charging Station should return NotifyCustomerInformationRequest messages containing information about the customer referred to.
     * 
     * (Required)
     * 
     */
    @JsonProperty("report")
    @JsonPropertyDescription("Flag indicating whether the Charging Station should return NotifyCustomerInformationRequest messages containing information about the customer referred to.\r\n")
    @NotNull
    private Boolean report;
    /**
     * Flag indicating whether the Charging Station should clear all information about the customer referred to.
     * 
     * (Required)
     * 
     */
    @JsonProperty("clear")
    @JsonPropertyDescription("Flag indicating whether the Charging Station should clear all information about the customer referred to.\r\n")
    @NotNull
    private Boolean clear;
    /**
     * A (e.g. vendor specific) identifier of the customer this request refers to. This field contains a custom identifier other than IdToken and Certificate.
     * One of the possible identifiers (customerIdentifier, customerIdToken or customerCertificate) should be in the request message.
     * 
     * 
     */
    @JsonProperty("customerIdentifier")
    @JsonPropertyDescription("A (e.g. vendor specific) identifier of the customer this request refers to. This field contains a custom identifier other than IdToken and Certificate.\r\nOne of the possible identifiers (customerIdentifier, customerIdToken or customerCertificate) should be in the request message.\r\n")
    @Size(max = 64)
    private String customerIdentifier;

}
