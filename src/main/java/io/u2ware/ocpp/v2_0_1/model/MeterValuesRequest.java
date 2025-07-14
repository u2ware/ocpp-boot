
package io.u2ware.ocpp.v2_0_1.model;

import java.util.List;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;


/**
 * Request_ Body
 * urn:x-enexis:ecdm:uid:2:234744
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.ALWAYS)
@SuperBuilder
@ToString
@Getter
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({
    "customData",
    "evseId",
    "meterValue"
})
@Generated("jsonschema2pojo")
public class MeterValuesRequest {

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;
    /**
     * Request_ Body. EVSEID. Numeric_ Identifier
     * urn:x-enexis:ecdm:uid:1:571101
     * This contains a number (&gt;0) designating an EVSE of the Charging Station. ‘0’ (zero) is used to designate the main power meter.
     * 
     * (Required)
     * 
     */
    @JsonProperty("evseId")
    @JsonPropertyDescription("Request_ Body. EVSEID. Numeric_ Identifier\r\nurn:x-enexis:ecdm:uid:1:571101\r\nThis contains a number (&gt;0) designating an EVSE of the Charging Station. \u20180\u2019 (zero) is used to designate the main power meter.\r\n")
    @NotNull
    private Integer evseId;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("meterValue")
    @Singular("meterValue")
    @Size(min = 1)
    @Valid
    @NotNull
    private List<MeterValue> meterValue;

}
