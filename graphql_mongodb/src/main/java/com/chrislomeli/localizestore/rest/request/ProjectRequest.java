package com.chrislomeli.localizestore.rest.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.chrislomeli.localizestore.model.Project;
import com.chrislomeli.localizestore.model.base.ProjectDefaults;
import com.chrislomeli.localizestore.rest.validation.TargetLanguagesContainsSource;
import com.chrislomeli.localizestore.rest.validation.ValidTeamTargetLanguages;
import com.chrislomeli.g11n.commons.v2.localization.core.model.enums.RequireReview;
import com.chrislomeli.phylon.rest.validation.annotation.SchemaValidate;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@SchemaValidate(file = "/validation/teamRequest.json")
@TargetLanguagesContainsSource
@ValidTeamTargetLanguages
public class ProjectRequest {
    private String name;
    private String description;
    private ProjectDefaults projectDefaults;

    public Project toRepository() {
        if (this.projectDefaults.getRequireReview() == null)
            this.projectDefaults.setRequireReview(RequireReview.DEFAULT);
        return Project.builder()
                .name(this.name)
                .description(this.description)
                .projectDefaults(this.projectDefaults)

                .build();
    }
}



