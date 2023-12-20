package org.acme.mapper;

import org.acme.dao.Task;
import org.acme.dto.TaskDto;
import org.acme.dto.response.TaskResponseDto;

public class TaskMapper {
    public static Task toEntity(TaskDto taskDto){
        Task task = new Task();
        task.setDueDate(taskDto.getDueDate());
        task.setCreatedBy(taskDto.getCreatedBy());
        task.setStatus(taskDto.getStatus());
        task.setTaskType(taskDto.getTaskType());
        task.setPriority(taskDto.getPriority());
        task.setSendEmail(taskDto.getSendEmail());
        task.setNotes(taskDto.getNotes());
        task.setEmailNotes(taskDto.getEmailNotes());
        return task;
    }

    public static TaskDto toDTO(Task task){
        TaskDto taskDto = new TaskDto();
        taskDto.setDueDate(task.getDueDate());
        taskDto.setCreatedBy(task.getCreatedBy());
        taskDto.setStatus(task.getStatus());
        taskDto.setTaskType(task.getTaskType());
        taskDto.setPriority(task.getPriority());
        taskDto.setSendEmail(task.getSendEmail());
        taskDto.setNotes(task.getNotes());
        taskDto.setEmailNotes(task.getEmailNotes());
        return taskDto;
    }

    public static TaskResponseDto toTaskResponseDto(Task task){
        TaskResponseDto taskResponseDto = new TaskResponseDto();
        taskResponseDto.setDueDate(task.getDueDate());
        taskResponseDto.setCreatedBy(task.getCreatedBy());
        taskResponseDto.setStatus(task.getStatus());
        taskResponseDto.setTaskType(task.getTaskType());
        taskResponseDto.setPriority(task.getPriority());
        taskResponseDto.setSendEmail(task.getSendEmail());
        taskResponseDto.setNotes(task.getNotes());
        taskResponseDto.setEmailNotes(task.getEmailNotes());
        taskResponseDto.setClient(ClientMapper.toDTO(task.getClient()));
        taskResponseDto.setEmployee(EmployeeMapper.toDTO(task.getEmployee()));
        taskResponseDto.setProject(ProjectMapper.toDTO(task.getProject()));
        return taskResponseDto;
    }
}
