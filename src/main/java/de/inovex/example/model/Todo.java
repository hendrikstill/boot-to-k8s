package de.inovex.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * A todo task
 */
@Entity
public class Todo {

    @Id
    private Long id;
    private String name;
    private boolean done;

    public Todo(){

    }

    public Todo(Long id, String name, boolean done){
        this.id = id;
        this.name = name;
        this.done = done;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
