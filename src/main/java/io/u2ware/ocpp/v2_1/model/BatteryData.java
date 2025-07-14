
package io.u2ware.ocpp.v2_1.model;

import java.time.ZonedDateTime;
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
    "evseId",
    "serialNumber",
    "soC",
    "soH",
    "productionDate",
    "vendorInfo",
    "customData"
})
@Generated("jsonschema2pojo")
public class BatteryData {

    /**
     * Slot number where battery is inserted or removed.
     * 
     * (Required)
     * 
     */
    @JsonProperty("evseId")
    @JsonPropertyDescription("Slot number where battery is inserted or removed.\r\n")
    @DecimalMin("0")
    @NotNull
    private Integer evseId;
    /**
     * Serial number of battery.
     * 
     * (Required)
     * 
     */
    @JsonProperty("serialNumber")
    @JsonPropertyDescription("Serial number of battery.\r\n")
    @Size(max = 50)
    @NotNull
    private String serialNumber;
    /**
     * State of charge
     * 
     * (Required)
     * 
     */
    @JsonProperty("soC")
    @JsonPropertyDescription("State of charge\r\n")
    @NotNull
    private Double soC;
    /**
     * State of health
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("soH")
    @JsonPropertyDescription("State of health\r\n\r\n")
    @NotNull
    private Double soH;
    /**
     * Production date of battery.
     * 
     * 
     * 
     */
    @JsonProperty("productionDate")
    @JsonPropertyDescription("Production date of battery.\r\n\r\n")
    private ZonedDateTime productionDate;
    /**
     * Vendor-specific info from battery in undefined format.
     * 
     * 
     */
    @JsonProperty("vendorInfo")
    @JsonPropertyDescription("Vendor-specific info from battery in undefined format.\r\n")
    @Size(max = 500)
    private String vendorInfo;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
