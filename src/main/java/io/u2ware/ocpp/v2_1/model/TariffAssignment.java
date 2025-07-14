
package io.u2ware.ocpp.v2_1.model;

import java.time.ZonedDateTime;
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
 * Shows assignment of tariffs to EVSE or IdToken.
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
    "tariffId",
    "tariffKind",
    "validFrom",
    "evseIds",
    "idTokens",
    "customData"
})
@Generated("jsonschema2pojo")
public class TariffAssignment {

    /**
     * Tariff id.
     * 
     * (Required)
     * 
     */
    @JsonProperty("tariffId")
    @JsonPropertyDescription("Tariff id.\r\n")
    @Size(max = 60)
    @NotNull
    private String tariffId;
    /**
     * Kind of tariff (driver/default)
     * 
     * (Required)
     * 
     */
    @JsonProperty("tariffKind")
    @JsonPropertyDescription("Kind of tariff (driver/default)\r\n")
    @NotNull
    private TariffKindEnum tariffKind;
    /**
     * Date/time when this tariff become active.
     * 
     * 
     */
    @JsonProperty("validFrom")
    @JsonPropertyDescription("Date/time when this tariff become active.\r\n")
    private ZonedDateTime validFrom;
    @JsonProperty("evseIds")
    @Singular("evseIds")
    @Size(min = 1)
    @Valid
    private List<Integer> evseIds;
    /**
     * IdTokens related to tariff
     * 
     * 
     */
    @JsonProperty("idTokens")
    @JsonPropertyDescription("IdTokens related to tariff\r\n")
    @Singular("idTokens")
    @Size(min = 1)
    @Valid
    private List<String> idTokens;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
