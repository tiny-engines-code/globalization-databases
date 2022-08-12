package com.chrislomeli.localizestore.rest.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.chrislomeli.localizestore.model.Team;
import com.chrislomeli.localizestore.model.base.ProjectDefaults;
import com.chrislomeli.g11n.commons.v2.localization.core.model.enums.RequireReview;

import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeamResponse {
    private String id;
    private String name;
    private String description;
    private ProjectDefaults projectDefaults;

     private Instant creationDate;
    private String creationUser;

    private Instant modificationDate;
    private String modificationUser;
    private long version;

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private static class ProjectDefaultsResponse {
        private String sourceLanguage;
        private List<String> targetLanguages;
        private String consumerChannel;
        private RequireReview requireReview;
        private String contextURL;
        private String contactEmail;
        private String slackChannel;
        private String contentType;
        private String invoiceRegion;
        private String invoiceCategory;
    }

    public TeamResponse(Team team) {
        this.id = team.getId();
        this.name = team.getName();
        this.description = team.getDescription();
        this.creationDate = team.getCreationDate();
        this.modificationDate = team.getModificationDate();
        this.creationUser = team.getCreationUser();
        this.modificationUser = team.getModifificationUser();
        this.projectDefaults = team.getProjectDefaults();
        this.version = team.getVersion();

    }

//    private ProjectDefaultsResponse(Team.ProjectDefaultsModel projectDefaultsModel) {
//        if (Objects.nonNull(projectDefaultsModel)) {
//            ProjectDefaultsResponse response = new ProjectDefaultsResponse();
//            response.sourceLanguage = projectDefaultsModel.getSourceLanguage();
//            response.targetLanguages = projectDefaultsModel.getTargetLanguages();
//            response.consumerChannel = projectDefaultsModel.getConsumerChannel();
//            response.requireReview = projectDefaultsModel.getRequireReview();
//            response.contextURL = projectDefaultsModel.getContextURL();
//            response.contactEmail = projectDefaultsModel.getContactEmail();
//            response.slackChannel = projectDefaultsModel.getSlackChannel();
//            response.contentType = projectDefaultsModel.getContentType();
//            response.invoiceRegion = projectDefaultsModel.getInvoiceRegion();
//            response.invoiceCategory = projectDefaultsModel.getInvoiceCategory();
//            return response;
//        }
//        return null;
//    }
}
