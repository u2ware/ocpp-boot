
package io.u2ware.ocpp.v2_1.model;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;


/**
 * This contains the calculated usage of energy, charging time and idle time during a transaction.
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
    "energy",
    "chargingTime",
    "idleTime",
    "reservationTime",
    "customData"
})
@Generated("jsonschema2pojo")
public class TotalUsage {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("energy")
    @NotNull
    private Double energy;
    /**
     * Total duration of the charging session (including the duration of charging and not charging), in seconds.
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingTime")
    @JsonPropertyDescription("Total duration of the charging session (including the duration of charging and not charging), in seconds.\r\n\r\n\r\n")
    @NotNull
    private Integer chargingTime;
    /**
     * Total duration of the charging session where the EV was not charging (no energy was transferred between EVSE and EV), in seconds.
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("idleTime")
    @JsonPropertyDescription("Total duration of the charging session where the EV was not charging (no energy was transferred between EVSE and EV), in seconds.\r\n\r\n\r\n")
    @NotNull
    private Integer idleTime;
    /**
     * Total time of reservation in seconds.
     * 
     * 
     */
    @JsonProperty("reservationTime")
    @JsonPropertyDescription("Total time of reservation in seconds.\r\n")
    private Integer reservationTime;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
