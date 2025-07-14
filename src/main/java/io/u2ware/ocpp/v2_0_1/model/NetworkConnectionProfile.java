
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


/**
 * Communication_ Function
 * urn:x-oca:ocpp:uid:2:233304
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
    "customData",
    "apn",
    "ocppVersion",
    "ocppTransport",
    "ocppCsmsUrl",
    "messageTimeout",
    "securityProfile",
    "ocppInterface",
    "vpn"
})
@Generated("jsonschema2pojo")
public class NetworkConnectionProfile {

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;
    /**
     * APN
     * urn:x-oca:ocpp:uid:2:233134
     * Collection of configuration data needed to make a data-connection over a cellular network.
     * 
     * NOTE: When asking a GSM modem to dial in, it is possible to specify which mobile operator should be used. This can be done with the mobile country code (MCC) in combination with a mobile network code (MNC). Example: If your preferred network is Vodafone Netherlands, the MCC=204 and the MNC=04 which means the key PreferredNetwork = 20404 Some modems allows to specify a preferred network, which means, if this network is not available, a different network is used. If you specify UseOnlyPreferredNetwork and this network is not available, the modem will not dial in.
     * 
     * 
     */
    @JsonProperty("apn")
    @JsonPropertyDescription("APN\r\nurn:x-oca:ocpp:uid:2:233134\r\nCollection of configuration data needed to make a data-connection over a cellular network.\r\n\r\nNOTE: When asking a GSM modem to dial in, it is possible to specify which mobile operator should be used. This can be done with the mobile country code (MCC) in combination with a mobile network code (MNC). Example: If your preferred network is Vodafone Netherlands, the MCC=204 and the MNC=04 which means the key PreferredNetwork = 20404 Some modems allows to specify a preferred network, which means, if this network is not available, a different network is used. If you specify UseOnlyPreferredNetwork and this network is not available, the modem will not dial in.\r\n")
    @Valid
    private APN apn;
    /**
     * Communication_ Function. OCPP_ Version. OCPP_ Version_ Code
     * urn:x-oca:ocpp:uid:1:569355
     * Defines the OCPP version used for this communication function.
     * 
     * (Required)
     * 
     */
    @JsonProperty("ocppVersion")
    @JsonPropertyDescription("Communication_ Function. OCPP_ Version. OCPP_ Version_ Code\r\nurn:x-oca:ocpp:uid:1:569355\r\nDefines the OCPP version used for this communication function.\r\n")
    @NotNull
    private OCPPVersionEnum ocppVersion;
    /**
     * Communication_ Function. OCPP_ Transport. OCPP_ Transport_ Code
     * urn:x-oca:ocpp:uid:1:569356
     * Defines the transport protocol (e.g. SOAP or JSON). Note: SOAP is not supported in OCPP 2.0, but is supported by other versions of OCPP.
     * 
     * (Required)
     * 
     */
    @JsonProperty("ocppTransport")
    @JsonPropertyDescription("Communication_ Function. OCPP_ Transport. OCPP_ Transport_ Code\r\nurn:x-oca:ocpp:uid:1:569356\r\nDefines the transport protocol (e.g. SOAP or JSON). Note: SOAP is not supported in OCPP 2.0, but is supported by other versions of OCPP.\r\n")
    @NotNull
    private OCPPTransportEnum ocppTransport;
    /**
     * Communication_ Function. OCPP_ Central_ System_ URL. URI
     * urn:x-oca:ocpp:uid:1:569357
     * URL of the CSMS(s) that this Charging Station  communicates with.
     * 
     * (Required)
     * 
     */
    @JsonProperty("ocppCsmsUrl")
    @JsonPropertyDescription("Communication_ Function. OCPP_ Central_ System_ URL. URI\r\nurn:x-oca:ocpp:uid:1:569357\r\nURL of the CSMS(s) that this Charging Station  communicates with.\r\n")
    @Size(max = 512)
    @NotNull
    private String ocppCsmsUrl;
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
     * This field specifies the security profile used when connecting to the CSMS with this NetworkConnectionProfile.
     * 
     * (Required)
     * 
     */
    @JsonProperty("securityProfile")
    @JsonPropertyDescription("This field specifies the security profile used when connecting to the CSMS with this NetworkConnectionProfile.\r\n")
    @NotNull
    private Integer securityProfile;
    /**
     * Applicable Network Interface.
     * 
     * (Required)
     * 
     */
    @JsonProperty("ocppInterface")
    @JsonPropertyDescription("Applicable Network Interface.\r\n")
    @NotNull
    private OCPPInterfaceEnum ocppInterface;
    /**
     * VPN
     * urn:x-oca:ocpp:uid:2:233268
     * VPN Configuration settings
     * 
     * 
     */
    @JsonProperty("vpn")
    @JsonPropertyDescription("VPN\r\nurn:x-oca:ocpp:uid:2:233268\r\nVPN Configuration settings\r\n")
    @Valid
    private VPN vpn;

}
