package me.mdjnewman.twu.samples.todoserver.model;

import java.util.Date;

public class TodoItem {
    private String description;
    private Date dueDate;

    public String getDescription() {
        return description;
    }

    public TodoItem setDescription(String description) {
        this.description = description;
        return this;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public TodoItem setDueDate(Date dueDate) {
        this.dueDate = dueDate;
        return this;
    }
}
