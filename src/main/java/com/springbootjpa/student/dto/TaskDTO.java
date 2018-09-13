package com.springbootjpa.student.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TaskDTO {
    @JsonProperty("task")
    private String task;


    public TaskDTO() {
    }

    public String getTask() {
        return task;
    }

    public void setTasks(String task) {
        this.task = task;
    }
}
