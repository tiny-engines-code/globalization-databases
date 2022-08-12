package com.chrislomeli.localizestore.model;

import com.chrislomeli.localizestore.model.base.ProjectDefaults;
import com.chrislomeli.localizestore.model.base.TargetLanguages;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
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
    private long version;
    private TargetLanguages targetLanguages;

    private ProjectDefaults projectDefaults;

    @DBRef(lazy = true)
    private List<Documents> documents;

    public Project() {
        documents = new ArrayList<>();
    }
    public void addDocument(Documents p) {
        this.documents.add(p);
    }

}
