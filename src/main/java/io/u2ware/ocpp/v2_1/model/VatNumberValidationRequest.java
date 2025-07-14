
package io.u2ware.ocpp.v2_1.model;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

@JsonInclude(JsonInclude.Include.ALWAYS)
@SuperBuilder
@ToString
@Getter
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({
    "vatNumber",
    "evseId",
    "customData"
})
@Generated("jsonschema2pojo")
public class VatNumberValidationRequest {

    /**
     * VAT number to check.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("vatNumber")
    @JsonPropertyDescription("VAT number to check.\r\n\r\n")
    @Size(max = 20)
    @NotNull
    private String vatNumber;
    /**
     * EVSE id for which check is done
     * 
     * 
     * 
     */
    @JsonProperty("evseId")
    @JsonPropertyDescription("EVSE id for which check is done\r\n\r\n")
    @DecimalMin("0")
    private Integer evseId;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
