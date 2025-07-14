
package io.u2ware.ocpp.v1_6.model;

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


/**
 * MeterValuesRequest
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
    "connectorId",
    "transactionId",
    "meterValue"
})
@Generated("jsonschema2pojo")
public class MeterValuesRequest {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("connectorId")
    @NotNull
    private Integer connectorId;
    @JsonProperty("transactionId")
    private Integer transactionId;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("meterValue")
    @Singular("meterValue")
    @Valid
    @NotNull
    private List<MeterValue> meterValue;

}
