package com.chrislomeli.localizestore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@AllArgsConstructor
@Builder
@Document(collection = "team")
public class Team  {

    @Id
    private String id;
    private Instant creationDate;
    private Instant modificationDate;
    private String name;
    private String description;
    private String slackChannel;
    private String invoiceRegion;
    private String invoiceCategory;

    @DBRef(lazy = true)
    @JsonIgnore
    private List<Project> projects;

    public Team() {
        projects = new ArrayList<>();
    }
}
