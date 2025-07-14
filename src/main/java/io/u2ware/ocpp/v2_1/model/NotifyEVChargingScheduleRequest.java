
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
    "timeBase",
    "chargingSchedule",
    "evseId",
    "selectedChargingScheduleId",
    "powerToleranceAcceptance",
    "customData"
})
@Generated("jsonschema2pojo")
public class NotifyEVChargingScheduleRequest {

    /**
     * Periods contained in the charging profile are relative to this point in time.
     * 
     * (Required)
     * 
     */
    @JsonProperty("timeBase")
    @JsonPropertyDescription("Periods contained in the charging profile are relative to this point in time.\r\n")
    @NotNull
    private ZonedDateTime timeBase;
    /**
     * Charging schedule structure defines a list of charging periods, as used in: NotifyEVChargingScheduleRequest and ChargingProfileType. When used in a NotifyEVChargingScheduleRequest only _duration_ and _chargingSchedulePeriod_ are relevant and _chargingRateUnit_ must be 'W'. +
     * An ISO 15118-20 session may provide either an _absolutePriceSchedule_ or a _priceLevelSchedule_. An ISO 15118-2 session can only provide a_salesTariff_ element. The field _digestValue_ is used when price schedule or sales tariff are signed.
     * 
     * image::images/ChargingSchedule-Simple.png[]
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingSchedule")
    @JsonPropertyDescription("Charging schedule structure defines a list of charging periods, as used in: NotifyEVChargingScheduleRequest and ChargingProfileType. When used in a NotifyEVChargingScheduleRequest only _duration_ and _chargingSchedulePeriod_ are relevant and _chargingRateUnit_ must be 'W'. +\r\nAn ISO 15118-20 session may provide either an _absolutePriceSchedule_ or a _priceLevelSchedule_. An ISO 15118-2 session can only provide a_salesTariff_ element. The field _digestValue_ is used when price schedule or sales tariff are signed.\r\n\r\nimage::images/ChargingSchedule-Simple.png[]\r\n\r\n\r\n")
    @Valid
    @NotNull
    private ChargingSchedule chargingSchedule;
    /**
     * The charging schedule contained in this notification applies to an EVSE. EvseId must be &gt; 0.
     * 
     * (Required)
     * 
     */
    @JsonProperty("evseId")
    @JsonPropertyDescription("The charging schedule contained in this notification applies to an EVSE. EvseId must be &gt; 0.\r\n")
    @DecimalMin("1")
    @NotNull
    private Integer evseId;
    /**
     * *(2.1)* Id  of the _chargingSchedule_ that EV selected from the provided ChargingProfile.
     * 
     * 
     */
    @JsonProperty("selectedChargingScheduleId")
    @JsonPropertyDescription("*(2.1)* Id  of the _chargingSchedule_ that EV selected from the provided ChargingProfile.\r\n")
    @DecimalMin("0")
    private Integer selectedChargingScheduleId;
    /**
     * *(2.1)* True when power tolerance is accepted by EV.
     * This value is taken from EVPowerProfile.PowerToleranceAcceptance in the ISO 15118-20 PowerDeliverReq message..
     * 
     * 
     */
    @JsonProperty("powerToleranceAcceptance")
    @JsonPropertyDescription("*(2.1)* True when power tolerance is accepted by EV.\r\nThis value is taken from EVPowerProfile.PowerToleranceAcceptance in the ISO 15118-20 PowerDeliverReq message..\r\n")
    private Boolean powerToleranceAcceptance;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
