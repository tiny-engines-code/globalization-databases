package com.chrislomeli.localizestore.model;

import com.chrislomeli.localizestore.model.base.BaseModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table (name = "localize_team", schema = "globalization")
public class Team  extends BaseModel {

    private String name;
    private String description;
    private String slackChannel;
    private String invoiceRegion;
    private String invoiceCategory;

    @OneToMany(mappedBy = "team", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonIgnore
    private final List<Project> projects = new ArrayList<>();

}
