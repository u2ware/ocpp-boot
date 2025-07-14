
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
    "server",
    "user",
    "group",
    "password",
    "key",
    "type",
    "customData"
})
@Generated("jsonschema2pojo")
public class VPN {

    /**
     * VPN Server Address
     * 
     * (Required)
     * 
     */
    @JsonProperty("server")
    @JsonPropertyDescription("VPN Server Address\r\n")
    @Size(max = 2000)
    @NotNull
    private String server;
    /**
     * VPN User
     * 
     * (Required)
     * 
     */
    @JsonProperty("user")
    @JsonPropertyDescription("VPN User\r\n")
    @Size(max = 50)
    @NotNull
    private String user;
    /**
     * VPN group.
     * 
     * 
     */
    @JsonProperty("group")
    @JsonPropertyDescription("VPN group.\r\n")
    @Size(max = 50)
    private String group;
    /**
     * *(2.1)* VPN Password.
     * 
     * (Required)
     * 
     */
    @JsonProperty("password")
    @JsonPropertyDescription("*(2.1)* VPN Password.\r\n")
    @Size(max = 64)
    @NotNull
    private String password;
    /**
     * VPN shared secret.
     * 
     * (Required)
     * 
     */
    @JsonProperty("key")
    @JsonPropertyDescription("VPN shared secret.\r\n")
    @Size(max = 255)
    @NotNull
    private String key;
    /**
     * Type of VPN
     * 
     * (Required)
     * 
     */
    @JsonProperty("type")
    @JsonPropertyDescription("Type of VPN\r\n")
    @NotNull
    private VPNEnum type;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
