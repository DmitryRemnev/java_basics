package main.model;

import java.util.concurrent.atomic.AtomicLong;

public class ToDo {

    private AtomicLong id;

    private String title;

    private String description;

    public AtomicLong getId() {
        return id;
    }

    public void setId(AtomicLong id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}