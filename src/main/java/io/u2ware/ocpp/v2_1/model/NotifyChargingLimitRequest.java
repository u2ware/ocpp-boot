
package io.u2ware.ocpp.v2_1.model;

import java.util.List;
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
import lombok.Singular;
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
    "chargingSchedule",
    "evseId",
    "chargingLimit",
    "customData"
})
@Generated("jsonschema2pojo")
public class NotifyChargingLimitRequest {

    @JsonProperty("chargingSchedule")
    @Singular("chargingSchedule")
    @Size(min = 1)
    @Valid
    private List<ChargingSchedule> chargingSchedule;
    /**
     * The EVSE to which the charging limit is set. If absent or when zero, it applies to the entire Charging Station.
     * 
     * 
     */
    @JsonProperty("evseId")
    @JsonPropertyDescription("The EVSE to which the charging limit is set. If absent or when zero, it applies to the entire Charging Station.\r\n")
    @DecimalMin("0")
    private Integer evseId;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingLimit")
    @Valid
    @NotNull
    private ChargingLimit chargingLimit;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
