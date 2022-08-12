package com.example.mongosandbox.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class MetaData {
    String departmentName;
    String location;
}
