
package io.u2ware.ocpp.v1_6.model;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.validation.Valid;
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
    "chargingProfileId",
    "transactionId",
    "stackLevel",
    "chargingProfilePurpose",
    "chargingProfileKind",
    "recurrencyKind",
    "validFrom",
    "validTo",
    "chargingSchedule"
})
@Generated("jsonschema2pojo")
public class CsChargingProfiles {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingProfileId")
    @NotNull
    private Integer chargingProfileId;
    @JsonProperty("transactionId")
    private Integer transactionId;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("stackLevel")
    @NotNull
    private Integer stackLevel;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingProfilePurpose")
    @NotNull
    private CsChargingProfiles.ChargingProfilePurpose chargingProfilePurpose;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingProfileKind")
    @NotNull
    private CsChargingProfiles.ChargingProfileKind chargingProfileKind;
    @JsonProperty("recurrencyKind")
    private CsChargingProfiles.RecurrencyKind recurrencyKind;
    @JsonProperty("validFrom")
    private ZonedDateTime validFrom;
    @JsonProperty("validTo")
    private ZonedDateTime validTo;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingSchedule")
    @Valid
    @NotNull
    private ChargingSchedule chargingSchedule;

    @Generated("jsonschema2pojo")
    public enum ChargingProfileKind {

        ABSOLUTE("Absolute"),
        RECURRING("Recurring"),
        RELATIVE("Relative");
        private final String value;
        private final static Map<String, CsChargingProfiles.ChargingProfileKind> CONSTANTS = new HashMap<String, CsChargingProfiles.ChargingProfileKind>();

        static {
            for (CsChargingProfiles.ChargingProfileKind c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        ChargingProfileKind(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static CsChargingProfiles.ChargingProfileKind fromValue(String value) {
            CsChargingProfiles.ChargingProfileKind constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    @Generated("jsonschema2pojo")
    public enum ChargingProfilePurpose {

        CHARGE_POINT_MAX_PROFILE("ChargePointMaxProfile"),
        TX_DEFAULT_PROFILE("TxDefaultProfile"),
        TX_PROFILE("TxProfile");
        private final String value;
        private final static Map<String, CsChargingProfiles.ChargingProfilePurpose> CONSTANTS = new HashMap<String, CsChargingProfiles.ChargingProfilePurpose>();

        static {
            for (CsChargingProfiles.ChargingProfilePurpose c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        ChargingProfilePurpose(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static CsChargingProfiles.ChargingProfilePurpose fromValue(String value) {
            CsChargingProfiles.ChargingProfilePurpose constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    @Generated("jsonschema2pojo")
    public enum RecurrencyKind {

        DAILY("Daily"),
        WEEKLY("Weekly");
        private final String value;
        private final static Map<String, CsChargingProfiles.RecurrencyKind> CONSTANTS = new HashMap<String, CsChargingProfiles.RecurrencyKind>();

        static {
            for (CsChargingProfiles.RecurrencyKind c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        RecurrencyKind(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static CsChargingProfiles.RecurrencyKind fromValue(String value) {
            CsChargingProfiles.RecurrencyKind constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
