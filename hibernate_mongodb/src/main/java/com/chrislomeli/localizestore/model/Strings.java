package com.chrislomeli.localizestore.model;

import com.chrislomeli.g11n.commons.v2.localization.core.model.enums.Status;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Strings  {

    private String key;
    private String description;
    private String fileLinkId;
    private String instructions;
    private String[] tags;
    private Status status;
    private List<Translation> translations = new ArrayList<>();

}
