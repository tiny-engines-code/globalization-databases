package com.chrislomeli.localizestore.model;

import com.chrislomeli.localizestore.model.base.BaseModel;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "localize_document", schema = "globalization")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Document extends BaseModel {

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

    @ManyToOne
    private Project project;

    @OneToMany(mappedBy = "document")
    private final List<Strings> strings = new ArrayList<>();
}
