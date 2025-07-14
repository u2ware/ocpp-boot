
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
 * Charge_ Point
 * urn:x-oca:ocpp:uid:2:233122
 * The physical system where an Electrical Vehicle (EV) can be charged.
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
    "serialNumber",
    "model",
    "modem",
    "vendorName",
    "firmwareVersion"
})
@Generated("jsonschema2pojo")
public class ChargingStation {

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;
    /**
     * Device. Serial_ Number. Serial_ Number
     * urn:x-oca:ocpp:uid:1:569324
     * Vendor-specific device identifier.
     * 
     * 
     */
    @JsonProperty("serialNumber")
    @JsonPropertyDescription("Device. Serial_ Number. Serial_ Number\r\nurn:x-oca:ocpp:uid:1:569324\r\nVendor-specific device identifier.\r\n")
    @Size(max = 25)
    private String serialNumber;
    /**
     * Device. Model. CI20_ Text
     * urn:x-oca:ocpp:uid:1:569325
     * Defines the model of the device.
     * 
     * (Required)
     * 
     */
    @JsonProperty("model")
    @JsonPropertyDescription("Device. Model. CI20_ Text\r\nurn:x-oca:ocpp:uid:1:569325\r\nDefines the model of the device.\r\n")
    @Size(max = 20)
    @NotNull
    private String model;
    /**
     * Wireless_ Communication_ Module
     * urn:x-oca:ocpp:uid:2:233306
     * Defines parameters required for initiating and maintaining wireless communication with other devices.
     * 
     * 
     */
    @JsonProperty("modem")
    @JsonPropertyDescription("Wireless_ Communication_ Module\r\nurn:x-oca:ocpp:uid:2:233306\r\nDefines parameters required for initiating and maintaining wireless communication with other devices.\r\n")
    @Valid
    private Modem modem;
    /**
     * Identifies the vendor (not necessarily in a unique manner).
     * 
     * (Required)
     * 
     */
    @JsonProperty("vendorName")
    @JsonPropertyDescription("Identifies the vendor (not necessarily in a unique manner).\r\n")
    @Size(max = 50)
    @NotNull
    private String vendorName;
    /**
     * This contains the firmware version of the Charging Station.
     * 
     * 
     * 
     */
    @JsonProperty("firmwareVersion")
    @JsonPropertyDescription("This contains the firmware version of the Charging Station.\r\n\r\n")
    @Size(max = 50)
    private String firmwareVersion;

}
