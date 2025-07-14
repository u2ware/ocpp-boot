
package io.u2ware.ocpp.v2_1.model;

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
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;


/**
 * Element providing more information about the status.
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
    "reasonCode",
    "additionalInfo",
    "customData"
})
@Generated("jsonschema2pojo")
public class StatusInfo {

    /**
     * A predefined code for the reason why the status is returned in this response. The string is case-insensitive.
     * 
     * (Required)
     * 
     */
    @JsonProperty("reasonCode")
    @JsonPropertyDescription("A predefined code for the reason why the status is returned in this response. The string is case-insensitive.\r\n")
    @Size(max = 20)
    @NotNull
    private String reasonCode;
    /**
     * Additional text to provide detailed information.
     * 
     * 
     */
    @JsonProperty("additionalInfo")
    @JsonPropertyDescription("Additional text to provide detailed information.\r\n")
    @Size(max = 1024)
    private String additionalInfo;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
