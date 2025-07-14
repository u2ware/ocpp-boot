
package io.u2ware.ocpp.v2_1.model;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;


/**
 * Electric Vehicle Supply Equipment
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
    "id",
    "connectorId",
    "customData"
})
@Generated("jsonschema2pojo")
public class EVSE {

    /**
     * EVSE Identifier. This contains a number (&gt; 0) designating an EVSE of the Charging Station.
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("EVSE Identifier. This contains a number (&gt; 0) designating an EVSE of the Charging Station.\r\n")
    @DecimalMin("0")
    @NotNull
    private Integer id;
    /**
     * An id to designate a specific connector (on an EVSE) by connector index number.
     * 
     * 
     */
    @JsonProperty("connectorId")
    @JsonPropertyDescription("An id to designate a specific connector (on an EVSE) by connector index number.\r\n")
    @DecimalMin("0")
    private Integer connectorId;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
