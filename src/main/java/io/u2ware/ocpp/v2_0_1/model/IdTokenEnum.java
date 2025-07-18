
package io.u2ware.ocpp.v2_0_1.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * Enumeration of possible idToken types.
 * 
 * 
 */
@Generated("jsonschema2pojo")
public enum IdTokenEnum {

    CENTRAL("Central"),
    E_MAID("eMAID"),
    ISO_14443("ISO14443"),
    ISO_15693("ISO15693"),
    KEY_CODE("KeyCode"),
    LOCAL("Local"),
    MAC_ADDRESS("MacAddress"),
    NO_AUTHORIZATION("NoAuthorization");
    private final String value;
    private final static Map<String, IdTokenEnum> CONSTANTS = new HashMap<String, IdTokenEnum>();

    static {
        for (IdTokenEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    IdTokenEnum(String value) {
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
    public static IdTokenEnum fromValue(String value) {
        IdTokenEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
