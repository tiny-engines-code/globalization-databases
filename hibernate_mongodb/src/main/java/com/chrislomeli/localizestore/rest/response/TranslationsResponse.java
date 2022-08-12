package com.chrislomeli.localizestore.rest.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.chrislomeli.g11n.commons.v2.localization.core.model.ModificationReason;
import com.chrislomeli.g11n.commons.v2.localization.core.model.PathStep;
import com.chrislomeli.g11n.commons.v2.localization.core.model.Translations;
import com.chrislomeli.g11n.commons.v2.localization.core.model.enums.Status;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

import java.time.Instant;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TranslationsResponse {
    private String id;
    private String stringsId;
    private String fileLinkId;
    private String languageId;
    private String marketplaceId;
    private String description;
    private String value;
    private String sha256;
    private Status status;

    @Getter(AccessLevel.NONE) // This is here to prevent Lombok from returning source, instead of isSource
    private boolean isSource;

    private List<PathStep> path;

    private Instant creationDate;
    private String creationUser;

    private Instant modificationDate;
    private String modificationUser;

    private ModificationReason modificationReason;

    private long version;
    private Long ttl; // boxed ttl; may be null

    public boolean getIsSource() {
        return isSource;
    }

    public TranslationsResponse fromTranslations(Translations translations) {
        this.id = translations.getId();
        this.stringsId = translations.getStringsId();
        this.fileLinkId = translations.getFileLinkId();
        this.languageId = translations.getLanguageId();
        this.marketplaceId = translations.getMarketplaceId();
        this.description = translations.getDescription();
        this.value = translations.getValue();
        this.sha256 = translations.getSha256();
        this.status = translations.getStatus();
        this.isSource = translations.getIsSource();
        this.path = translations.getPath();

        this.creationDate = translations.getCreationDate();
        this.modificationDate = translations.getModificationDate();
        this.creationUser = translations.getCreationUser();
        this.modificationUser = translations.getModificationUser();
        this.version = translations.getVersion();
        this.ttl = translations.getTtl();
        this.modificationReason = translations.getModificationReason();

        return this;
    }
}
