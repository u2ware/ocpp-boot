
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
 * DiagnosticsStatusNotificationRequest
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
public class DiagnosticsStatusNotificationRequest {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("status")
    @NotNull
    private DiagnosticsStatusNotificationRequest.Status status;

    @Generated("jsonschema2pojo")
    public enum Status {

        IDLE("Idle"),
        UPLOADED("Uploaded"),
        UPLOAD_FAILED("UploadFailed"),
        UPLOADING("Uploading");
        private final String value;
        private final static Map<String, DiagnosticsStatusNotificationRequest.Status> CONSTANTS = new HashMap<String, DiagnosticsStatusNotificationRequest.Status>();

        static {
            for (DiagnosticsStatusNotificationRequest.Status c: values()) {
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
        public static DiagnosticsStatusNotificationRequest.Status fromValue(String value) {
            DiagnosticsStatusNotificationRequest.Status constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
