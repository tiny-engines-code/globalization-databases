package com.chrislomeli.g11n.commons.v2.localization.core.model;

import com.chrislomeli.g11n.commons.v2.localization.core.model.enums.Status;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.chrislomeli.g11n.commons.v2.core.conversion.ZonedDateTimeDeserializer;
import com.chrislomeli.g11n.commons.v2.core.conversion.ZonedDateTimeSerializer;
import lombok.Builder;
import lombok.Data;

import java.time.ZonedDateTime;
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

    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    private ZonedDateTime creationDate;
    private String creationUser;

    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    private ZonedDateTime modificationDate;
    private String modificationUser;
    private long version;
    private Integer maxGraphemeClusterCount;
}
