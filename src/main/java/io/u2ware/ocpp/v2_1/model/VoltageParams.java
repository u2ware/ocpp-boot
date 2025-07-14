
package io.u2ware.ocpp.v2_1.model;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
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
    "hv10MinMeanValue",
    "hv10MinMeanTripDelay",
    "powerDuringCessation",
    "customData"
})
@Generated("jsonschema2pojo")
public class VoltageParams {

    /**
     * EN 50549-1 chapter 4.9.3.4
     *     Voltage threshold for the 10 min time window mean value monitoring.
     *     The 10 min mean is recalculated up to every 3 s. 
     *     If the present voltage is above this threshold for more than the time defined by _hv10MinMeanValue_, the EV must trip.
     *     This value is mandatory if _hv10MinMeanTripDelay_ is set.
     * 
     * 
     * 
     * 
     */
    @JsonProperty("hv10MinMeanValue")
    @JsonPropertyDescription("EN 50549-1 chapter 4.9.3.4\r\n    Voltage threshold for the 10 min time window mean value monitoring.\r\n    The 10 min mean is recalculated up to every 3 s. \r\n    If the present voltage is above this threshold for more than the time defined by _hv10MinMeanValue_, the EV must trip.\r\n    This value is mandatory if _hv10MinMeanTripDelay_ is set.\r\n\r\n\r\n")
    private Double hv10MinMeanValue;
    /**
     * Time for which the voltage is allowed to stay above the 10 min mean value. 
     *     After this time, the EV must trip.
     *     This value is mandatory if OverVoltageMeanValue10min is set.
     * 
     * 
     * 
     * 
     */
    @JsonProperty("hv10MinMeanTripDelay")
    @JsonPropertyDescription("Time for which the voltage is allowed to stay above the 10 min mean value. \r\n    After this time, the EV must trip.\r\n    This value is mandatory if OverVoltageMeanValue10min is set.\r\n\r\n\r\n")
    private Double hv10MinMeanTripDelay;
    /**
     * Parameter is only sent, if the EV has to feed-in power or reactive power during fault-ride through (FRT) as defined by HVMomCess curve and LVMomCess curve.
     * 
     * 
     * 
     * 
     */
    @JsonProperty("powerDuringCessation")
    @JsonPropertyDescription("Parameter is only sent, if the EV has to feed-in power or reactive power during fault-ride through (FRT) as defined by HVMomCess curve and LVMomCess curve.\r\n\r\n\r\n")
    private PowerDuringCessationEnum powerDuringCessation;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
