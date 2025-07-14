
package io.u2ware.ocpp.v2_0_1.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * If provided the Charging Station shall return Display Messages with the given priority only.
 * 
 * 
 */
@Generated("jsonschema2pojo")
public enum MessagePriorityEnum {

    ALWAYS_FRONT("AlwaysFront"),
    IN_FRONT("InFront"),
    NORMAL_CYCLE("NormalCycle");
    private final String value;
    private final static Map<String, MessagePriorityEnum> CONSTANTS = new HashMap<String, MessagePriorityEnum>();

    static {
        for (MessagePriorityEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    MessagePriorityEnum(String value) {
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
    public static MessagePriorityEnum fromValue(String value) {
        MessagePriorityEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
