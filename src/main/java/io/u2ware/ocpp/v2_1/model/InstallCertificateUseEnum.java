
package io.u2ware.ocpp.v2_1.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * Indicates the certificate type that is sent.
 * 
 * 
 */
@Generated("jsonschema2pojo")
public enum InstallCertificateUseEnum {

    V_2_G_ROOT_CERTIFICATE("V2GRootCertificate"),
    MO_ROOT_CERTIFICATE("MORootCertificate"),
    MANUFACTURER_ROOT_CERTIFICATE("ManufacturerRootCertificate"),
    CSMS_ROOT_CERTIFICATE("CSMSRootCertificate"),
    OEM_ROOT_CERTIFICATE("OEMRootCertificate");
    private final String value;
    private final static Map<String, InstallCertificateUseEnum> CONSTANTS = new HashMap<String, InstallCertificateUseEnum>();

    static {
        for (InstallCertificateUseEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    InstallCertificateUseEnum(String value) {
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
    public static InstallCertificateUseEnum fromValue(String value) {
        InstallCertificateUseEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
