package com.chrislomeli.localizestore.rest.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.chrislomeli.g11n.commons.v2.localization.core.model.enums.ResourceType;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResourceNotificationResponse {
    private String targetResourceId;
    private ResourceType targetResourceType;
}
