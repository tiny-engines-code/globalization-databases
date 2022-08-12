package com.chrislomeli.localizestore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.chrislomeli.localizestore.model.base.ProjectDefaults;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@Document(collection = "team")
public class Team  {

    @Id
    private String id;
    private Instant creationDate;
    private Instant modificationDate;
    private String name;
    private String description;
    private String creationUser;
    private String modifificationUser;
    private ProjectDefaults projectDefaults;
    int version;

    @DBRef(lazy = true)
    @JsonIgnore
    private List<Project> projects;

    public Team() {
        projects = new ArrayList<>();
    }

    public void addProject(Project p) {
        this.projects.add(p);
    }
}
