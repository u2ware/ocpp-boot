
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


/**
 * The NetworkConnectionProfile defines the functional and technical parameters of a communication link.
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
    "ocppVersion",
    "ocppInterface",
    "ocppTransport",
    "messageTimeout",
    "ocppCsmsUrl",
    "securityProfile",
    "identity",
    "basicAuthPassword",
    "vpn",
    "customData"
})
@Generated("jsonschema2pojo")
public class NetworkConnectionProfile {

    /**
     * Collection of configuration data needed to make a data-connection over a cellular network.
     * 
     * NOTE: When asking a GSM modem to dial in, it is possible to specify which mobile operator should be used. This can be done with the mobile country code (MCC) in combination with a mobile network code (MNC). Example: If your preferred network is Vodafone Netherlands, the MCC=204 and the MNC=04 which means the key PreferredNetwork = 20404 Some modems allows to specify a preferred network, which means, if this network is not available, a different network is used. If you specify UseOnlyPreferredNetwork and this network is not available, the modem will not dial in.
     * 
     * 
     */
    @JsonProperty("apn")
    @JsonPropertyDescription("Collection of configuration data needed to make a data-connection over a cellular network.\r\n\r\nNOTE: When asking a GSM modem to dial in, it is possible to specify which mobile operator should be used. This can be done with the mobile country code (MCC) in combination with a mobile network code (MNC). Example: If your preferred network is Vodafone Netherlands, the MCC=204 and the MNC=04 which means the key PreferredNetwork = 20404 Some modems allows to specify a preferred network, which means, if this network is not available, a different network is used. If you specify UseOnlyPreferredNetwork and this network is not available, the modem will not dial in.\r\n")
    @Valid
    private APN apn;
    /**
     * *(2.1)* This field is ignored, since the OCPP version to use is determined during the websocket handshake. The field is only kept for backwards compatibility with the OCPP 2.0.1 JSON schema.
     * 
     * 
     */
    @JsonProperty("ocppVersion")
    @JsonPropertyDescription("*(2.1)* This field is ignored, since the OCPP version to use is determined during the websocket handshake. The field is only kept for backwards compatibility with the OCPP 2.0.1 JSON schema.\r\n")
    private OCPPVersionEnum ocppVersion;
    /**
     * Applicable Network Interface. Charging Station is allowed to use a different network interface to connect if the given one does not work.
     * 
     * (Required)
     * 
     */
    @JsonProperty("ocppInterface")
    @JsonPropertyDescription("Applicable Network Interface. Charging Station is allowed to use a different network interface to connect if the given one does not work.\r\n")
    @NotNull
    private OCPPInterfaceEnum ocppInterface;
    /**
     * Defines the transport protocol (e.g. SOAP or JSON). Note: SOAP is not supported in OCPP 2.x, but is supported by earlier versions of OCPP.
     * 
     * (Required)
     * 
     */
    @JsonProperty("ocppTransport")
    @JsonPropertyDescription("Defines the transport protocol (e.g. SOAP or JSON). Note: SOAP is not supported in OCPP 2.x, but is supported by earlier versions of OCPP.\r\n")
    @NotNull
    private OCPPTransportEnum ocppTransport;
    /**
     * Duration in seconds before a message send by the Charging Station via this network connection times-out.
     * The best setting depends on the underlying network and response times of the CSMS.
     * If you are looking for a some guideline: use 30 seconds as a starting point.
     * 
     * (Required)
     * 
     */
    @JsonProperty("messageTimeout")
    @JsonPropertyDescription("Duration in seconds before a message send by the Charging Station via this network connection times-out.\r\nThe best setting depends on the underlying network and response times of the CSMS.\r\nIf you are looking for a some guideline: use 30 seconds as a starting point.\r\n")
    @NotNull
    private Integer messageTimeout;
    /**
     * URL of the CSMS(s) that this Charging Station communicates with, without the Charging Station identity part. +
     * The SecurityCtrlr.Identity field is appended to _ocppCsmsUrl_ to provide the full websocket URL.
     * 
     * (Required)
     * 
     */
    @JsonProperty("ocppCsmsUrl")
    @JsonPropertyDescription("URL of the CSMS(s) that this Charging Station communicates with, without the Charging Station identity part. +\r\nThe SecurityCtrlr.Identity field is appended to _ocppCsmsUrl_ to provide the full websocket URL.\r\n")
    @Size(max = 2000)
    @NotNull
    private String ocppCsmsUrl;
    /**
     * This field specifies the security profile used when connecting to the CSMS with this NetworkConnectionProfile.
     * 
     * (Required)
     * 
     */
    @JsonProperty("securityProfile")
    @JsonPropertyDescription("This field specifies the security profile used when connecting to the CSMS with this NetworkConnectionProfile.\r\n")
    @DecimalMin("0")
    @NotNull
    private Integer securityProfile;
    /**
     * *(2.1)* Charging Station identity to be used as the basic authentication username.
     * 
     * 
     */
    @JsonProperty("identity")
    @JsonPropertyDescription("*(2.1)* Charging Station identity to be used as the basic authentication username.\r\n")
    @Size(max = 48)
    private String identity;
    /**
     * *(2.1)* BasicAuthPassword to use for security profile 1 or 2.
     * 
     * 
     */
    @JsonProperty("basicAuthPassword")
    @JsonPropertyDescription("*(2.1)* BasicAuthPassword to use for security profile 1 or 2.\r\n")
    @Size(max = 64)
    private String basicAuthPassword;
    /**
     * VPN Configuration settings
     * 
     * 
     */
    @JsonProperty("vpn")
    @JsonPropertyDescription("VPN Configuration settings\r\n")
    @Valid
    private VPN vpn;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
