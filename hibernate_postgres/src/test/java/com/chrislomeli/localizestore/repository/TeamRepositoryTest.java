package com.chrislomeli.localizestore.repository;

import com.chrislomeli.localizestore.model.Document;
import com.chrislomeli.localizestore.model.Project;
import com.chrislomeli.localizestore.model.Team;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TeamRepositoryTest {

    @Autowired
    TeamRepository teamRepository;
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    DocumentRepository documentRepository;

    @Test
    public void hello() {
        var team = teamRepository.save(Team.builder()
                .teamName("Blockheads")
                .version(3)
                .build());


        team.addProject(Project.builder()
                .team(team)
                .projectName("Project 1")
                .documentation("stuff.com")
                .instructions("This is a order confirmation")
                .version(3)
                .build());

        var project1 = projectRepository.save(Project.builder()
                .team(team)
                .projectName("Project 1")
                .documentation("stuff.com")
                .instructions("This is a order confirmation")
                .version(3)
                .build());

        var project2 = projectRepository.save(Project.builder()
                .team(team)
                .projectName("Project 2")
                .documentation("stuff.com")
                .instructions("This is a order creeeper")
                .version(3)
                .build());

        System.out.println(team.toString());
    }

    @Test
    void addProjctsForTeamTest() {
        List<Project> projectsList = List.of(
                Project.builder()
                        .projectName("Injected Project 1")
                        .documentation("inject.com")
                        .instructions("This is a order confirmation")
                        .version(3)
                        .build(),
                Project.builder()
                        .projectName("Injected Project 2")
                        .documentation("inject2.com")
                        .instructions("This is a order status")
                        .version(3)
                        .build()
        );
        addProjctsForTeam("9957c460-5f2c-4c53-b2b0-9f1ddf3269cf", projectsList);
    }


    void addProjctsForTeam(String teamId, List<Project> projectsList) {
        var teamOption = teamRepository.findById("9957c460-5f2c-4c53-b2b0-9f1ddf3269cf");
        if (teamOption.isPresent()) {
            var team = teamOption.get();
            for (Project project : projectsList) {
                project.setTeam(team);
                var projectOption = projectRepository.save(project);
                List<Document> tempList = List.of(
                        Document.builder()
                                .documentName("Injected Document 1")
                                .documentation(project.getProjectName()+".com")
                                .instructions("This is a order confirmation")
                                .version(3)
                                .build(),
                        Document.builder()
                                .documentName("Injected Document 2")
                                .documentation(project.getProjectName()+".inject2.com")
                                .instructions("This is a order status")
                                .version(3)
                                .build()
                );

                addDocumentsForProject(projectOption.getId(), tempList);

            }
        }
    }

    void addDocumentsForProject(String projectId, List<Document> documentsList) {
        var projectOption = projectRepository.findById(projectId);
        if (projectOption.isPresent()) {
            var project = projectOption.get();
            for (Document document : documentsList) {
                document.setProject(project);
                documentRepository.save(document);
            }
        }
    }
}
