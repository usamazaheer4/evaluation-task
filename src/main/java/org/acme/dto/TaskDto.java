package org.acme.dto;

import jakarta.json.bind.annotation.JsonbDateFormat;
import org.acme.enums.Priority;
import org.acme.enums.Status;
import org.acme.enums.TaskType;

import java.sql.Date;
import java.util.UUID;

public class TaskDto {
    UUID id;
    @JsonbDateFormat("MM/dd/YYYY")
    Date dueDate;
    String createdBy;
    Status status;
    TaskType taskType;
    Priority priority;
    Boolean sendEmail;
    String notes;
    String emailNotes;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Boolean getSendEmail() {
        return sendEmail;
    }

    public void setSendEmail(Boolean sendEmail) {
        this.sendEmail = sendEmail;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getEmailNotes() {
        return emailNotes;
    }

    public void setEmailNotes(String emailNotes) {
        this.emailNotes = emailNotes;
    }
}
