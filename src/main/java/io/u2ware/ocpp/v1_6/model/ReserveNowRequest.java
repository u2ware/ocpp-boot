
package io.u2ware.ocpp.v1_6.model;

import java.time.ZonedDateTime;
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
 * ReserveNowRequest
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
    "expiryDate",
    "idTag",
    "parentIdTag",
    "reservationId"
})
@Generated("jsonschema2pojo")
public class ReserveNowRequest {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("connectorId")
    @NotNull
    private Integer connectorId;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("expiryDate")
    @NotNull
    private ZonedDateTime expiryDate;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("idTag")
    @Size(max = 20)
    @NotNull
    private String idTag;
    @JsonProperty("parentIdTag")
    @Size(max = 20)
    private String parentIdTag;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("reservationId")
    @NotNull
    private Integer reservationId;

}
