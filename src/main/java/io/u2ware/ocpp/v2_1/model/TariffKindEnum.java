
package io.u2ware.ocpp.v2_1.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * Kind of tariff (driver/default)
 * 
 * 
 */
@Generated("jsonschema2pojo")
public enum TariffKindEnum {

    DEFAULT_TARIFF("DefaultTariff"),
    DRIVER_TARIFF("DriverTariff");
    private final String value;
    private final static Map<String, TariffKindEnum> CONSTANTS = new HashMap<String, TariffKindEnum>();

    static {
        for (TariffKindEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    TariffKindEnum(String value) {
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
    public static TariffKindEnum fromValue(String value) {
        TariffKindEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
