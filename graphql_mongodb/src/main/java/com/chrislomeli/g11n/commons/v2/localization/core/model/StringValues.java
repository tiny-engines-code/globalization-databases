package com.chrislomeli.g11n.commons.v2.localization.core.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StringValues {
    private String id;
    private String value;
    private String description;
    private String sha256;

    public Translations toTranslation() {
        return  Translations.builder()
                .languageId(this.id)
                .value(this.value)
                .description(this.description)
                .sha256(this.sha256).build();
    }

    public StringValues fromTranslation(final Translations translation) {
        // TODO G11N-1069: only for backwards support until StringValues usage is completely removed
        this.id = translation.getLanguageId();
        this.value = translation.getValue();
        this.description = translation.getDescription();
        this.sha256 = translation.getSha256();

        return this;
    }
}
