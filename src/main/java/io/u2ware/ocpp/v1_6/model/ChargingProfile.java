
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
public class ChargingProfile {

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
    private ChargingProfile.ChargingProfilePurpose chargingProfilePurpose;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("chargingProfileKind")
    @NotNull
    private ChargingProfile.ChargingProfileKind chargingProfileKind;
    @JsonProperty("recurrencyKind")
    private ChargingProfile.RecurrencyKind recurrencyKind;
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
        private final static Map<String, ChargingProfile.ChargingProfileKind> CONSTANTS = new HashMap<String, ChargingProfile.ChargingProfileKind>();

        static {
            for (ChargingProfile.ChargingProfileKind c: values()) {
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
        public static ChargingProfile.ChargingProfileKind fromValue(String value) {
            ChargingProfile.ChargingProfileKind constant = CONSTANTS.get(value);
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
        private final static Map<String, ChargingProfile.ChargingProfilePurpose> CONSTANTS = new HashMap<String, ChargingProfile.ChargingProfilePurpose>();

        static {
            for (ChargingProfile.ChargingProfilePurpose c: values()) {
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
        public static ChargingProfile.ChargingProfilePurpose fromValue(String value) {
            ChargingProfile.ChargingProfilePurpose constant = CONSTANTS.get(value);
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
        private final static Map<String, ChargingProfile.RecurrencyKind> CONSTANTS = new HashMap<String, ChargingProfile.RecurrencyKind>();

        static {
            for (ChargingProfile.RecurrencyKind c: values()) {
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
        public static ChargingProfile.RecurrencyKind fromValue(String value) {
            ChargingProfile.RecurrencyKind constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
