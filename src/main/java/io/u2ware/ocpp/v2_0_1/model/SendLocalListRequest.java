
package io.u2ware.ocpp.v2_0_1.model;

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
    "localAuthorizationList",
    "versionNumber",
    "updateType"
})
@Generated("jsonschema2pojo")
public class SendLocalListRequest {

    /**
     * This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.
     * 
     */
    @JsonProperty("customData")
    @JsonPropertyDescription("This class does not get 'AdditionalProperties = false' in the schema generation, so it can be extended with arbitrary JSON properties to allow adding custom data.")
    @Valid
    private CustomData customData;
    @JsonProperty("localAuthorizationList")
    @Singular("localAuthorizationList")
    @Size(min = 1)
    @Valid
    private List<AuthorizationData> localAuthorizationList;
    /**
     * In case of a full update this is the version number of the full list. In case of a differential update it is the version number of the list after the update has been applied.
     * 
     * (Required)
     * 
     */
    @JsonProperty("versionNumber")
    @JsonPropertyDescription("In case of a full update this is the version number of the full list. In case of a differential update it is the version number of the list after the update has been applied.\r\n")
    @NotNull
    private Integer versionNumber;
    /**
     * This contains the type of update (full or differential) of this request.
     * 
     * (Required)
     * 
     */
    @JsonProperty("updateType")
    @JsonPropertyDescription("This contains the type of update (full or differential) of this request.\r\n")
    @NotNull
    private UpdateEnum updateType;

}
