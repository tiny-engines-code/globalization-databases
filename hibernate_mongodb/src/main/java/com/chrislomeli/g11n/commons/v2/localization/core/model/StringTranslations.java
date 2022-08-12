package com.chrislomeli.g11n.commons.v2.localization.core.model;

import com.chrislomeli.g11n.commons.v2.localization.core.model.enums.Status;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class StringTranslations {
    private String id;
    private String key;
    private String description;
    private String projectId;
    private String fileLinkId;
    private List<Translations> translations;
    private List<PathStep> path;
    private Status rollupStatus;

    private Instant creationDate;
    private String creationUser;

     private Instant modificationDate;
    private String modificationUser;
    private long version;
    private Integer maxGraphemeClusterCount;
}
