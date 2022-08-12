package com.example.rdmssandbox.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "document", schema="g11n",
        uniqueConstraints = @UniqueConstraint(columnNames = "name"))
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Document {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    String id;

    @Column(name = "NAME")
    String name;

    @Column(name = "email_address")
    String email;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "documentId")
    private List<Strings> strings = new ArrayList<>();

    @OneToOne
    @JoinColumn(name="departmentId")
    private Department department;


}
