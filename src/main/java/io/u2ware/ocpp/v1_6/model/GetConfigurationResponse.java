
package io.u2ware.ocpp.v1_6.model;

import java.util.List;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;


/**
 * GetConfigurationResponse
 * <p>
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
    "configurationKey",
    "unknownKey"
})
@Generated("jsonschema2pojo")
public class GetConfigurationResponse {

    @JsonProperty("configurationKey")
    @Singular("configurationKey")
    @Valid
    private List<ConfigurationKey> configurationKey;
    @JsonProperty("unknownKey")
    @Singular("unknownKey")
    @Valid
    private List<String> unknownKey;

}
