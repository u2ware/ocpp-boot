
package io.u2ware.ocpp.v2_0_1.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * Data type of this variable.
 * 
 * 
 */
@Generated("jsonschema2pojo")
public enum DataEnum {

    STRING("string"),
    DECIMAL("decimal"),
    INTEGER("integer"),
    DATE_TIME("dateTime"),
    BOOLEAN("boolean"),
    OPTION_LIST("OptionList"),
    SEQUENCE_LIST("SequenceList"),
    MEMBER_LIST("MemberList");
    private final String value;
    private final static Map<String, DataEnum> CONSTANTS = new HashMap<String, DataEnum>();

    static {
        for (DataEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    DataEnum(String value) {
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
    public static DataEnum fromValue(String value) {
        DataEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
