
package io.u2ware.ocpp.v1_6.model;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.validation.Valid;
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
 * StopTransactionRequest
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
    "idTag",
    "meterStop",
    "timestamp",
    "transactionId",
    "reason",
    "transactionData"
})
@Generated("jsonschema2pojo")
public class StopTransactionRequest {

    @JsonProperty("idTag")
    @Size(max = 20)
    private String idTag;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("meterStop")
    @NotNull
    private Integer meterStop;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("timestamp")
    @NotNull
    private ZonedDateTime timestamp;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("transactionId")
    @NotNull
    private Integer transactionId;
    @JsonProperty("reason")
    private StopTransactionRequest.Reason reason;
    @JsonProperty("transactionData")
    @Singular("transactionData")
    @Valid
    private List<TransactionDatum> transactionData;

    @Generated("jsonschema2pojo")
    public enum Reason {

        EMERGENCY_STOP("EmergencyStop"),
        EV_DISCONNECTED("EVDisconnected"),
        HARD_RESET("HardReset"),
        LOCAL("Local"),
        OTHER("Other"),
        POWER_LOSS("PowerLoss"),
        REBOOT("Reboot"),
        REMOTE("Remote"),
        SOFT_RESET("SoftReset"),
        UNLOCK_COMMAND("UnlockCommand"),
        DE_AUTHORIZED("DeAuthorized");
        private final String value;
        private final static Map<String, StopTransactionRequest.Reason> CONSTANTS = new HashMap<String, StopTransactionRequest.Reason>();

        static {
            for (StopTransactionRequest.Reason c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        Reason(String value) {
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
        public static StopTransactionRequest.Reason fromValue(String value) {
            StopTransactionRequest.Reason constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
