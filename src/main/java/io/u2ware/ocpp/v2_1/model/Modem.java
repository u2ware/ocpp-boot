
package io.u2ware.ocpp.v2_1.model;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;


/**
 * Defines parameters required for initiating and maintaining wireless communication with other devices.
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
    "iccid",
    "imsi",
    "customData"
})
@Generated("jsonschema2pojo")
public class Modem {

    /**
     * This contains the ICCID of the modem’s SIM card.
     * 
     * 
     */
    @JsonProperty("iccid")
    @JsonPropertyDescription("This contains the ICCID of the modem\u2019s SIM card.\r\n")
    @Size(max = 20)
    private String iccid;
    /**
     * This contains the IMSI of the modem’s SIM card.
     * 
     * 
     */
    @JsonProperty("imsi")
    @JsonPropertyDescription("This contains the IMSI of the modem\u2019s SIM card.\r\n")
    @Size(max = 20)
    private String imsi;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
