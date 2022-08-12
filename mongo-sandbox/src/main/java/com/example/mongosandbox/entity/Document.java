package com.example.mongosandbox.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@org.springframework.data.mongodb.core.mapping.Document(collection = "document")
//@CompoundIndexes({
//        @CompoundIndex(name = "name", def = "{ 'document.name': 1 }", unique = true)
//})
@CompoundIndex(name = "document_name", def = "{ 'name': 1 }", unique = true)
public class Document {

    @Id
    String id;

    String name;

    @Field(name = "email_address")
    String email;

    MetaData department;

//    @DBRef(lazy = true)
    List<Strings> strings;
}
