package com.chrislomeli.localizestore.rest.validation;

import com.chrislomeli.structlog4j.ILogger;
import com.chrislomeli.structlog4j.SLoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.Objects;

public class TargetLanguagesContainsSourceValidator implements ConstraintValidator<TargetLanguagesContainsSource, Object> {
    private static final ILogger LOGGER = SLoggerFactory.getLogger(TargetLanguagesContainsSourceValidator.class);

    public TargetLanguagesContainsSourceValidator() {
        ;
    }

    /**
     * Entry point for Spring
     */
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        return true;
//        ProjectService projectService = Application.getApplicationContext().getBean(ProjectService.class);
//        final RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
//        HttpServletRequest httpServletRequest;
//        if (requestAttributes instanceof ServletRequestAttributes) {
//            httpServletRequest = ((ServletRequestAttributes) requestAttributes).getRequest();
//        } else {
//            throw new InternalErrorException("Failed to load ServletRequestAttributes");
//        }
//
//        return validate(value, context, projectService, httpServletRequest);
    }

    /**
     * Entry point for unit tests
     */
    public boolean isValid(Object value,
                           ConstraintValidatorContext context,
                           Object projectService,
                           HttpServletRequest httpServletRequest) {
        return true;

    }

    @Override
    public void initialize(TargetLanguagesContainsSource constraintAnnotation) {
    }

    private boolean validate(Object value,
                            ConstraintValidatorContext context,
                            Object projectService,
                            HttpServletRequest httpServletRequest) { return true; }

    private boolean isValid(final String sourceLanguage, final List<String> targetLanguages) {
        if (Objects.isNull(targetLanguages) || Objects.isNull(sourceLanguage)) {
            return true;
        }

        return !targetLanguages.contains(sourceLanguage);
    }

//    private Project populateProject(final ProjectRequest request,
//                                    final ProjectService projectService,
//                                    final HttpServletRequest httpServletRequest) {
//        final Project project = request.toProject();
//        // NOTE: race condition exists here, from validating the inherited project to saving
//
//
//        LOGGER.info("populateProject set pathSteps of project started",
//                "ticket", "G11N-2412",
//                "getRequestURI", httpServletRequest.getRequestURI(),
//                "getContextPath", httpServletRequest.getContextPath(),
//                "getMethod", httpServletRequest.getMethod(),
//                "getHeaderTraceId", httpServletRequest.getHeader("x-b3-traceid"),
//                "request", request
//        );
//
//        final List<PathStep> pathSteps;
//        if (httpServletRequest.getMethod().equalsIgnoreCase(RequestMethod.POST.toString())) {
//            // NOTE: probably could pass this data to the controller and save replaying this logic.
//            pathSteps = projectService.getProjectPathSteps(project);
//        } else if (httpServletRequest.getMethod().equalsIgnoreCase(RequestMethod.PUT.toString())) {
//            final String path = new UrlPathHelper().getPathWithinApplication(httpServletRequest);
//            List<String> pathSegments = new ArrayList<>(List.of(StringUtils.split(path, "/")));
//            Collections.reverse(pathSegments);
//            String id = pathSegments.stream()
//                    .filter(Objects::nonNull)
//                    .filter(s -> !s.isEmpty())
//                    .findFirst()
//                    .orElseThrow(() -> new InternalErrorException("HTTP path has no segments: " + path));
//
//            LOGGER.info("populateProject set pathSteps of project (PUT)",
//                    "ticket", "G11N-2412",
//                    "path", path,
//                    "pathSegments", pathSegments,
//                    "id", id,
//                    "getRequestURI", httpServletRequest.getRequestURI(),
//                    "getContextPath", httpServletRequest.getContextPath(),
//                    "getMethod", httpServletRequest.getMethod(),
//                    "getHeaderTraceId", httpServletRequest.getHeader("x-b3-traceid"),
//                    "request", request
//            );
//            pathSteps = projectService.getProject(id, false).getPath();
//        } else {
//            String message = String.format("Unexpected HTTP Method hit LanguagesValidator. httpMethod=%s", httpServletRequest.getMethod());
//            throw new InternalErrorException(message);
//        }
//
//        LOGGER.info("populateProject set pathSteps of project completed",
//                "ticket", "G11N-2412",
//                "getRequestURI", httpServletRequest.getRequestURI(),
//                "getContextPath", httpServletRequest.getContextPath(),
//                "getMethod", httpServletRequest.getMethod(),
//                "getHeaderTraceId", httpServletRequest.getHeader("x-b3-traceid"),
//                "request", request,
//                "pathSteps", pathSteps
//        );
//
//        return projectService.applyInheritance(project.setPath(pathSteps));
//    }
}
