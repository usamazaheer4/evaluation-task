package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.acme.dao.Client;
import org.acme.dao.Employee;
import org.acme.dao.Project;
import org.acme.dao.Task;
import org.acme.dto.TaskDto;
import org.acme.dto.response.TaskResponseDto;
import org.acme.mapper.TaskMapper;
import org.acme.repository.ClientRepository;
import org.acme.repository.EmployeeRepository;
import org.acme.repository.ProjectRepository;
import org.acme.repository.TaskRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@ApplicationScoped
public class TaskService {

    private final TaskRepository taskRepository;

    private final ClientRepository clientRepository;

    private final EmployeeRepository employeeRepository;

    private final ProjectRepository projectRepository;

    @Inject
    public TaskService(TaskRepository taskRepository, ClientRepository clientRepository,
                       EmployeeRepository employeeRepository, ProjectRepository projectRepository){
        this.taskRepository = taskRepository;
        this.clientRepository = clientRepository;
        this.employeeRepository = employeeRepository;
        this.projectRepository = projectRepository;
    }

    public List<TaskResponseDto> getAllTask(){
        return taskRepository.findAll().stream()
                .map(TaskMapper::toTaskResponseDto).collect(Collectors.toList());
    }

    @Transactional
    public TaskDto createTask(UUID clientId, UUID employeeId, UUID projectId, TaskDto taskDto){
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() ->  new EntityNotFoundException("Client doesn't exists"));
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->  new EntityNotFoundException("Employee doesn't exists"));
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() ->  new EntityNotFoundException("Project doesn't exists"));
        Task task = TaskMapper.toEntity(taskDto);
        task.setClient(client);
        task.setEmployee(employee);
        task.setProject(project);
        return TaskMapper.toDTO(taskRepository.save(task));
    }
}
