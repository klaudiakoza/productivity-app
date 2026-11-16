package com.productivity.service;

public class TaskValidationService {
    public boolean isValidTitle(String title){
        return title != null && !title.trim().isEmpty();
    }
}
