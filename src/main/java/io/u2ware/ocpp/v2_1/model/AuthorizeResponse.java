
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

@JsonInclude(JsonInclude.Include.ALWAYS)
@SuperBuilder
@ToString
@Getter
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({
    "idTokenInfo",
    "certificateStatus",
    "allowedEnergyTransfer",
    "tariff",
    "customData"
})
@Generated("jsonschema2pojo")
public class AuthorizeResponse {

    /**
     * Contains status information about an identifier.
     * It is advised to not stop charging for a token that expires during charging, as ExpiryDate is only used for caching purposes. If ExpiryDate is not given, the status has no end date.
     * 
     * (Required)
     * 
     */
    @JsonProperty("idTokenInfo")
    @JsonPropertyDescription("Contains status information about an identifier.\r\nIt is advised to not stop charging for a token that expires during charging, as ExpiryDate is only used for caching purposes. If ExpiryDate is not given, the status has no end date.\r\n")
    @Valid
    @NotNull
    private IdTokenInfo idTokenInfo;
    /**
     * Certificate status information. 
     * - if all certificates are valid: return 'Accepted'.
     * - if one of the certificates was revoked, return 'CertificateRevoked'.
     * 
     * 
     */
    @JsonProperty("certificateStatus")
    @JsonPropertyDescription("Certificate status information. \r\n- if all certificates are valid: return 'Accepted'.\r\n- if one of the certificates was revoked, return 'CertificateRevoked'.\r\n")
    private AuthorizeCertificateStatusEnum certificateStatus;
    /**
     * *(2.1)* List of allowed energy transfer modes the EV can choose from. If omitted this defaults to charging only.
     * 
     * 
     * 
     * 
     */
    @JsonProperty("allowedEnergyTransfer")
    @JsonPropertyDescription("*(2.1)* List of allowed energy transfer modes the EV can choose from. If omitted this defaults to charging only.\r\n\r\n\r\n")
    @Singular("allowedEnergyTransfer")
    @Size(min = 1)
    @Valid
    private List<EnergyTransferModeEnum> allowedEnergyTransfer;
    /**
     * A tariff is described by fields with prices for:
     * energy,
     * charging time,
     * idle time,
     * fixed fee,
     * reservation time,
     * reservation fixed fee. +
     * Each of these fields may have (optional) conditions that specify when a price is applicable. +
     * The _description_ contains a human-readable explanation of the tariff to be shown to the user. +
     * The other fields are parameters that define the tariff. These are used by the charging station to calculate the price.
     * 
     * 
     */
    @JsonProperty("tariff")
    @JsonPropertyDescription("A tariff is described by fields with prices for:\r\nenergy,\r\ncharging time,\r\nidle time,\r\nfixed fee,\r\nreservation time,\r\nreservation fixed fee. +\r\nEach of these fields may have (optional) conditions that specify when a price is applicable. +\r\nThe _description_ contains a human-readable explanation of the tariff to be shown to the user. +\r\nThe other fields are parameters that define the tariff. These are used by the charging station to calculate the price.\r\n")
    @Valid
    private Tariff tariff;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
