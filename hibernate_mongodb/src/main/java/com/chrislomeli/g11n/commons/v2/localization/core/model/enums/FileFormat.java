package com.chrislomeli.g11n.commons.v2.localization.core.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Files currently supported within the localize platform. Some of the file types might be directly exposed to clients,
 * while others might be indirectly exposed or internally used by the platform.
 */
@AllArgsConstructor
public enum FileFormat {
    LEGACY_LOCTOOL_JSON(false, ".json", true),
    BUNDLE_JSON(false, ".json", false),
    ANDROID_XML(true, ".xml", true),
    IOS_STRINGS(true, ".strings", true),
    JAVA_PROPERTIES(true, ".properties", true),
    CSV(false, ".csv", false),

    // Not a normal file type that users can explicitly request.
    ZIP(false, ".zip", false),

    // Raw data used as an intermediary for bundle creation.
    // Not a normal file type that users can explicitly request.
    INTERNAL(false, ".json", false);

    @Getter
    private final boolean singleLanguage;

    @Getter
    private final String fileExtension;

    @Getter
    private final boolean baseOnly;
}
