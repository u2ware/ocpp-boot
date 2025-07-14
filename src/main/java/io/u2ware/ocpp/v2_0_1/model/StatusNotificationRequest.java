
package io.u2ware.ocpp.v2_0_1.model;

import java.time.ZonedDateTime;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
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
    "customData",
    "timestamp",
    "connectorStatus",
    "evseId",
    "connectorId"
})
@Generated("jsonschema2pojo")
public class StatusNotificationRequest {

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;
    /**
     * The time for which the status is reported. If absent time of receipt of the message will be assumed.
     * 
     * (Required)
     * 
     */
    @JsonProperty("timestamp")
    @JsonPropertyDescription("The time for which the status is reported. If absent time of receipt of the message will be assumed.\r\n")
    @NotNull
    private ZonedDateTime timestamp;
    /**
     * This contains the current status of the Connector.
     * 
     * (Required)
     * 
     */
    @JsonProperty("connectorStatus")
    @JsonPropertyDescription("This contains the current status of the Connector.\r\n")
    @NotNull
    private ConnectorStatusEnum connectorStatus;
    /**
     * The id of the EVSE to which the connector belongs for which the the status is reported.
     * 
     * (Required)
     * 
     */
    @JsonProperty("evseId")
    @JsonPropertyDescription("The id of the EVSE to which the connector belongs for which the the status is reported.\r\n")
    @NotNull
    private Integer evseId;
    /**
     * The id of the connector within the EVSE for which the status is reported.
     * 
     * (Required)
     * 
     */
    @JsonProperty("connectorId")
    @JsonPropertyDescription("The id of the connector within the EVSE for which the status is reported.\r\n")
    @NotNull
    private Integer connectorId;

}
