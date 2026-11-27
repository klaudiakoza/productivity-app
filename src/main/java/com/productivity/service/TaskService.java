package com.productivity.service;
import com.productivity.model.Task;
import com.productivity.repository.TaskRepository;

import java.time.LocalDate;
import java.util.ArrayList;

public class TaskService {
    private TaskRepository taskRepository;

    public TaskService() {
        this.taskRepository = new TaskRepository();
    }

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

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

    public void sortTasksByDueDateAndPriority(){
        ArrayList<Task> tasks = taskRepository.getAllTasks();
        for(int i = 1; i < tasks.size(); i++){
            Task task = tasks.get(i);

            int j = i - 1;

            while(j >= 0 && moveAfter(tasks.get(j), task)){
                tasks.set(j + 1, tasks.get(j));
                j--;
            }
            tasks.set(j + 1, task);
        }
    }

    private boolean moveAfter(Task left, Task right) {
        LocalDate leftDate = left.getDueDate();
        LocalDate rightDate = right.getDueDate();

        if (leftDate == null && rightDate != null) {
            return true;
        }
        if (leftDate != null && rightDate == null) {
            return false;
        }
        if (leftDate != null && !leftDate.equals(rightDate)) {
            return leftDate.isAfter(rightDate);
        }
        return taskPriority(left.getPriority()) > taskPriority(right.getPriority());
    }

    private int taskPriority(String priority) {
        if ("High".equals(priority)) {
            return 1;
        }
        if ("Medium".equals(priority)) {
            return 2;
        }
        if ("Low".equals(priority)) {
            return 3;
        }
        return 4;
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
