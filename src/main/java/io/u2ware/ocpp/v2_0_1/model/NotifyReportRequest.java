
package io.u2ware.ocpp.v2_0_1.model;

import java.time.ZonedDateTime;
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
    "customData",
    "requestId",
    "generatedAt",
    "reportData",
    "tbc",
    "seqNo"
})
@Generated("jsonschema2pojo")
public class NotifyReportRequest {

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;
    /**
     * The id of the GetReportRequest  or GetBaseReportRequest that requested this report
     * 
     * (Required)
     * 
     */
    @JsonProperty("requestId")
    @JsonPropertyDescription("The id of the GetReportRequest  or GetBaseReportRequest that requested this report\r\n")
    @NotNull
    private Integer requestId;
    /**
     * Timestamp of the moment this message was generated at the Charging Station.
     * 
     * (Required)
     * 
     */
    @JsonProperty("generatedAt")
    @JsonPropertyDescription("Timestamp of the moment this message was generated at the Charging Station.\r\n")
    @NotNull
    private ZonedDateTime generatedAt;
    @JsonProperty("reportData")
    @Singular("reportData")
    @Size(min = 1)
    @Valid
    private List<ReportData> reportData;
    /**
     * “to be continued” indicator. Indicates whether another part of the report follows in an upcoming notifyReportRequest message. Default value when omitted is false.
     * 
     * 
     * 
     */
    @JsonProperty("tbc")
    @JsonPropertyDescription("\u201cto be continued\u201d indicator. Indicates whether another part of the report follows in an upcoming notifyReportRequest message. Default value when omitted is false.\r\n\r\n")
    @lombok.Builder.Default
    private Boolean tbc = false;
    /**
     * Sequence number of this message. First message starts at 0.
     * 
     * (Required)
     * 
     */
    @JsonProperty("seqNo")
    @JsonPropertyDescription("Sequence number of this message. First message starts at 0.\r\n")
    @NotNull
    private Integer seqNo;

}
