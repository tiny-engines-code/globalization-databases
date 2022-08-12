package com.chrislomeli.localizestore.rest.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.chrislomeli.g11n.commons.v2.localization.core.model.PathStep;
import com.chrislomeli.g11n.commons.v2.localization.core.model.StringValues;
import com.chrislomeli.g11n.commons.v2.localization.core.model.enums.Status;

import lombok.Data;

import java.time.Instant;
import java.util.List;
import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StringsResponse {
    private String id;
    private String key;
    private String projectId;
    private String fileLinkId;
    private String description;
    private Status status;
    private Map<String, StringValues> values;
    private Integer maxGraphemeClusterCount;
    private List<PathStep> path;

    private Instant creationDate;
    private String creationUser;

    private Instant modificationDate;
    private String modificationUser;

    private long version;
    private Long ttl; // boxed ttl; may be null

//    public StringsResponse fromStrings(Strings strings) {
//        this.id = strings.getId();
//        this.key = strings.getKey();
//        this.projectId = strings.getProjectId();
//        this.fileLinkId = strings.getFileLinkId();
//        this.description = strings.getDescription();
//        this.status = strings.getStatus();
//        this.values = strings.getValues();
//        this.maxGraphemeClusterCount = strings.getMaxGraphemeClusterCount();
//        this.path = strings.getPath();
//
//        this.creationDate = strings.getCreationDate();
//        this.modificationDate = strings.getModificationDate();
//        this.creationUser = strings.getCreationUser();
//        this.modificationUser = strings.getModificationUser();
//        this.version = strings.getVersion();
//        this.ttl = strings.getTtl();
//
//        return this;
//    }
}
