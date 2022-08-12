package com.chrislomeli.localizestore.rest.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.chrislomeli.localizestore.model.Team;
import com.chrislomeli.localizestore.model.base.ProjectDefaults;
import com.chrislomeli.phylon.rest.validation.annotation.SchemaValidate;
import lombok.Data;

import java.time.Instant;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@SchemaValidate(file = "/validation/teamRequest.json")
//@TargetLanguagesContainsSource
//@ValidTeamTargetLanguages
public class TeamRequest {
    private String name;
    private String description;
    private String parentId;
    private ProjectDefaults projectDefaults;

    public Team toTeam() {
        return Team.builder()
                .name(this.name)
                .description(this.description)
                .creationDate(Instant.now())
                .modificationDate(Instant.now())
                .projectDefaults(this.projectDefaults)
                .version(3)
                .build();
    }

}
