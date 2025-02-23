
package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "todo_items")
public class ToDoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String task;

    @Column
    private boolean completed;

    public ToDoItem() {}

    public ToDoItem(String task, boolean completed) {
        this.task = task;
        this.completed = completed;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTask() { return task; }
    public void setTask(String task) { this.task = task; }
    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }
}
