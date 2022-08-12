package com.chrislomeli.localizestore.rest.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.chrislomeli.localizestore.model.Team;
import com.chrislomeli.localizestore.model.base.ProjectDefaults;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
//@SchemaValidate(file = "/validation/teamRequest.json")
//@TargetLanguagesContainsSource
//@ValidTeamTargetLanguages
public class TeamRequest {
    private String name;
    private String description;
    private ProjectDefaults projectDefaults;

    public Team toRepository() {
        return Team.builder()
                .name(this.name)
                .description(this.description)
//                .sourceLanguage(this.projectDefaults.getSourceLanguage())
//                .targetLanguages(this.projectDefaults.getTargetLanguages())
//                .consumerChannel(this.projectDefaults.getConsumerChannel())
                .slackChannel(this.projectDefaults.getSlackChannel())
//                .slackChannel(this.projectDefaults.getContactEmail())
//                .contentType(this.projectDefaults.getContentType())
//                .contextURL(this.projectDefaults.getContextURL())
                .invoiceCategory(this.projectDefaults.getInvoiceCategory())
                .invoiceRegion(this.projectDefaults.getInvoiceRegion())
                .build();
    }
}



