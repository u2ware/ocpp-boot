
package io.u2ware.ocpp.v1_6.model;

import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;


/**
 * StartTransactionResponse
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
    "idTagInfo",
    "transactionId"
})
@Generated("jsonschema2pojo")
public class StartTransactionResponse {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("idTagInfo")
    @Valid
    @NotNull
    private IdTagInfo idTagInfo;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("transactionId")
    @NotNull
    private Integer transactionId;

}
