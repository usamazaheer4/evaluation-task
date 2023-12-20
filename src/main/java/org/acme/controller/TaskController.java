package org.acme.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.dto.TaskDto;
import org.acme.dto.response.TaskResponseDto;
import org.acme.service.TaskService;

import java.util.List;
import java.util.UUID;

@Path("/v1/task")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class TaskController {
    private final TaskService taskService;
    @Inject
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GET
    public List<TaskResponseDto> getAllTask(){
        return taskService.getAllTask();
    }

    @POST
    public TaskDto createTask(@QueryParam("client_id")UUID clientId,
                              @QueryParam("employee_id")UUID employeeId,
                              @QueryParam("project_id") UUID projectId,
                              TaskDto taskDto){
        return taskService.createTask(clientId,employeeId,projectId, taskDto);
    }
}
