package org.acme.dto;

import jakarta.json.bind.annotation.JsonbDateFormat;

import java.sql.Date;
import java.util.UUID;

public class ProjectDto {
    UUID id;
    String name;
    String description;
    @JsonbDateFormat("MM/dd/YYYY")
    Date startDate;
    @JsonbDateFormat("MM/dd/YYYY")
    Date endDate;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
