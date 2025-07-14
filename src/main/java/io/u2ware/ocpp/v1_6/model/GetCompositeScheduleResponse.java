
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


/**
 * GetCompositeScheduleResponse
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
    "connectorId",
    "scheduleStart",
    "chargingSchedule"
})
@Generated("jsonschema2pojo")
public class GetCompositeScheduleResponse {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("status")
    @NotNull
    private GetCompositeScheduleResponse.Status status;
    @JsonProperty("connectorId")
    private Integer connectorId;
    @JsonProperty("scheduleStart")
    private ZonedDateTime scheduleStart;
    @JsonProperty("chargingSchedule")
    @Valid
    private ChargingSchedule chargingSchedule;

    @Generated("jsonschema2pojo")
    public enum Status {

        ACCEPTED("Accepted"),
        REJECTED("Rejected");
        private final String value;
        private final static Map<String, GetCompositeScheduleResponse.Status> CONSTANTS = new HashMap<String, GetCompositeScheduleResponse.Status>();

        static {
            for (GetCompositeScheduleResponse.Status c: values()) {
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
        public static GetCompositeScheduleResponse.Status fromValue(String value) {
            GetCompositeScheduleResponse.Status constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
