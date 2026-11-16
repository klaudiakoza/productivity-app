package com.productivity.service;
import com.productivity.model.Task;
import com.productivity.repository.TaskRepository;

import java.time.LocalDate;
import java.util.ArrayList;

public class TaskService {
    private TaskRepository taskRepository = new TaskRepository();

    public void addTask(String title, String description, String category, String priority, LocalDate dueDate) {
        Task newTask = new Task(title, description, category, priority, dueDate);
        taskRepository.addTask(newTask);
    }

    public void updateTask(String oldTitle, String newTitle, String description, String category, String priority, LocalDate dueDate){
        Task task = taskRepository.findTaskByTitle(oldTitle);

        if (task != null) {
            String oldCategory = task.getCategory();

            task.setTitle(newTitle);
            task.setDescription(description);
            task.setCategory(category);
            task.setPriority(priority);
            task.setDueDate(dueDate);

            taskRepository.updateTaskCategory(task, oldCategory);
        }
    }

    public void deleteTask(String title){
        Task task = taskRepository.findTaskByTitle(title);

        if(task != null){
            taskRepository.deleteTask(task);
        }
    }

    public void sortTasksByDueDate(){
        ArrayList<Task> tasks = taskRepository.getAllTasks();
        for(int i = 1; i < tasks.size(); i++){
            Task task = tasks.get(i);

            int j = i - 1;

            while(j >= 0 && (task.getDueDate() == null || (tasks.get(j).getDueDate() != null) &&
                    tasks.get(j).getDueDate().isAfter(task.getDueDate()))){
                tasks.set(j + 1, tasks.get(j));
                j--;
            }
            tasks.set(j + 1, task);
        }
    }

    public void markTaskCompleted(String title, boolean completed){
        Task task = taskRepository.findTaskByTitle(title);

        if(task != null){
            task.setCompleted(completed);
        }
    }

    public ArrayList<Task> getAllTasks() {
        return taskRepository.getAllTasks();
    }

    public ArrayList<Task> getTasksByCategory(String category) {
        return taskRepository.getTasksByCategory(category);
    }
}
