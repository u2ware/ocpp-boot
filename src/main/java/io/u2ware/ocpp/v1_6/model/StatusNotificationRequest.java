
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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;


/**
 * StatusNotificationRequest
 * <p>
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
    "connectorId",
    "errorCode",
    "info",
    "status",
    "timestamp",
    "vendorId",
    "vendorErrorCode"
})
@Generated("jsonschema2pojo")
public class StatusNotificationRequest {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("connectorId")
    @NotNull
    private Integer connectorId;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("errorCode")
    @NotNull
    private StatusNotificationRequest.ErrorCode errorCode;
    @JsonProperty("info")
    @Size(max = 50)
    private String info;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("status")
    @NotNull
    private StatusNotificationRequest.Status status;
    @JsonProperty("timestamp")
    private ZonedDateTime timestamp;
    @JsonProperty("vendorId")
    @Size(max = 255)
    private String vendorId;
    @JsonProperty("vendorErrorCode")
    @Size(max = 50)
    private String vendorErrorCode;

    @Generated("jsonschema2pojo")
    public enum ErrorCode {

        CONNECTOR_LOCK_FAILURE("ConnectorLockFailure"),
        EV_COMMUNICATION_ERROR("EVCommunicationError"),
        GROUND_FAILURE("GroundFailure"),
        HIGH_TEMPERATURE("HighTemperature"),
        INTERNAL_ERROR("InternalError"),
        LOCAL_LIST_CONFLICT("LocalListConflict"),
        NO_ERROR("NoError"),
        OTHER_ERROR("OtherError"),
        OVER_CURRENT_FAILURE("OverCurrentFailure"),
        POWER_METER_FAILURE("PowerMeterFailure"),
        POWER_SWITCH_FAILURE("PowerSwitchFailure"),
        READER_FAILURE("ReaderFailure"),
        RESET_FAILURE("ResetFailure"),
        UNDER_VOLTAGE("UnderVoltage"),
        OVER_VOLTAGE("OverVoltage"),
        WEAK_SIGNAL("WeakSignal");
        private final String value;
        private final static Map<String, StatusNotificationRequest.ErrorCode> CONSTANTS = new HashMap<String, StatusNotificationRequest.ErrorCode>();

        static {
            for (StatusNotificationRequest.ErrorCode c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        ErrorCode(String value) {
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
        public static StatusNotificationRequest.ErrorCode fromValue(String value) {
            StatusNotificationRequest.ErrorCode constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    @Generated("jsonschema2pojo")
    public enum Status {

        AVAILABLE("Available"),
        PREPARING("Preparing"),
        CHARGING("Charging"),
        SUSPENDED_EVSE("SuspendedEVSE"),
        SUSPENDED_EV("SuspendedEV"),
        FINISHING("Finishing"),
        RESERVED("Reserved"),
        UNAVAILABLE("Unavailable"),
        FAULTED("Faulted");
        private final String value;
        private final static Map<String, StatusNotificationRequest.Status> CONSTANTS = new HashMap<String, StatusNotificationRequest.Status>();

        static {
            for (StatusNotificationRequest.Status c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        Status(String value) {
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
        public static StatusNotificationRequest.Status fromValue(String value) {
            StatusNotificationRequest.Status constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
