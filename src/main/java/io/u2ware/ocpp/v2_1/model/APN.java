
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


/**
 * Collection of configuration data needed to make a data-connection over a cellular network.
 * 
 * NOTE: When asking a GSM modem to dial in, it is possible to specify which mobile operator should be used. This can be done with the mobile country code (MCC) in combination with a mobile network code (MNC). Example: If your preferred network is Vodafone Netherlands, the MCC=204 and the MNC=04 which means the key PreferredNetwork = 20404 Some modems allows to specify a preferred network, which means, if this network is not available, a different network is used. If you specify UseOnlyPreferredNetwork and this network is not available, the modem will not dial in.
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
    "apn",
    "apnUserName",
    "apnPassword",
    "simPin",
    "preferredNetwork",
    "useOnlyPreferredNetwork",
    "apnAuthentication",
    "customData"
})
@Generated("jsonschema2pojo")
public class APN {

    /**
     * The Access Point Name as an URL.
     * 
     * (Required)
     * 
     */
    @JsonProperty("apn")
    @JsonPropertyDescription("The Access Point Name as an URL.\r\n")
    @Size(max = 2000)
    @NotNull
    private String apn;
    /**
     * APN username.
     * 
     * 
     */
    @JsonProperty("apnUserName")
    @JsonPropertyDescription("APN username.\r\n")
    @Size(max = 50)
    private String apnUserName;
    /**
     * *(2.1)* APN Password.
     * 
     * 
     */
    @JsonProperty("apnPassword")
    @JsonPropertyDescription("*(2.1)* APN Password.\r\n")
    @Size(max = 64)
    private String apnPassword;
    /**
     * SIM card pin code.
     * 
     * 
     */
    @JsonProperty("simPin")
    @JsonPropertyDescription("SIM card pin code.\r\n")
    private Integer simPin;
    /**
     * Preferred network, written as MCC and MNC concatenated. See note.
     * 
     * 
     */
    @JsonProperty("preferredNetwork")
    @JsonPropertyDescription("Preferred network, written as MCC and MNC concatenated. See note.\r\n")
    @Size(max = 6)
    private String preferredNetwork;
    /**
     * Default: false. Use only the preferred Network, do
     * not dial in when not available. See Note.
     * 
     * 
     */
    @JsonProperty("useOnlyPreferredNetwork")
    @JsonPropertyDescription("Default: false. Use only the preferred Network, do\r\nnot dial in when not available. See Note.\r\n")
    @lombok.Builder.Default
    private Boolean useOnlyPreferredNetwork = false;
    /**
     * Authentication method.
     * 
     * (Required)
     * 
     */
    @JsonProperty("apnAuthentication")
    @JsonPropertyDescription("Authentication method.\r\n")
    @NotNull
    private APNAuthenticationEnum apnAuthentication;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
