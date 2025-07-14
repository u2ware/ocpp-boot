
package io.u2ware.ocpp.v2_1.model;

import java.util.List;
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
    "batteryData",
    "eventType",
    "idToken",
    "requestId",
    "customData"
})
@Generated("jsonschema2pojo")
public class BatterySwapRequest {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("batteryData")
    @Singular("batteryData")
    @Size(min = 1)
    @Valid
    @NotNull
    private List<BatteryData> batteryData;
    /**
     * Battery in/out
     * 
     * (Required)
     * 
     */
    @JsonProperty("eventType")
    @JsonPropertyDescription("Battery in/out\r\n")
    @NotNull
    private BatterySwapEventEnum eventType;
    /**
     * Contains a case insensitive identifier to use for the authorization and the type of authorization to support multiple forms of identifiers.
     * 
     * (Required)
     * 
     */
    @JsonProperty("idToken")
    @JsonPropertyDescription("Contains a case insensitive identifier to use for the authorization and the type of authorization to support multiple forms of identifiers.\r\n")
    @Valid
    @NotNull
    private IdToken idToken;
    /**
     * RequestId to correlate BatteryIn/Out events and optional RequestBatterySwapRequest.
     * 
     * 
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestId")
    @JsonPropertyDescription("RequestId to correlate BatteryIn/Out events and optional RequestBatterySwapRequest.\r\n\r\n\r\n")
    @NotNull
    private Integer requestId;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
