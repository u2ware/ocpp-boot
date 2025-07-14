
package io.u2ware.ocpp.v2_1.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

@Generated("jsonschema2pojo")
public enum NotifyAllowedEnergyTransferStatusEnum {

    ACCEPTED("Accepted"),
    REJECTED("Rejected");
    private final String value;
    private final static Map<String, NotifyAllowedEnergyTransferStatusEnum> CONSTANTS = new HashMap<String, NotifyAllowedEnergyTransferStatusEnum>();

    static {
        for (NotifyAllowedEnergyTransferStatusEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    NotifyAllowedEnergyTransferStatusEnum(String value) {
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
    public static NotifyAllowedEnergyTransferStatusEnum fromValue(String value) {
        NotifyAllowedEnergyTransferStatusEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
