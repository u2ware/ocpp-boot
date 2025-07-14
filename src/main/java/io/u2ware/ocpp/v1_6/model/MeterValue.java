
package io.u2ware.ocpp.v1_6.model;

import java.time.ZonedDateTime;
import java.util.List;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
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
    "timestamp",
    "sampledValue"
})
@Generated("jsonschema2pojo")
public class MeterValue {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("timestamp")
    @NotNull
    private ZonedDateTime timestamp;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("sampledValue")
    @Singular("sampledValue")
    @Valid
    @NotNull
    private List<SampledValue> sampledValue;

}
