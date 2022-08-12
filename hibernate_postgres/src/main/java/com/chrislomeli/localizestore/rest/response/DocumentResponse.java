package com.chrislomeli.localizestore.rest.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.chrislomeli.localizestore.model.Document;
import com.chrislomeli.localizestore.model.base.ProjectDefaults;
import com.chrislomeli.g11n.commons.v2.localization.core.model.enums.RequireReview;
import com.chrislomeli.g11n.commons.v2.core.conversion.ZonedDateTimeDeserializer;
import com.chrislomeli.g11n.commons.v2.core.conversion.ZonedDateTimeSerializer;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.Objects;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DocumentResponse {
    private String id;
    private String name;
    private String description;
    private ProjectDefaults projectDefaults;

    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    private ZonedDateTime creationDate;
    private String creationUser;

    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    private ZonedDateTime modificationDate;
    private String modificationUser;
    private long version;

    public DocumentResponse(Document obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.description = obj.getDescription();
        this.creationDate = obj.getCreationDate();
        this.modificationDate = obj.getModificationDate();
        this.creationUser = obj.getCreationUser();
        this.modificationUser = obj.getModificationUser();
        this.projectDefaults = toProjectDefaultsResponse(obj);
        this.version = obj.getVersion();
    }

    private ProjectDefaults toProjectDefaultsResponse(Document t) {
        if (Objects.nonNull(t)) {
            if (t.getRequireReview() == null)
                t.setRequireReview(RequireReview.DEFAULT.toString());
            return ProjectDefaults.builder()
                    .sourceLanguage(t.getSourceLanguage())
                    .targetLanguages(t.getTargetLanguages())
                    .consumerChannel(t.getConsumerChannel())
                    .requireReview(RequireReview.valueOf(t.getRequireReview()))
                    .contextURL(t.getContextURL())
                    .contactEmail(t.getContactEmail())
                    .slackChannel(t.getSlackChannel())
                    .contentType(t.getContentType())
                    .invoiceRegion(t.getInvoiceRegion())
                    .invoiceCategory(t.getInvoiceCategory())
                    .build();
        }
        return null;
    }
}
