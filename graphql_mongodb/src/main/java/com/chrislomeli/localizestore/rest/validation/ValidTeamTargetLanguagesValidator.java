package com.chrislomeli.localizestore.rest.validation;

import com.chrislomeli.localizestore.rest.request.TeamRequest;
import com.chrislomeli.structlog4j.ILogger;
import com.chrislomeli.structlog4j.SLoggerFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidTeamTargetLanguagesValidator implements ConstraintValidator<ValidTeamTargetLanguages, TeamRequest> {
    private static final ILogger LOGGER = SLoggerFactory.getLogger(ValidTeamTargetLanguagesValidator.class);

//    private final AtlasService atlasService;

    public ValidTeamTargetLanguagesValidator() {
        // TODO G11N-1318: this validation executes twice. Interactions with spindle and spring/hiberate cause the default
        //   constructor to be invoked instead of an Autowired constructor. Given lower expected usage of POST/PUT of teams
        //   and projects (versus strings). Created a ticket to followup on this issue.
//        atlasService = Application.getApplicationContext().getBean(AtlasService.class);
    }

//    @Autowired
//    public ValidTeamTargetLanguagesValidator(AtlasService atlasService) {
//        this.atlasService = atlasService;
//    }

    @Override
    public boolean isValid(TeamRequest team, ConstraintValidatorContext context) {
        System.out.println("Enter is valid");
        // get strings from Atlas
//        List<LanguageResponse> atlasLanguages = atlasService.getLanguages();
//
//        List<String> invalidLanguages = team.getProjectDefaults().getTargetLanguages().stream()
//                .filter(language -> atlasLanguages.stream().filter(languageResponse -> language.equals(languageResponse.getId())).collect(Collectors.toList()).isEmpty())
//                .collect(Collectors.toList());
//
//        if (!invalidLanguages.isEmpty()) {
//            LOGGER.warn("Invalid language found", "languages", invalidLanguages);
//
//            context.buildConstraintViolationWithTemplate("Invalid language(s) found, " + invalidLanguages)
//                    .addPropertyNode("projectDefaults.targetLanguages")
//                    .addConstraintViolation();
//            context.disableDefaultConstraintViolation();
//        }
//
//        return invalidLanguages.isEmpty();
        return true;
    }
}
