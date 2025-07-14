
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
 * ReserveNowResponse
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
    "status"
})
@Generated("jsonschema2pojo")
public class ReserveNowResponse {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("status")
    @NotNull
    private ReserveNowResponse.Status status;

    @Generated("jsonschema2pojo")
    public enum Status {

        ACCEPTED("Accepted"),
        FAULTED("Faulted"),
        OCCUPIED("Occupied"),
        REJECTED("Rejected"),
        UNAVAILABLE("Unavailable");
        private final String value;
        private final static Map<String, ReserveNowResponse.Status> CONSTANTS = new HashMap<String, ReserveNowResponse.Status>();

        static {
            for (ReserveNowResponse.Status c: values()) {
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
        public static ReserveNowResponse.Status fromValue(String value) {
            ReserveNowResponse.Status constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
