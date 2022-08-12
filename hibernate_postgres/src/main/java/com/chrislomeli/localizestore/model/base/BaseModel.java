package com.chrislomeli.localizestore.model.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.ZonedDateTime;

@MappedSuperclass
@Data
public class BaseModel {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @CreationTimestamp
    private ZonedDateTime creationDate;

    @UpdateTimestamp
    private ZonedDateTime modificationDate;

    private final int version = 3;

    @Column(columnDefinition = "text[]")
    @Type(type = "com.chrislomeli.localizestore.model.base.CustomStringArrayType")
    private String[] tags;

}
