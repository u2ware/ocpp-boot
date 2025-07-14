
package io.u2ware.ocpp.v2_1.model;

import java.time.ZonedDateTime;
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


/**
 * Charging schedule structure defines a list of charging periods, as used in: NotifyEVChargingScheduleRequest and ChargingProfileType. When used in a NotifyEVChargingScheduleRequest only _duration_ and _chargingSchedulePeriod_ are relevant and _chargingRateUnit_ must be 'W'. +
 * An ISO 15118-20 session may provide either an _absolutePriceSchedule_ or a _priceLevelSchedule_. An ISO 15118-2 session can only provide a_salesTariff_ element. The field _digestValue_ is used when price schedule or sales tariff are signed.
 * 
 * image::images/ChargingSchedule-Simple.png[]
 * 
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
    "id",
    "limitAtSoC",
    "startSchedule",
    "duration",
    "chargingRateUnit",
    "minChargingRate",
    "powerTolerance",
    "signatureId",
    "digestValue",
    "useLocalTime",
    "chargingSchedulePeriod",
    "randomizedDelay",
    "salesTariff",
    "absolutePriceSchedule",
    "priceLevelSchedule",
    "customData"
})
@Generated("jsonschema2pojo")
public class ChargingSchedule {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("id")
    @NotNull
    private Integer id;
    @JsonProperty("limitAtSoC")
    @Valid
    private LimitAtSoC limitAtSoC;
    /**
     * Starting point of an absolute schedule or recurring schedule.
     * 
     * 
     */
    @JsonProperty("startSchedule")
    @JsonPropertyDescription("Starting point of an absolute schedule or recurring schedule.\r\n")
    private ZonedDateTime startSchedule;
    /**
     * Duration of the charging schedule in seconds. If the duration is left empty, the last period will continue indefinitely or until end of the transaction in case startSchedule is absent.
     * 
     * 
     */
    @JsonProperty("duration")
    @JsonPropertyDescription("Duration of the charging schedule in seconds. If the duration is left empty, the last period will continue indefinitely or until end of the transaction in case startSchedule is absent.\r\n")
    private Integer duration;
    /**
     * The unit of measure in which limits and setpoints are expressed.
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingRateUnit")
    @JsonPropertyDescription("The unit of measure in which limits and setpoints are expressed.\r\n")
    @NotNull
    private ChargingRateUnitEnum chargingRateUnit;
    /**
     * Minimum charging rate supported by the EV. The unit of measure is defined by the chargingRateUnit. This parameter is intended to be used by a local smart charging algorithm to optimize the power allocation for in the case a charging process is inefficient at lower charging rates. 
     * 
     * 
     */
    @JsonProperty("minChargingRate")
    @JsonPropertyDescription("Minimum charging rate supported by the EV. The unit of measure is defined by the chargingRateUnit. This parameter is intended to be used by a local smart charging algorithm to optimize the power allocation for in the case a charging process is inefficient at lower charging rates. \r\n")
    private Double minChargingRate;
    /**
     * *(2.1)* Power tolerance when following EVPowerProfile.
     * 
     * 
     * 
     */
    @JsonProperty("powerTolerance")
    @JsonPropertyDescription("*(2.1)* Power tolerance when following EVPowerProfile.\r\n\r\n")
    private Double powerTolerance;
    /**
     * *(2.1)* Id of this element for referencing in a signature.
     * 
     * 
     */
    @JsonProperty("signatureId")
    @JsonPropertyDescription("*(2.1)* Id of this element for referencing in a signature.\r\n")
    @DecimalMin("0")
    private Integer signatureId;
    /**
     * *(2.1)* Base64 encoded hash (SHA256 for ISO 15118-2, SHA512 for ISO 15118-20) of the EXI price schedule element. Used in signature.
     * 
     * 
     */
    @JsonProperty("digestValue")
    @JsonPropertyDescription("*(2.1)* Base64 encoded hash (SHA256 for ISO 15118-2, SHA512 for ISO 15118-20) of the EXI price schedule element. Used in signature.\r\n")
    @Size(max = 88)
    private String digestValue;
    /**
     * *(2.1)* Defaults to false. When true, disregard time zone offset in dateTime fields of  _ChargingScheduleType_ and use unqualified local time at Charging Station instead.
     *  This allows the same `Absolute` or `Recurring` charging profile to be used in both summer and winter time.
     * 
     * 
     * 
     */
    @JsonProperty("useLocalTime")
    @JsonPropertyDescription("*(2.1)* Defaults to false. When true, disregard time zone offset in dateTime fields of  _ChargingScheduleType_ and use unqualified local time at Charging Station instead.\r\n This allows the same `Absolute` or `Recurring` charging profile to be used in both summer and winter time.\r\n\r\n")
    private Boolean useLocalTime;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingSchedulePeriod")
    @Singular("chargingSchedulePeriod")
    @Size(min = 1, max = 1024)
    @Valid
    @NotNull
    private List<ChargingSchedulePeriod> chargingSchedulePeriod;
    /**
     * *(2.1)* Defaults to 0. When _randomizedDelay_ not equals zero, then the start of each &lt;&lt;cmn_chargingscheduleperiodtype,ChargingSchedulePeriodType&gt;&gt; is delayed by a randomly chosen number of seconds between 0 and _randomizedDelay_.  Only allowed for TxProfile and TxDefaultProfile.
     * 
     * 
     * 
     */
    @JsonProperty("randomizedDelay")
    @JsonPropertyDescription("*(2.1)* Defaults to 0. When _randomizedDelay_ not equals zero, then the start of each &lt;&lt;cmn_chargingscheduleperiodtype,ChargingSchedulePeriodType&gt;&gt; is delayed by a randomly chosen number of seconds between 0 and _randomizedDelay_.  Only allowed for TxProfile and TxDefaultProfile.\r\n\r\n")
    @DecimalMin("0")
    private Integer randomizedDelay;
    /**
     * A SalesTariff provided by a Mobility Operator (EMSP) .
     * NOTE: This dataType is based on dataTypes from &lt;&lt;ref-ISOIEC15118-2,ISO 15118-2&gt;&gt;.
     * 
     * 
     */
    @JsonProperty("salesTariff")
    @JsonPropertyDescription("A SalesTariff provided by a Mobility Operator (EMSP) .\r\nNOTE: This dataType is based on dataTypes from &lt;&lt;ref-ISOIEC15118-2,ISO 15118-2&gt;&gt;.\r\n")
    @Valid
    private SalesTariff salesTariff;
    /**
     * The AbsolutePriceScheduleType is modeled after the same type that is defined in ISO 15118-20, such that if it is supplied by an EMSP as a signed EXI message, the conversion from EXI to JSON (in OCPP) and back to EXI (for ISO 15118-20) does not change the digest and therefore does not invalidate the signature.
     * 
     * image::images/AbsolutePriceSchedule-Simple.png[]
     * 
     * 
     * 
     */
    @JsonProperty("absolutePriceSchedule")
    @JsonPropertyDescription("The AbsolutePriceScheduleType is modeled after the same type that is defined in ISO 15118-20, such that if it is supplied by an EMSP as a signed EXI message, the conversion from EXI to JSON (in OCPP) and back to EXI (for ISO 15118-20) does not change the digest and therefore does not invalidate the signature.\r\n\r\nimage::images/AbsolutePriceSchedule-Simple.png[]\r\n\r\n")
    @Valid
    private AbsolutePriceSchedule absolutePriceSchedule;
    /**
     * The PriceLevelScheduleType is modeled after the same type that is defined in ISO 15118-20, such that if it is supplied by an EMSP as a signed EXI message, the conversion from EXI to JSON (in OCPP) and back to EXI (for ISO 15118-20) does not change the digest and therefore does not invalidate the signature.
     * 
     * 
     */
    @JsonProperty("priceLevelSchedule")
    @JsonPropertyDescription("The PriceLevelScheduleType is modeled after the same type that is defined in ISO 15118-20, such that if it is supplied by an EMSP as a signed EXI message, the conversion from EXI to JSON (in OCPP) and back to EXI (for ISO 15118-20) does not change the digest and therefore does not invalidate the signature.\r\n")
    @Valid
    private PriceLevelSchedule priceLevelSchedule;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
