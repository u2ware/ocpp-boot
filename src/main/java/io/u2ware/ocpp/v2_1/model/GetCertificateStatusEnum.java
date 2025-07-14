
package io.u2ware.ocpp.v2_1.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * This indicates whether the charging station was able to retrieve the OCSP certificate status.
 * 
 * 
 */
@Generated("jsonschema2pojo")
public enum GetCertificateStatusEnum {

    ACCEPTED("Accepted"),
    FAILED("Failed");
    private final String value;
    private final static Map<String, GetCertificateStatusEnum> CONSTANTS = new HashMap<String, GetCertificateStatusEnum>();

    static {
        for (GetCertificateStatusEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    GetCertificateStatusEnum(String value) {
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
    public static GetCertificateStatusEnum fromValue(String value) {
        GetCertificateStatusEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
