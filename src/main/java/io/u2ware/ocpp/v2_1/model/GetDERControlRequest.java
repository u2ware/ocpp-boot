
package io.u2ware.ocpp.v2_1.model;

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
    "requestId",
    "isDefault",
    "controlType",
    "controlId",
    "customData"
})
@Generated("jsonschema2pojo")
public class GetDERControlRequest {

    /**
     * RequestId to be used in ReportDERControlRequest.
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestId")
    @JsonPropertyDescription("RequestId to be used in ReportDERControlRequest.\r\n")
    @NotNull
    private Integer requestId;
    /**
     * True: get a default DER control. False: get a scheduled control.
     * 
     * 
     * 
     */
    @JsonProperty("isDefault")
    @JsonPropertyDescription("True: get a default DER control. False: get a scheduled control.\r\n\r\n")
    private Boolean isDefault;
    /**
     * Type of control settings to retrieve. Not used when _controlId_ is provided.
     * 
     * 
     * 
     */
    @JsonProperty("controlType")
    @JsonPropertyDescription("Type of control settings to retrieve. Not used when _controlId_ is provided.\r\n\r\n")
    private DERControlEnum controlType;
    /**
     * Id of setting to get. When omitted all settings for _controlType_ are retrieved.
     * 
     * 
     * 
     */
    @JsonProperty("controlId")
    @JsonPropertyDescription("Id of setting to get. When omitted all settings for _controlType_ are retrieved.\r\n\r\n")
    @Size(max = 36)
    private String controlId;
    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;

}
