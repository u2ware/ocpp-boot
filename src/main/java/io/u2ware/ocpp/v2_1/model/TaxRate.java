
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


/**
 * Tax percentage
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
    "type",
    "tax",
    "stack",
    "customData"
})
@Generated("jsonschema2pojo")
public class TaxRate {

    /**
     * Type of this tax, e.g.  "Federal ",  "State", for information on receipt.
     * 
     * (Required)
     * 
     */
    @JsonProperty("type")
    @JsonPropertyDescription("Type of this tax, e.g.  \"Federal \",  \"State\", for information on receipt.\r\n")
    @Size(max = 20)
    @NotNull
    private String type;
    /**
     * Tax percentage
     * 
     * (Required)
     * 
     */
    @JsonProperty("tax")
    @JsonPropertyDescription("Tax percentage\r\n")
    @NotNull
    private Double tax;
    /**
     * Stack level for this type of tax. Default value, when absent, is 0. +
     * _stack_ = 0: tax on net price; +
     * _stack_ = 1: tax added on top of _stack_ 0; +
     * _stack_ = 2: tax added on top of _stack_ 1, etc. 
     * 
     * 
     */
    @JsonProperty("stack")
    @JsonPropertyDescription("Stack level for this type of tax. Default value, when absent, is 0. +\r\n_stack_ = 0: tax on net price; +\r\n_stack_ = 1: tax added on top of _stack_ 0; +\r\n_stack_ = 2: tax added on top of _stack_ 1, etc. \r\n")
    @DecimalMin("0")
    private Integer stack;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
