
package io.u2ware.ocpp.v1_6.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;


/**
 * ClearChargingProfileRequest
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
    "id",
    "connectorId",
    "chargingProfilePurpose",
    "stackLevel"
})
@Generated("jsonschema2pojo")
public class ClearChargingProfileRequest {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("connectorId")
    private Integer connectorId;
    @JsonProperty("chargingProfilePurpose")
    private ClearChargingProfileRequest.ChargingProfilePurpose chargingProfilePurpose;
    @JsonProperty("stackLevel")
    private Integer stackLevel;

    @Generated("jsonschema2pojo")
    public enum ChargingProfilePurpose {

        CHARGE_POINT_MAX_PROFILE("ChargePointMaxProfile"),
        TX_DEFAULT_PROFILE("TxDefaultProfile"),
        TX_PROFILE("TxProfile");
        private final String value;
        private final static Map<String, ClearChargingProfileRequest.ChargingProfilePurpose> CONSTANTS = new HashMap<String, ClearChargingProfileRequest.ChargingProfilePurpose>();

        static {
            for (ClearChargingProfileRequest.ChargingProfilePurpose c: values()) {
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
        public static ClearChargingProfileRequest.ChargingProfilePurpose fromValue(String value) {
            ClearChargingProfileRequest.ChargingProfilePurpose constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
