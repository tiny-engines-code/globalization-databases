package com.chrislomeli.localizestore.model;

import com.chrislomeli.g11n.commons.v2.localization.core.model.enums.Status;
import lombok.Builder;
import lombok.Data;

//@Entity
//@Table(name = "localize_translation", schema = "globalization")

@Data
@Builder
public class Translation  {

    private String fileLinkId;
    private String language;
    private String region;
    private String device;
    private String timeOfDay;
    private String marketplaceId;
    private String description;
    private String instructions;
    private String value;
    private String sha256;
    private String[] tags;
    private Status status;

}
