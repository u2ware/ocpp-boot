
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
 * *(2.1)* A generic address format.
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
    "name",
    "address1",
    "address2",
    "city",
    "postalCode",
    "country",
    "customData"
})
@Generated("jsonschema2pojo")
public class Address {

    /**
     * Name of person/company
     * 
     * (Required)
     * 
     */
    @JsonProperty("name")
    @JsonPropertyDescription("Name of person/company\r\n")
    @Size(max = 50)
    @NotNull
    private String name;
    /**
     * Address line 1
     * 
     * (Required)
     * 
     */
    @JsonProperty("address1")
    @JsonPropertyDescription("Address line 1\r\n")
    @Size(max = 100)
    @NotNull
    private String address1;
    /**
     * Address line 2
     * 
     * 
     */
    @JsonProperty("address2")
    @JsonPropertyDescription("Address line 2\r\n")
    @Size(max = 100)
    private String address2;
    /**
     * City
     * 
     * (Required)
     * 
     */
    @JsonProperty("city")
    @JsonPropertyDescription("City\r\n")
    @Size(max = 100)
    @NotNull
    private String city;
    /**
     * Postal code
     * 
     * 
     */
    @JsonProperty("postalCode")
    @JsonPropertyDescription("Postal code\r\n")
    @Size(max = 20)
    private String postalCode;
    /**
     * Country name
     * 
     * (Required)
     * 
     */
    @JsonProperty("country")
    @JsonPropertyDescription("Country name\r\n")
    @Size(max = 50)
    @NotNull
    private String country;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
