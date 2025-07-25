
package io.u2ware.ocpp.v2_0_1.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * Indicates whether the Local Controller succeeded in unpublishing the firmware.
 * 
 * 
 */
@Generated("jsonschema2pojo")
public enum UnpublishFirmwareStatusEnum {

    DOWNLOAD_ONGOING("DownloadOngoing"),
    NO_FIRMWARE("NoFirmware"),
    UNPUBLISHED("Unpublished");
    private final String value;
    private final static Map<String, UnpublishFirmwareStatusEnum> CONSTANTS = new HashMap<String, UnpublishFirmwareStatusEnum>();

    static {
        for (UnpublishFirmwareStatusEnum c: values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    UnpublishFirmwareStatusEnum(String value) {
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
    public static UnpublishFirmwareStatusEnum fromValue(String value) {
        UnpublishFirmwareStatusEnum constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException(value);
        } else {
            return constant;
        }
    }

}
