package com.example.Focusline_app;

import java.time.Instant;

public class Task {

    private Long id;
    private String title;
    private boolean done;
    private Instant createdAt;

    public Task() {
    }

    public Task(Long id, String title, boolean done, Instant createdAt) {
        this.id = id;
        this.title = title;
        this.done = done;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isDone() {
        return done;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

}
