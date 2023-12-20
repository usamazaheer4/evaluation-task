package org.acme.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.dto.ProjectDto;
import org.acme.service.ProjectService;

import java.util.List;
import java.util.UUID;

@RequestScoped
@Path("/v1/project")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProjectController {

    private final ProjectService projectService;

    @Inject
    public ProjectController(ProjectService projectService){
        this.projectService = projectService;
    }

    @GET
    public List<ProjectDto> getAllProjects(){
        return projectService.getAllProjects();
    }

    @GET
    @Path("/{clientId}")
    public List<ProjectDto> getProjectByClient(@PathParam("clientId") UUID clientId){
        return projectService.getProjectByClient(clientId);
    }

    @POST
    @Path("/{clientId}")
    public ProjectDto saveClientProject(@PathParam("clientId") UUID clientId, ProjectDto projectDto){
        return projectService.saveClientProject(clientId, projectDto);
    }
}
