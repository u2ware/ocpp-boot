
package io.u2ware.ocpp.v1_6.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;


/**
 * TriggerMessageRequest
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
    "requestedMessage",
    "connectorId"
})
@Generated("jsonschema2pojo")
public class TriggerMessageRequest {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestedMessage")
    @NotNull
    private TriggerMessageRequest.RequestedMessage requestedMessage;
    @JsonProperty("connectorId")
    private Integer connectorId;

    @Generated("jsonschema2pojo")
    public enum RequestedMessage {

        BOOT_NOTIFICATION("BootNotification"),
        DIAGNOSTICS_STATUS_NOTIFICATION("DiagnosticsStatusNotification"),
        FIRMWARE_STATUS_NOTIFICATION("FirmwareStatusNotification"),
        HEARTBEAT("Heartbeat"),
        METER_VALUES("MeterValues"),
        STATUS_NOTIFICATION("StatusNotification");
        private final String value;
        private final static Map<String, TriggerMessageRequest.RequestedMessage> CONSTANTS = new HashMap<String, TriggerMessageRequest.RequestedMessage>();

        static {
            for (TriggerMessageRequest.RequestedMessage c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        RequestedMessage(String value) {
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
        public static TriggerMessageRequest.RequestedMessage fromValue(String value) {
            TriggerMessageRequest.RequestedMessage constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
