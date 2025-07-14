
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
 * Part of ISO 15118-20 price schedule.
 * 
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
    "overstayFee",
    "overstayRuleDescription",
    "startTime",
    "overstayFeePeriod",
    "customData"
})
@Generated("jsonschema2pojo")
public class OverstayRule {

    /**
     * Part of ISO 15118-20 price schedule.
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("overstayFee")
    @JsonPropertyDescription("Part of ISO 15118-20 price schedule.\r\n\r\n")
    @Valid
    @NotNull
    private RationalNumber overstayFee;
    /**
     * Human readable string to identify the overstay rule.
     * 
     * 
     */
    @JsonProperty("overstayRuleDescription")
    @JsonPropertyDescription("Human readable string to identify the overstay rule.\r\n")
    @Size(max = 32)
    private String overstayRuleDescription;
    /**
     * Time in seconds after trigger of the parent Overstay Rules for this particular fee to apply.
     * 
     * (Required)
     * 
     */
    @JsonProperty("startTime")
    @JsonPropertyDescription("Time in seconds after trigger of the parent Overstay Rules for this particular fee to apply.\r\n")
    @NotNull
    private Integer startTime;
    /**
     * Time till overstay will be reapplied
     * 
     * (Required)
     * 
     */
    @JsonProperty("overstayFeePeriod")
    @JsonPropertyDescription("Time till overstay will be reapplied\r\n")
    @NotNull
    private Integer overstayFeePeriod;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
