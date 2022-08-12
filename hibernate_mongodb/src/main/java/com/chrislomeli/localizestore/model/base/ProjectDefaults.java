package com.chrislomeli.localizestore.model.base;

import com.chrislomeli.g11n.commons.v2.localization.core.model.enums.RequireReview;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectDefaults {
    private String sourceLanguage;
    private String consumerChannel;
    private RequireReview requireReview;
    private String contextURL;
    private String contactEmail;
    private String slackChannel;
    private String contentType;
    private String invoiceRegion;
    private String invoiceCategory;
    private String[] targetLanguages;

}
