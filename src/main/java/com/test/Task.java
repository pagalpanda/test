package com.test;


public class Task {
    private final String details;

    public Task(String details) {
        this.details = details;
    }
    public void execute() {

        System.out.println("Running " + details );
    }
}
