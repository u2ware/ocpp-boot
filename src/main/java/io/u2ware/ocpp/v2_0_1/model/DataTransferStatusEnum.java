
package io.u2ware.ocpp.v2_0_1.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * This indicates the success or failure of the data transfer.
 * 
 * 
 */
@Generated("jsonschema2pojo")
public enum DataTransferStatusEnum {

    ACCEPTED("Accepted"),
    REJECTED("Rejected"),
    UNKNOWN_MESSAGE_ID("UnknownMessageId"),
    UNKNOWN_VENDOR_ID("UnknownVendorId");
    private final String value;
    private final static Map<String, DataTransferStatusEnum> CONSTANTS = new HashMap<String, DataTransferStatusEnum>();

    static {
        for (DataTransferStatusEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    DataTransferStatusEnum(String value) {
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
    public static DataTransferStatusEnum fromValue(String value) {
        DataTransferStatusEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
