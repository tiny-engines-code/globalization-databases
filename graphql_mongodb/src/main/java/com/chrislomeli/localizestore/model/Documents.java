package com.chrislomeli.localizestore.model;

import com.chrislomeli.localizestore.model.base.ProjectDefaults;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;


//@EqualsAndHashCode(callSuper = true)
//@Entity
//@Table(name = "localize_document", schema = "globalization")
@Data
@Builder
@Document(collection = "documents")
public class Documents  {

    @Id
    private String id;
    private String name;
    private String description;
    private Instant creationDate;
    private Instant modificationDate;
    private String creationUser;
    private String modificationUser;

    private ProjectDefaults projectDefaults;

    private List<Strings> strings = new ArrayList<>();
}
