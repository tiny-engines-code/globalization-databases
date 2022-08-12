package com.example.rdmssandbox.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "string", schema="g11n")
public class Strings {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    String id;

    @Column(name = "STRING_NAME")
    String stringName;
    String description;
    private String documentId;

}
