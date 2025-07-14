
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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;


/**
 * BootNotificationResponse
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
    "status",
    "currentTime",
    "interval"
})
@Generated("jsonschema2pojo")
public class BootNotificationResponse {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("status")
    @NotNull
    private BootNotificationResponse.Status status;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("currentTime")
    @NotNull
    private ZonedDateTime currentTime;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("interval")
    @NotNull
    private Integer interval;

    @Generated("jsonschema2pojo")
    public enum Status {

        ACCEPTED("Accepted"),
        PENDING("Pending"),
        REJECTED("Rejected");
        private final String value;
        private final static Map<String, BootNotificationResponse.Status> CONSTANTS = new HashMap<String, BootNotificationResponse.Status>();

        static {
            for (BootNotificationResponse.Status c: values()) {
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
        public static BootNotificationResponse.Status fromValue(String value) {
            BootNotificationResponse.Status constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
