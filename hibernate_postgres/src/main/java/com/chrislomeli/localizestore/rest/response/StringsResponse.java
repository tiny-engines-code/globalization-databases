package com.chrislomeli.localizestore.rest.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.chrislomeli.localizestore.model.Strings;
import com.chrislomeli.localizestore.model.base.BaseModel;
import com.chrislomeli.g11n.commons.v2.core.conversion.ZonedDateTimeDeserializer;
import com.chrislomeli.g11n.commons.v2.core.conversion.ZonedDateTimeSerializer;
import lombok.*;

import java.time.ZonedDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class StringsResponse extends BaseModel {

    private String id;
    private String key;
    private String description;
    private String fileLinkId;
    private String instructions;
    private String status;
    private String[] tags;

    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    private ZonedDateTime creationDate;

    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    private ZonedDateTime modificationDate;

    public StringsResponse(Strings obj) {
        this.id = obj.getId();
        this.key = obj.getKey();
        this.description = obj.getDescription();
        this.creationDate = obj.getCreationDate();
        this.modificationDate = obj.getModificationDate();
        this.fileLinkId = obj.getFileLinkId();
        this.instructions = obj.getInstructions();
        this.status = obj.getStatus().name();
        this.tags = obj.getTags();
    }

}
