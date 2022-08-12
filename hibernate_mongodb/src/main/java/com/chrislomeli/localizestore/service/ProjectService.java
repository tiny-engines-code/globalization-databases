package com.chrislomeli.localizestore.service;

import com.chrislomeli.localizestore.model.Project;
import com.chrislomeli.localizestore.repository.ProjectRepository;
import com.chrislomeli.localizestore.repository.TeamRepository;
import com.chrislomeli.localizestore.rest.request.ProjectRequest;
import com.chrislomeli.localizestore.rest.response.ProjectResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectService {

   private final TeamRepository teamRepository;
    private final ProjectRepository projectRepository;

    public ProjectService(TeamRepository teamRepository, ProjectRepository repository) {
        this.teamRepository = teamRepository;
        this.projectRepository = repository;
    }

    public Page<Project> list(Pageable page) {
        return projectRepository.findAll(page);
    }

    public Optional<Project> get(String id) {
          return projectRepository.findById(id);
    }

    public Project create(Project request) {
            return projectRepository.save(request);
    }

    public ProjectResponse createProject(ProjectRequest request) {
        var teamId = request.getParentId();
        var teamobject = teamRepository.findById(teamId);
        if (teamobject.isPresent()) {
            var team = teamobject.get();
            var project =   projectRepository.save(request.toProject());
            team.addProject(project);
            teamRepository.save(team);
            return new ProjectResponse(project);
        }
        return null;
    }

    public Project update(Project request) {
        return projectRepository.save(request);
    }

    public ResponseEntity<HttpStatus> delete(String id) {
            if (projectRepository.existsById(id)) {
                projectRepository.deleteById(id);
                return new ResponseEntity<>(HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
    }
}
