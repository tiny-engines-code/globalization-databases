package com.chrislomeli.localizestore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.chrislomeli.localizestore.model.base.BaseModel;
import com.chrislomeli.g11n.commons.v2.localization.core.model.enums.Status;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "localize_string", schema = "globalization")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Strings  extends BaseModel {

    private String id;
    private String key;
    private String description;
    private String fileLinkId;
    private String instructions;

    @Column(columnDefinition = "text[]")
    @Type(type = "com.chrislomeli.localizestore.model.base.CustomStringArrayType")
    private String[] tags;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    private Document document;

    @OneToMany(mappedBy = "string", fetch = FetchType.LAZY)
    @JsonIgnore
    private final List<Translation> translations = new ArrayList<>();

}
