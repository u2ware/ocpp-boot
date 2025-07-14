
package io.u2ware.ocpp.v2_1.model;

import java.util.List;
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
import lombok.Singular;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;


/**
 * These conditions describe if and when a TariffEnergyType or TariffTimeType applies during a transaction.
 * 
 * When more than one restriction is set, they are to be treated as a logical AND. All need to be valid before this price is active.
 * 
 * For reverse energy flow (discharging) negative values of energy, power and current are used.
 * 
 * NOTE: _minXXX_ (where XXX = Kwh/A/Kw) must be read as "closest to zero", and _maxXXX_ as "furthest from zero". For example, a *charging* power range from 10 kW to 50 kWh is given by _minPower_ = 10000 and _maxPower_ = 50000, and a *discharging* power range from -10 kW to -50 kW is given by _minPower_ = -10 and _maxPower_ = -50.
 * 
 * NOTE: _startTimeOfDay_ and _endTimeOfDay_ are in local time, because it is the time in the tariff as it is shown to the EV driver at the Charging Station.
 * A Charging Station will convert this to the internal time zone that it uses (which is recommended to be UTC, see section Generic chapter 3.1) when performing cost calculation.
 * 
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
    "startTimeOfDay",
    "endTimeOfDay",
    "dayOfWeek",
    "validFromDate",
    "validToDate",
    "evseKind",
    "minEnergy",
    "maxEnergy",
    "minCurrent",
    "maxCurrent",
    "minPower",
    "maxPower",
    "minTime",
    "maxTime",
    "minChargingTime",
    "maxChargingTime",
    "minIdleTime",
    "maxIdleTime",
    "customData"
})
@Generated("jsonschema2pojo")
public class TariffConditions {

    /**
     * Start time of day in local time. +
     * Format as per RFC 3339: time-hour ":" time-minute  +
     * Must be in 24h format with leading zeros. Hour/Minute separator: ":"
     * Regex: ([0-1][0-9]\|2[0-3]):[0-5][0-9]
     * 
     * 
     */
    @JsonProperty("startTimeOfDay")
    @JsonPropertyDescription("Start time of day in local time. +\r\nFormat as per RFC 3339: time-hour \":\" time-minute  +\r\nMust be in 24h format with leading zeros. Hour/Minute separator: \":\"\r\nRegex: ([0-1][0-9]\\|2[0-3]):[0-5][0-9]\r\n")
    private String startTimeOfDay;
    /**
     * End time of day in local time. Same syntax as _startTimeOfDay_. +
     *     If end time &lt; start time then the period wraps around to the next day. +
     *     To stop at end of the day use: 00:00.
     * 
     * 
     */
    @JsonProperty("endTimeOfDay")
    @JsonPropertyDescription("End time of day in local time. Same syntax as _startTimeOfDay_. +\r\n    If end time &lt; start time then the period wraps around to the next day. +\r\n    To stop at end of the day use: 00:00.\r\n")
    private String endTimeOfDay;
    /**
     * Day(s) of the week this is tariff applies.
     * 
     * 
     */
    @JsonProperty("dayOfWeek")
    @JsonPropertyDescription("Day(s) of the week this is tariff applies.\r\n")
    @Singular("dayOfWeek")
    @Size(min = 1, max = 7)
    @Valid
    private List<DayOfWeekEnum> dayOfWeek;
    /**
     * Start date in local time, for example: 2015-12-24.
     * Valid from this day (inclusive). +
     * Format as per RFC 3339: full-date  + 
     * 
     * Regex: ([12][0-9]{3})-(0[1-9]\|1[0-2])-(0[1-9]\|[12][0-9]\|3[01])
     * 
     * 
     */
    @JsonProperty("validFromDate")
    @JsonPropertyDescription("Start date in local time, for example: 2015-12-24.\r\nValid from this day (inclusive). +\r\nFormat as per RFC 3339: full-date  + \r\n\r\nRegex: ([12][0-9]{3})-(0[1-9]\\|1[0-2])-(0[1-9]\\|[12][0-9]\\|3[01])\r\n")
    private String validFromDate;
    /**
     * End date in local time, for example: 2015-12-27.
     *     Valid until this day (exclusive). Same syntax as _validFromDate_.
     * 
     * 
     */
    @JsonProperty("validToDate")
    @JsonPropertyDescription("End date in local time, for example: 2015-12-27.\r\n    Valid until this day (exclusive). Same syntax as _validFromDate_.\r\n")
    private String validToDate;
    /**
     * Type of EVSE (AC, DC) this tariff applies to.
     * 
     * 
     */
    @JsonProperty("evseKind")
    @JsonPropertyDescription("Type of EVSE (AC, DC) this tariff applies to.\r\n")
    private EvseKindEnum evseKind;
    /**
     * Minimum consumed energy in Wh, for example 20000 Wh.
     *     Valid from this amount of energy (inclusive) being used.
     * 
     * 
     */
    @JsonProperty("minEnergy")
    @JsonPropertyDescription("Minimum consumed energy in Wh, for example 20000 Wh.\r\n    Valid from this amount of energy (inclusive) being used.\r\n")
    private Double minEnergy;
    /**
     * Maximum consumed energy in Wh, for example 50000 Wh.
     *     Valid until this amount of energy (exclusive) being used.
     * 
     * 
     */
    @JsonProperty("maxEnergy")
    @JsonPropertyDescription("Maximum consumed energy in Wh, for example 50000 Wh.\r\n    Valid until this amount of energy (exclusive) being used.\r\n")
    private Double maxEnergy;
    /**
     * Sum of the minimum current (in Amperes) over all phases, for example 5 A.
     *     When the EV is charging with more than, or equal to, the defined amount of current, this price is/becomes active. If the charging current is or becomes lower, this price is not or no longer valid and becomes inactive. +
     *     This is NOT about the minimum current over the entire transaction.
     * 
     * 
     */
    @JsonProperty("minCurrent")
    @JsonPropertyDescription("Sum of the minimum current (in Amperes) over all phases, for example 5 A.\r\n    When the EV is charging with more than, or equal to, the defined amount of current, this price is/becomes active. If the charging current is or becomes lower, this price is not or no longer valid and becomes inactive. +\r\n    This is NOT about the minimum current over the entire transaction.\r\n")
    private Double minCurrent;
    /**
     * Sum of the maximum current (in Amperes) over all phases, for example 20 A.
     *       When the EV is charging with less than the defined amount of current, this price becomes/is active. If the charging current is or becomes higher, this price is not or no longer valid and becomes inactive.
     *       This is NOT about the maximum current over the entire transaction.
     * 
     * 
     */
    @JsonProperty("maxCurrent")
    @JsonPropertyDescription("Sum of the maximum current (in Amperes) over all phases, for example 20 A.\r\n      When the EV is charging with less than the defined amount of current, this price becomes/is active. If the charging current is or becomes higher, this price is not or no longer valid and becomes inactive.\r\n      This is NOT about the maximum current over the entire transaction.\r\n")
    private Double maxCurrent;
    /**
     * Minimum power in W, for example 5000 W.
     *       When the EV is charging with more than, or equal to, the defined amount of power, this price is/becomes active.
     *       If the charging power is or becomes lower, this price is not or no longer valid and becomes inactive.
     *       This is NOT about the minimum power over the entire transaction.
     * 
     * 
     */
    @JsonProperty("minPower")
    @JsonPropertyDescription("Minimum power in W, for example 5000 W.\r\n      When the EV is charging with more than, or equal to, the defined amount of power, this price is/becomes active.\r\n      If the charging power is or becomes lower, this price is not or no longer valid and becomes inactive.\r\n      This is NOT about the minimum power over the entire transaction.\r\n")
    private Double minPower;
    /**
     * Maximum power in W, for example 20000 W.
     *       When the EV is charging with less than the defined amount of power, this price becomes/is active.
     *       If the charging power is or becomes higher, this price is not or no longer valid and becomes inactive.
     *       This is NOT about the maximum power over the entire transaction.
     * 
     * 
     */
    @JsonProperty("maxPower")
    @JsonPropertyDescription("Maximum power in W, for example 20000 W.\r\n      When the EV is charging with less than the defined amount of power, this price becomes/is active.\r\n      If the charging power is or becomes higher, this price is not or no longer valid and becomes inactive.\r\n      This is NOT about the maximum power over the entire transaction.\r\n")
    private Double maxPower;
    /**
     * Minimum duration in seconds the transaction (charging &amp; idle) MUST last (inclusive).
     *       When the duration of a transaction is longer than the defined value, this price is or becomes active.
     *       Before that moment, this price is not yet active.
     * 
     * 
     */
    @JsonProperty("minTime")
    @JsonPropertyDescription("Minimum duration in seconds the transaction (charging &amp; idle) MUST last (inclusive).\r\n      When the duration of a transaction is longer than the defined value, this price is or becomes active.\r\n      Before that moment, this price is not yet active.\r\n")
    private Integer minTime;
    /**
     * Maximum duration in seconds the transaction (charging &amp; idle) MUST last (exclusive).
     *       When the duration of a transaction is shorter than the defined value, this price is or becomes active.
     *       After that moment, this price is no longer active.
     * 
     * 
     */
    @JsonProperty("maxTime")
    @JsonPropertyDescription("Maximum duration in seconds the transaction (charging &amp; idle) MUST last (exclusive).\r\n      When the duration of a transaction is shorter than the defined value, this price is or becomes active.\r\n      After that moment, this price is no longer active.\r\n")
    private Integer maxTime;
    /**
     * Minimum duration in seconds the charging MUST last (inclusive).
     *       When the duration of a charging is longer than the defined value, this price is or becomes active.
     *       Before that moment, this price is not yet active.
     * 
     * 
     */
    @JsonProperty("minChargingTime")
    @JsonPropertyDescription("Minimum duration in seconds the charging MUST last (inclusive).\r\n      When the duration of a charging is longer than the defined value, this price is or becomes active.\r\n      Before that moment, this price is not yet active.\r\n")
    private Integer minChargingTime;
    /**
     * Maximum duration in seconds the charging MUST last (exclusive).
     *       When the duration of a charging is shorter than the defined value, this price is or becomes active.
     *       After that moment, this price is no longer active.
     * 
     * 
     */
    @JsonProperty("maxChargingTime")
    @JsonPropertyDescription("Maximum duration in seconds the charging MUST last (exclusive).\r\n      When the duration of a charging is shorter than the defined value, this price is or becomes active.\r\n      After that moment, this price is no longer active.\r\n")
    private Integer maxChargingTime;
    /**
     * Minimum duration in seconds the idle period (i.e. not charging) MUST last (inclusive).
     *       When the duration of the idle time is longer than the defined value, this price is or becomes active.
     *       Before that moment, this price is not yet active.
     * 
     * 
     */
    @JsonProperty("minIdleTime")
    @JsonPropertyDescription("Minimum duration in seconds the idle period (i.e. not charging) MUST last (inclusive).\r\n      When the duration of the idle time is longer than the defined value, this price is or becomes active.\r\n      Before that moment, this price is not yet active.\r\n")
    private Integer minIdleTime;
    /**
     * Maximum duration in seconds the idle period (i.e. not charging) MUST last (exclusive).
     *       When the duration of idle time is shorter than the defined value, this price is or becomes active.
     *       After that moment, this price is no longer active.
     * 
     * 
     */
    @JsonProperty("maxIdleTime")
    @JsonPropertyDescription("Maximum duration in seconds the idle period (i.e. not charging) MUST last (exclusive).\r\n      When the duration of idle time is shorter than the defined value, this price is or becomes active.\r\n      After that moment, this price is no longer active.\r\n")
    private Integer maxIdleTime;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
