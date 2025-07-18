
package io.u2ware.ocpp.v2_1.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * Type of cost: normal or the minimum or maximum cost.
 * 
 * 
 */
@Generated("jsonschema2pojo")
public enum TariffCostEnum {

    NORMAL_COST("NormalCost"),
    MIN_COST("MinCost"),
    MAX_COST("MaxCost");
    private final String value;
    private final static Map<String, TariffCostEnum> CONSTANTS = new HashMap<String, TariffCostEnum>();

    static {
        for (TariffCostEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    TariffCostEnum(String value) {
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
    public static TariffCostEnum fromValue(String value) {
        TariffCostEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
