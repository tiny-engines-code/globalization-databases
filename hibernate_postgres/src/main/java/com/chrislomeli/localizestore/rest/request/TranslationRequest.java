package com.chrislomeli.localizestore.rest.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.chrislomeli.localizestore.model.Translation;
import com.chrislomeli.g11n.commons.v2.localization.core.model.enums.Status;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
//@SchemaValidate(file = "/validation/teamRequest.json")
//@TargetLanguagesContainsSource
//@ValidTeamTargetLanguages
public class TranslationRequest {
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

    public Translation toRepository() {
        return Translation.builder()
                .description(this.description)
                .status(this.status)
                .fileLinkId(this.fileLinkId)
                .instructions(this.instructions)
                .tags(this.tags)
                .language(this.language)
                .region(this.region)
                .device(this.device)
                .timeOfDay(this.timeOfDay)
                .marketplaceId(this.marketplaceId)
                .value(this.value)
                .sha256(this.sha256)
                .status(this.status)
                .build();
    }
}



