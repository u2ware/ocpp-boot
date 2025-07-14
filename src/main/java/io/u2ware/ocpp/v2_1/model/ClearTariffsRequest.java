
package io.u2ware.ocpp.v2_1.model;

import java.util.List;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Singular;
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
    "tariffIds",
    "evseId",
    "customData"
})
@Generated("jsonschema2pojo")
public class ClearTariffsRequest {

    /**
     * List of tariff Ids to clear. When absent clears all tariffs at _evseId_.
     * 
     * 
     * 
     */
    @JsonProperty("tariffIds")
    @JsonPropertyDescription("List of tariff Ids to clear. When absent clears all tariffs at _evseId_.\r\n\r\n")
    @Singular("tariffIds")
    @Size(min = 1)
    @Valid
    private List<String> tariffIds;
    /**
     * When present only clear tariffs matching _tariffIds_ at EVSE _evseId_.
     * 
     * 
     * 
     */
    @JsonProperty("evseId")
    @JsonPropertyDescription("When present only clear tariffs matching _tariffIds_ at EVSE _evseId_.\r\n\r\n")
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
