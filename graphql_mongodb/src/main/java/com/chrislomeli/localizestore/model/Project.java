package com.chrislomeli.localizestore.model;

import com.chrislomeli.localizestore.model.base.ProjectDefaults;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@ToString
@Builder
@Document(collection = "project")
public class Project  {

    @Id
    private String id;
    private String name;
    private String description;
    private Instant creationDate;
    private Instant modificationDate;
    private String creationUser;
    private String modificationUser;

    private ProjectDefaults projectDefaults;

    @DBRef(lazy = true)
    private List<Documents> documents;

    public Project() {
        documents = new ArrayList<>();
    }
}
