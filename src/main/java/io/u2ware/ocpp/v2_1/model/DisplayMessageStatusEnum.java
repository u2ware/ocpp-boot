
package io.u2ware.ocpp.v2_1.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * This indicates whether the Charging Station is able to display the message.
 * 
 * 
 */
@Generated("jsonschema2pojo")
public enum DisplayMessageStatusEnum {

    ACCEPTED("Accepted"),
    NOT_SUPPORTED_MESSAGE_FORMAT("NotSupportedMessageFormat"),
    REJECTED("Rejected"),
    NOT_SUPPORTED_PRIORITY("NotSupportedPriority"),
    NOT_SUPPORTED_STATE("NotSupportedState"),
    UNKNOWN_TRANSACTION("UnknownTransaction"),
    LANGUAGE_NOT_SUPPORTED("LanguageNotSupported");
    private final String value;
    private final static Map<String, DisplayMessageStatusEnum> CONSTANTS = new HashMap<String, DisplayMessageStatusEnum>();

    static {
        for (DisplayMessageStatusEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    DisplayMessageStatusEnum(String value) {
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
    public static DisplayMessageStatusEnum fromValue(String value) {
        DisplayMessageStatusEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
