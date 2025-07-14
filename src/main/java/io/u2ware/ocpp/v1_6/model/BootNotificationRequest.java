
package io.u2ware.ocpp.v1_6.model;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;


/**
 * BootNotificationRequest
 * <p>
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
    "chargePointVendor",
    "chargePointModel",
    "chargePointSerialNumber",
    "chargeBoxSerialNumber",
    "firmwareVersion",
    "iccid",
    "imsi",
    "meterType",
    "meterSerialNumber"
})
@Generated("jsonschema2pojo")
public class BootNotificationRequest {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargePointVendor")
    @Size(max = 20)
    @NotNull
    private String chargePointVendor;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargePointModel")
    @Size(max = 20)
    @NotNull
    private String chargePointModel;
    @JsonProperty("chargePointSerialNumber")
    @Size(max = 25)
    private String chargePointSerialNumber;
    @JsonProperty("chargeBoxSerialNumber")
    @Size(max = 25)
    private String chargeBoxSerialNumber;
    @JsonProperty("firmwareVersion")
    @Size(max = 50)
    private String firmwareVersion;
    @JsonProperty("iccid")
    @Size(max = 20)
    private String iccid;
    @JsonProperty("imsi")
    @Size(max = 20)
    private String imsi;
    @JsonProperty("meterType")
    @Size(max = 25)
    private String meterType;
    @JsonProperty("meterSerialNumber")
    @Size(max = 25)
    private String meterSerialNumber;

}
