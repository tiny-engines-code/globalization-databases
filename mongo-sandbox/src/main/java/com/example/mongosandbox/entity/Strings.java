package com.example.mongosandbox.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
//@org.springframework.data.mongodb.core.mapping.Document(collection = "strings")

public class Strings {

    @Id
    String id;

    @Indexed(unique = true)
    String stringName;
    String description;

}
