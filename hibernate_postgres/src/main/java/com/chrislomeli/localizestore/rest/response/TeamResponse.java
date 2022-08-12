package com.chrislomeli.localizestore.rest.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.chrislomeli.localizestore.model.Team;
import com.chrislomeli.localizestore.model.base.ProjectDefaults;
import com.chrislomeli.g11n.commons.v2.core.conversion.ZonedDateTimeDeserializer;
import com.chrislomeli.g11n.commons.v2.core.conversion.ZonedDateTimeSerializer;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.Objects;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeamResponse  {
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

    public TeamResponse(Team team) {
        this.id = team.getId();
        this.name = team.getName();
        this.description = team.getDescription();
        this.creationDate = team.getCreationDate();
        this.modificationDate = team.getModificationDate();
//        this.creationUser = team.getCreationUser();
//        this.modificationUser = team.getModificationUser();
        this.projectDefaults = toProjectDefaultsResponse(team);
        this.version = team.getVersion();
    }

    private ProjectDefaults toProjectDefaultsResponse(Team t ) {
        if (Objects.nonNull(t)) {
            return ProjectDefaults.builder()
//                    .sourceLanguage(t.getSourceLanguage())
//                    .targetLanguages(t.getTargetLanguages())
//                    .consumerChannel(t.getConsumerChannel())
//                    .requireReview(t.getRequireReview())
//                    .contextURL(t.getContextURL())
//                    .contactEmail(t.getContactEmail())
//                    .slackChannel(t.getSlackChannel())
//                    .contentType(t.getContentType())
                    .invoiceRegion(t.getInvoiceRegion())
                    .invoiceCategory(t.getInvoiceCategory())
                    .build();
        }
        return null;
    }
}
