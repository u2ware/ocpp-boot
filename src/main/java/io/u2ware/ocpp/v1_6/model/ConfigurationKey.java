
package io.u2ware.ocpp.v1_6.model;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
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
    "key",
    "readonly",
    "value"
})
@Generated("jsonschema2pojo")
public class ConfigurationKey {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("key")
    @Size(max = 50)
    @NotNull
    private String key;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("readonly")
    @NotNull
    private Boolean readonly;
    @JsonProperty("value")
    @Size(max = 500)
    private String value;

}
