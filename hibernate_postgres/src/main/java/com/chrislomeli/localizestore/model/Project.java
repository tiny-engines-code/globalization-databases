package com.chrislomeli.localizestore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.chrislomeli.localizestore.model.base.BaseModel;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table(name = "localize_project", schema = "globalization")
public class Project extends BaseModel {

    private String name;
    private String description;
    private String sourceLanguage;
    private String consumerChannel;
    private String requireReview;
    private String contextURL;
    private String contactEmail;
    private String slackChannel;
    private String contentType;
    private String invoiceRegion;
    private String invoiceCategory;
    private String creationUser;
    private String modificationUser;

    @Column(columnDefinition = "text[]")
    @Type(type = "com.chrislomeli.localizestore.model.base.CustomStringArrayType")
    private String[] targetLanguages;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Team team;

    @OneToMany(mappedBy = "project", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private final List<Document> documents = new ArrayList<>();
}
