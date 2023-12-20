package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.acme.dao.Client;
import org.acme.dao.Project;
import org.acme.dto.ProjectDto;
import org.acme.mapper.ProjectMapper;
import org.acme.repository.ClientRepository;
import org.acme.repository.ProjectRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@ApplicationScoped
public class ProjectService {

    private final ProjectRepository projectRepository;

    private final ClientRepository clientRepository;

    @Inject
    public ProjectService(ProjectRepository projectRepository, ClientRepository clientRepository){
        this.projectRepository = projectRepository;
        this.clientRepository = clientRepository;
    }

    public List<ProjectDto> getAllProjects(){
        return projectRepository.findAll().stream()
                .map(ProjectMapper::toDTO).collect(Collectors.toList());
    }

    public List<ProjectDto> getProjectByClient(UUID clientId){
        return projectRepository.findAllByClient_Id(clientId).stream()
                .map(ProjectMapper::toDTO).collect(Collectors.toList());
    }

    @Transactional
    public ProjectDto saveClientProject(UUID clientId, ProjectDto projectDto) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new EntityNotFoundException("Client Not Found"));

        Project project = ProjectMapper.toEntity(projectDto);
        project.setClient(client);

        Project savedProject = projectRepository.save(project);

        return ProjectMapper.toDTO(savedProject);
    }

}
