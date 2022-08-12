package com.chrislomeli.localizestore.model;

import com.chrislomeli.localizestore.model.base.BaseModel;
import com.chrislomeli.g11n.commons.v2.localization.core.model.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "localize_translation", schema = "globalization")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Translation  extends BaseModel {

    private String fileLinkId;
    private String language;
    private String region;
    private String device;
    private String timeOfDay;
    private String marketplaceId;
    private String description;
    private String instructions;
    private String value;
    private String sha256;

    @Column(columnDefinition = "text[]")
    @Type(type = "com.chrislomeli.localizestore.model.base.CustomStringArrayType")
    private String[] tags;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    private Strings string;

}
