
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
 * VPN
 * urn:x-oca:ocpp:uid:2:233268
 * VPN Configuration settings
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
    "server",
    "user",
    "group",
    "password",
    "key",
    "type"
})
@Generated("jsonschema2pojo")
public class VPN {

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;
    /**
     * VPN. Server. URI
     * urn:x-oca:ocpp:uid:1:569272
     * VPN Server Address
     * 
     * (Required)
     * 
     */
    @JsonProperty("server")
    @JsonPropertyDescription("VPN. Server. URI\r\nurn:x-oca:ocpp:uid:1:569272\r\nVPN Server Address\r\n")
    @Size(max = 512)
    @NotNull
    private String server;
    /**
     * VPN. User. User_ Name
     * urn:x-oca:ocpp:uid:1:569273
     * VPN User
     * 
     * (Required)
     * 
     */
    @JsonProperty("user")
    @JsonPropertyDescription("VPN. User. User_ Name\r\nurn:x-oca:ocpp:uid:1:569273\r\nVPN User\r\n")
    @Size(max = 20)
    @NotNull
    private String user;
    /**
     * VPN. Group. Group_ Name
     * urn:x-oca:ocpp:uid:1:569274
     * VPN group.
     * 
     * 
     */
    @JsonProperty("group")
    @JsonPropertyDescription("VPN. Group. Group_ Name\r\nurn:x-oca:ocpp:uid:1:569274\r\nVPN group.\r\n")
    @Size(max = 20)
    private String group;
    /**
     * VPN. Password. Password
     * urn:x-oca:ocpp:uid:1:569275
     * VPN Password.
     * 
     * (Required)
     * 
     */
    @JsonProperty("password")
    @JsonPropertyDescription("VPN. Password. Password\r\nurn:x-oca:ocpp:uid:1:569275\r\nVPN Password.\r\n")
    @Size(max = 20)
    @NotNull
    private String password;
    /**
     * VPN. Key. VPN_ Key
     * urn:x-oca:ocpp:uid:1:569276
     * VPN shared secret.
     * 
     * (Required)
     * 
     */
    @JsonProperty("key")
    @JsonPropertyDescription("VPN. Key. VPN_ Key\r\nurn:x-oca:ocpp:uid:1:569276\r\nVPN shared secret.\r\n")
    @Size(max = 255)
    @NotNull
    private String key;
    /**
     * VPN. Type. VPN_ Code
     * urn:x-oca:ocpp:uid:1:569277
     * Type of VPN
     * 
     * (Required)
     * 
     */
    @JsonProperty("type")
    @JsonPropertyDescription("VPN. Type. VPN_ Code\r\nurn:x-oca:ocpp:uid:1:569277\r\nType of VPN\r\n")
    @NotNull
    private VPNEnum type;

}
