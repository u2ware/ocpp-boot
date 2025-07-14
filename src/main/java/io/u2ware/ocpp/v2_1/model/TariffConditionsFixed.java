
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
 * These conditions describe if a FixedPrice applies at start of the transaction.
 * 
 * When more than one restriction is set, they are to be treated as a logical AND. All need to be valid before this price is active.
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
    "paymentBrand",
    "paymentRecognition",
    "customData"
})
@Generated("jsonschema2pojo")
public class TariffConditionsFixed {

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
     * For which payment brand this (adhoc) tariff applies. Can be used to add a surcharge for certain payment brands.
     *     Based on value of _additionalIdToken_ from _idToken.additionalInfo.type_ = "PaymentBrand".
     * 
     * 
     */
    @JsonProperty("paymentBrand")
    @JsonPropertyDescription("For which payment brand this (adhoc) tariff applies. Can be used to add a surcharge for certain payment brands.\r\n    Based on value of _additionalIdToken_ from _idToken.additionalInfo.type_ = \"PaymentBrand\".\r\n")
    @Size(max = 20)
    private String paymentBrand;
    /**
     * Type of adhoc payment, e.g. CC, Debit.
     *     Based on value of _additionalIdToken_ from _idToken.additionalInfo.type_ = "PaymentRecognition".
     * 
     * 
     */
    @JsonProperty("paymentRecognition")
    @JsonPropertyDescription("Type of adhoc payment, e.g. CC, Debit.\r\n    Based on value of _additionalIdToken_ from _idToken.additionalInfo.type_ = \"PaymentRecognition\".\r\n")
    @Size(max = 20)
    private String paymentRecognition;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
