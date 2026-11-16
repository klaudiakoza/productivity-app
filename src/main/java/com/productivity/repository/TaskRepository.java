package com.productivity.repository;
import com.productivity.model.Task;

import java.util.ArrayList;
import java.util.HashMap;

public class TaskRepository {
    private ArrayList<Task> tasks = new ArrayList<>();
    private HashMap<String, ArrayList<Task>> tasksByCategory = new HashMap<>();

    public void addTask(Task task){
        tasks.add(task);

        String category = task.getCategory();

        if(!tasksByCategory.containsKey(category)) {
            tasksByCategory.put(category, new ArrayList<>());
        }
        tasksByCategory.get(category).add(task);
    }

    public ArrayList<Task> getAllTasks() {
        return tasks;
    }

    public ArrayList<Task> getTasksByCategory(String category) {
        return tasksByCategory.get(category);
    }

    public Task findTaskByTitle(String title){
        for (Task task : tasks){
            if(task.getTitle().equals(title)){
                return task;
            }
        }
        return null;
    }

    public void updateTaskCategory(Task task, String oldCategory){
        String newCategory = task.getCategory();

        if(!oldCategory.equals(newCategory)) {
            tasksByCategory.get(oldCategory).remove(task);

            if (!tasksByCategory.containsKey(newCategory)) {
                tasksByCategory.put(newCategory, new ArrayList<>());
            }
            tasksByCategory.get(newCategory).add(task);
        }
    }

    public void deleteTask(Task task){
        tasks.remove(task);

        String category = task.getCategory();
        tasksByCategory.get(category).remove(task);

        if(tasksByCategory.get(category).isEmpty()){
            tasksByCategory.remove(category);
        }
    }
}
