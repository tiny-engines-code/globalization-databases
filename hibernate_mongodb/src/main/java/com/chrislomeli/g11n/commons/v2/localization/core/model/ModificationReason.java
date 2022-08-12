package com.chrislomeli.g11n.commons.v2.localization.core.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ModificationReason {
    private String modificationDescription;
    private List<String> modificationReferenceURLs;
}
