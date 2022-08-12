package com.chrislomeli.localizestore.rest.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.chrislomeli.localizestore.model.Project;
import com.chrislomeli.localizestore.model.base.TargetLanguages;
import lombok.Data;

import java.time.Instant;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DocumentsResponse {
    private String id;
    private String name;
    private String description;
    private String sourceLanguage;
    private String parentId;
    private TargetLanguages targetLanguages;
//    private List<PathStep> path;
//    private MetadataResponse metadata;

    private Instant creationDate;
    private String creationUser;

    private Instant modificationDate;
    private String modificationUser;
    private long version;

//    @Data
//    private static class TargetLanguagesResponse {
//        private List<String> languages;
//        private InheritanceType inheritanceType;
//    }
//
//    @Data
//    private static class MetadataResponse {
//        private String consumerChannel;
//        private RequireReview requireReview;
//        private String contextURL;
//        private String contactEmail;
//        private String slackChannel;
//        private String contentType;
//        private String invoiceRegion;
//        private String invoiceCategory;
//    }

    public DocumentsResponse(Project project) {
        this.id = project.getId();
        this.name = project.getName();
//        this.parentId = project.getParentId();
        this.description = project.getDescription();
        this.creationDate = project.getCreationDate();
        this.modificationDate = project.getModificationDate();
        this.creationUser = project.getCreationUser();
        this.modificationUser = project.getModificationUser();
        this.targetLanguages = project.getTargetLanguages();
        this.version = project.getVersion();

    }

//    private TargetLanguagesResponse toTargetLanguagesResponse(Project.TargetLanguagesModel targetLanguages) {
//        if (Objects.nonNull(targetLanguages)) {
//            TargetLanguagesResponse response = new TargetLanguagesResponse();
//            response.languages = targetLanguages.getLanguages();
//            response.inheritanceType = targetLanguages.getInheritanceType();
//            return response;
//        }
//        return null;
//    }
//
//    private MetadataResponse toMetadataResponse(Project.MetadataModel metadataModel) {
//        if (Objects.nonNull(metadataModel)) {
//            MetadataResponse response = new MetadataResponse();
//            response.consumerChannel = metadataModel.getConsumerChannel();
//            response.requireReview = metadataModel.getRequireReview();
//            response.contextURL = metadataModel.getContextURL();
//            response.contactEmail = metadataModel.getContactEmail();
//            response.slackChannel = metadataModel.getSlackChannel();
//            response.contentType = metadataModel.getContentType();
//            response.invoiceRegion = metadataModel.getInvoiceRegion();
//            response.invoiceCategory = metadataModel.getInvoiceCategory();
//            return response;
//        }
//        return null;
//    }
}
