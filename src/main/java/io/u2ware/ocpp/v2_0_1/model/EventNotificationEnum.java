
package io.u2ware.ocpp.v2_0_1.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * Specifies the event notification type of the message.
 * 
 * 
 * 
 */
@Generated("jsonschema2pojo")
public enum EventNotificationEnum {

    HARD_WIRED_NOTIFICATION("HardWiredNotification"),
    HARD_WIRED_MONITOR("HardWiredMonitor"),
    PRECONFIGURED_MONITOR("PreconfiguredMonitor"),
    CUSTOM_MONITOR("CustomMonitor");
    private final String value;
    private final static Map<String, EventNotificationEnum> CONSTANTS = new HashMap<String, EventNotificationEnum>();

    static {
        for (EventNotificationEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    EventNotificationEnum(String value) {
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
    public static EventNotificationEnum fromValue(String value) {
        EventNotificationEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
