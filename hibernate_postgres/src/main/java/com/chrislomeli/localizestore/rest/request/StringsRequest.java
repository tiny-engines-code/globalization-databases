package com.chrislomeli.localizestore.rest.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.chrislomeli.localizestore.model.Strings;
import com.chrislomeli.g11n.commons.v2.localization.core.model.enums.Status;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
//@SchemaValidate(file = "/validation/teamRequest.json")
//@TargetLanguagesContainsSource
//@ValidTeamTargetLanguages
public class StringsRequest {
    private String key;
    private String description;
    private String fileLinkId;
    private String instructions;
    private String status;
    private String[] tags;

    public Strings toRepository() {
        return Strings.builder()
                .key(this.key)
                .description(this.description)
                .status(Status.valueOf(this.status))
                .fileLinkId(this.fileLinkId)
                .instructions(this.instructions)
                .tags(this.tags)
                .build();
    }
}



