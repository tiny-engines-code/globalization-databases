package com.chrislomeli.g11n.commons.v2.localization.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.chrislomeli.g11n.commons.v2.localization.core.model.enums.Status;

import lombok.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;

import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Translations {
    private String id;
    private String stringsId;
    private String fileLinkId;
    private String languageId;
    private String marketplaceId;
    private String variantId;
    private String description;
    private String value;
    private String sha256;
    private Status status;

    @Getter(AccessLevel.NONE) // This is here to prevent Lombok from returning source, instead of isSource
    private boolean isSource;

    @EqualsAndHashCode.Exclude // Since Path is a derivative of the Strings resource
    private List<PathStep> path;

    @EqualsAndHashCode.Exclude // Tough to compare dates with varying levels of truncation
    private Instant creationDate;

    private String creationUser;

    @EqualsAndHashCode.Exclude // Tough to compare dates with varying levels of truncation
    private Instant modificationDate;

    private String modificationUser;

    private ModificationReason modificationReason;
    
    private Long version; // Boxed version to permit null check
    private Long ttl;

    @Getter(AccessLevel.NONE) // This is here to prevent Lombok from returning deleted, instead of isDeleted
    private boolean isDeleted;

    public boolean getIsSource() {
        return isSource;
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }

    @JsonIgnore
    public boolean isBase() {
        return StringUtils.isBlank(marketplaceId) && StringUtils.isBlank(variantId);
    }

    @JsonIgnore
    public String getName() {
        return StringUtils.join(List.of(languageId,
                StringUtils.isBlank(marketplaceId) ? "*" : marketplaceId,
                StringUtils.isBlank(variantId) ? "*" : variantId),
                ':');
    }

    @JsonIgnore
    public Optional<String> getTeamName() {
        return getTeamValue(PathStep::getName);
    }

    @JsonIgnore
    public Optional<String> getTeamId() {
        return getTeamValue(PathStep::getId);
    }

    @JsonIgnore
    private Optional<String> getTeamValue(Function<PathStep, String> func) {
        if (Objects.isNull(path)) {
            return Optional.empty();
        }

        return path.stream().findFirst().map(func);
    }

    @JsonIgnore
    public Optional<String> getParentProjectName() {
        // size-1: translations
        // size-2: strings
        // size-3: parentProject
        if (Objects.isNull(path) || path.size() < 4) {
            // Path length should always be 4 or more, so if it is here
            //  then something is wrong.
            return Optional.empty();
        }

        return Optional.ofNullable(path.get(path.size() - 3).getName());
    }

    @JsonIgnore
    public Optional<String> getParentProjectId() {
        // size-3: parentProject
        if (Objects.isNull(path) || path.size() < 4) {
            // Path length should always be 4 or more, so if it is here
            //  then something is wrong.
            return Optional.empty();
        }

        return Optional.ofNullable(path.get(path.size() - 3).getId());
    }

    @JsonIgnore
    public String getPathSerialized() {
        return path.stream().map(step -> {
            if (step.getId().equals(getTeamId().orElse(""))) {
                return "team:" + step.getId();
            } else if (step.getId().equals(stringsId)) {
                return "strings:" + step.getId();
            } else if (step.getId().equals(id)) {
                return "translations:" + step.getId();
            }
            return "project:" + step.getId();
        }).collect(Collectors.joining("|"));
    }

    @JsonIgnore
    public Optional<String> getStringsKey() {
        // size-1: translations
        // size-2: strings
        if (Objects.isNull(path) || path.size() < 4) {
            // Path length should always be 4 or more, so if it is here
            //  then something is wrong.
            return Optional.empty();
        }

        return Optional.ofNullable(path.get(path.size() - 2).getName());
    }

    @JsonIgnore
    public boolean equalsIgnoreUser(Object o) {
        return EqualsBuilder.reflectionEquals(this, o, "path", "creationDate", "creationUser", "modificationDate", "modificationUser", "modificationReason");
    }
}
