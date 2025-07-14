
package io.u2ware.ocpp.v1_6.model;

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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;


/**
 * SendLocalListRequest
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
    "listVersion",
    "localAuthorizationList",
    "updateType"
})
@Generated("jsonschema2pojo")
public class SendLocalListRequest {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("listVersion")
    @NotNull
    private Integer listVersion;
    @JsonProperty("localAuthorizationList")
    @Singular("localAuthorizationList")
    @Valid
    private List<LocalAuthorization> localAuthorizationList;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("updateType")
    @NotNull
    private SendLocalListRequest.UpdateType updateType;

    @Generated("jsonschema2pojo")
    public enum UpdateType {

        DIFFERENTIAL("Differential"),
        FULL("Full");
        private final String value;
        private final static Map<String, SendLocalListRequest.UpdateType> CONSTANTS = new HashMap<String, SendLocalListRequest.UpdateType>();

        static {
            for (SendLocalListRequest.UpdateType c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        UpdateType(String value) {
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
        public static SendLocalListRequest.UpdateType fromValue(String value) {
            SendLocalListRequest.UpdateType constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
