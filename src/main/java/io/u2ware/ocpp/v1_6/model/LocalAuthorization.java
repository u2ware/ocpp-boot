
package io.u2ware.ocpp.v1_6.model;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
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

@JsonInclude(JsonInclude.Include.ALWAYS)
@SuperBuilder
@ToString
@Getter
@Accessors(fluent = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({
    "idTag",
    "idTagInfo"
})
@Generated("jsonschema2pojo")
public class LocalAuthorization {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("idTag")
    @Size(max = 20)
    @NotNull
    private String idTag;
    @JsonProperty("idTagInfo")
    @Valid
    private IdTagInfo idTagInfo;

}
