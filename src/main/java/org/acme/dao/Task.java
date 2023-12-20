package org.acme.dao;

import jakarta.persistence.*;
import org.acme.enums.Priority;
import org.acme.enums.Status;
import org.acme.enums.TaskType;

import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    @Column(name = "due_date")
    Date dueDate;
    @Column(name = "created_by")
    String createdBy;
    @ManyToOne
    @JoinColumn(name="client_id", nullable = false)
    Client client;
    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    Project project;
    @Enumerated(EnumType.STRING)
    Status status;
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    Employee employee;
    @Column(name = "task_type")
    @Enumerated(EnumType.STRING)
    TaskType taskType;
    @Enumerated(EnumType.STRING)
    Priority priority;
    @Column(name = "send_email", nullable = false)
    Boolean sendEmail;
    String notes;
    @Column(name = "email_notes")
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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
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
