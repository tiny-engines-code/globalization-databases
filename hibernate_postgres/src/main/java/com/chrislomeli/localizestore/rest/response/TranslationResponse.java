package com.chrislomeli.localizestore.rest.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.chrislomeli.localizestore.model.Translation;
import com.chrislomeli.g11n.commons.v2.localization.core.model.enums.Status;
import com.chrislomeli.g11n.commons.v2.core.conversion.ZonedDateTimeDeserializer;
import com.chrislomeli.g11n.commons.v2.core.conversion.ZonedDateTimeSerializer;
import lombok.Data;

import java.time.ZonedDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
//@SchemaValidate(file = "/validation/teamRequest.json")
//@TargetLanguagesContainsSource
//@ValidTeamTargetLanguages
public class TranslationResponse {
    private String id;
    private String fileLinkId;
    private String language;
    private String region;
    private String device;
    private String timeOfDay;
    private String marketplaceId;
    private String description;
    private String instructions;
    private String value;
    private String sha256;
    private Status status;
    private String[] tags;

    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    private ZonedDateTime creationDate;

    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    private ZonedDateTime modificationDate;

    public TranslationResponse(Translation obj) {
        this.id = obj.getId();
        this.value = obj.getValue();
        this.description = obj.getDescription();
        this.creationDate = obj.getCreationDate();
        this.modificationDate = obj.getModificationDate();
        this.fileLinkId = obj.getFileLinkId();
        this.instructions = obj.getInstructions();
        this.status = obj.getStatus();
        this.tags = obj.getTags();
        this.language = obj.getLanguage();
        this.creationDate = obj.getCreationDate();
        this.modificationDate = obj.getModificationDate();
        this.region = obj.getRegion();
        this.device = obj.getDevice();
        this.marketplaceId = obj.getMarketplaceId();
        this.timeOfDay = obj.getTimeOfDay();
    }

}



