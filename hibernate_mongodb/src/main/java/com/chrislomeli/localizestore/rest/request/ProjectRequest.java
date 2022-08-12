package com.chrislomeli.localizestore.rest.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.chrislomeli.localizestore.model.Project;
import com.chrislomeli.localizestore.model.base.ProjectDefaults;
import com.chrislomeli.phylon.rest.validation.annotation.SchemaValidate;
import lombok.Data;

import java.time.Instant;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@SchemaValidate(file = "/validation/projectRequest.json")
//@TargetLanguagesContainsSource
//@ValidProjectTargetLanguages
public class ProjectRequest {
    private String name;
    private String description;
    private String sourceLanguage;

    private String parentId;
    private ProjectDefaults projectDefaults;



//    @Data
//    public static class MetadataRequest {
//        private String consumerChannel;
//        private RequireReview requireReview;
//        private String contextURL;
//        private String contactEmail;
//        private String slackChannel;
//        private String contentType;
//        private String invoiceRegion;
//        private String invoiceCategory;
//    }

    public Project toProject() {
        Project project = new Project();

        project.setId(UUID.randomUUID().toString());
        project.setName(this.name);
        project.setDescription(this.description);
        project.setCreationDate(Instant.now());
        project.setModificationDate(Instant.now());
        project.setVersion(1L);
        return project;
    }

//    private static Project.TargetLanguagesModel fromTargetLanguagesRequest(TargetLanguagesRequest request) {
//        if (Objects.nonNull(request)) {
//            Project.TargetLanguagesModel model = new Project.TargetLanguagesModel();
//            model.setLanguages(request.getLanguages());
//            model.setInheritanceType(request.getInheritanceType());
//            return model;
//        }
//        return null;
//    }
//
//    private static Project.MetadataModel fromMetadataRequest(MetadataRequest request) {
//        if (Objects.nonNull(request)) {
//            Project.MetadataModel model = new Project.MetadataModel();
//            model.setConsumerChannel(request.getConsumerChannel());
//            model.setRequireReview(request.getRequireReview());
//            model.setContextURL(request.getContextURL());
//            model.setContactEmail(request.getContactEmail());
//            model.setSlackChannel(request.getSlackChannel());
//            model.setContentType(request.getContentType());
//            model.setInvoiceRegion(request.getInvoiceRegion());
//            model.setInvoiceCategory(request.getInvoiceCategory());
//            return model;
//        }
//
//        return null;
//    }
}
