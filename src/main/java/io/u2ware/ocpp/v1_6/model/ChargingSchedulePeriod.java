
package io.u2ware.ocpp.v1_6.model;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotNull;
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
    "startPeriod",
    "limit",
    "numberPhases"
})
@Generated("jsonschema2pojo")
public class ChargingSchedulePeriod {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("startPeriod")
    @NotNull
    private Integer startPeriod;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("limit")
    @NotNull
    private Double limit;
    @JsonProperty("numberPhases")
    private Integer numberPhases;

}
