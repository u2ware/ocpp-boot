
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


/**
 * DataTransferRequest
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
    "vendorId",
    "messageId",
    "data"
})
@Generated("jsonschema2pojo")
public class DataTransferRequest {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("vendorId")
    @Size(max = 255)
    @NotNull
    private String vendorId;
    @JsonProperty("messageId")
    @Size(max = 50)
    private String messageId;
    @JsonProperty("data")
    private String data;

}
