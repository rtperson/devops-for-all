/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chyernobog.tasklistbackend;

import org.joda.time.DateTime;

/**
 *
 * @author roger
 */
public class Task {
    
    private final long id;
    private final String taskName;
    private final DateTime dueDate;
    
    public Task(long id, String taskName, DateTime dueDate) {
        this.id = id;
        this.taskName = taskName;
        this.dueDate = dueDate;
    }

    public long getId() {
        return id;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getDueDate() {
        return dueDate.toString();
    }
    
}
