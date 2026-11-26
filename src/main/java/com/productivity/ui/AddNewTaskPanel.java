package com.productivity.ui;

import com.productivity.model.Category;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import com.productivity.model.Task;
import com.productivity.repository.TaskRepository;
import java.time.LocalDate;
import javafx.scene.control.TextArea;

public class AddNewTaskPanel extends VBox {

    // Task input
    private TextField taskNameField;

    // Category dropdown
    private ComboBox<Category> categoryBox;

    // Due date
    private DatePicker dueDatePicker;

    private TextArea descriptionField;
    private ComboBox<String> priorityBox;
    private final TaskRepository taskRepository;

    // Constructor
    public AddNewTaskPanel(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;

        setSpacing(15);
        setPadding(new Insets(25));

        // PANEL TITLE
        Label title = new Label("Add New Task");
        title.setStyle(
                "-fx-font-size: 24px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #222222;"
        );

        // TASK NAME
        Label taskNameLabel = new Label("Task Name");

        taskNameField = new TextField();
        taskNameField.setPromptText("Enter task name...");
        taskNameField.setPrefHeight(40);

        // DESCRIPTION
        Label descriptionLabel = new Label("Description");

        descriptionField = new TextArea();
        descriptionField.setPromptText("Describe your task...");
        descriptionField.setPrefRowCount(3);
        descriptionField.setMaxWidth(Double.MAX_VALUE);

        // PRIORITY
        Label priorityLabel = new Label("Priority");

        priorityBox = new ComboBox<>();
        priorityBox.getItems().addAll("Low", "Medium", "High");
        priorityBox.setPromptText("Select priority");
        priorityBox.setMaxWidth(Double.MAX_VALUE);
        priorityBox.setPrefHeight(40);

        // CATEGORY
        Label categoryLabel = new Label("Category");

        categoryBox = new ComboBox<>();

        categoryBox.getItems().addAll(
                new Category(1, "School", "#ADD8E6"),
                new Category(2, "Work", "#90EE90"),
                new Category(3, "Personal", "#FFB6C1")
        );

        categoryBox.setPromptText("Select category");
        categoryBox.setMaxWidth(Double.MAX_VALUE);
        categoryBox.setPrefHeight(40);

        // DUE DATE
        Label dueDateLabel = new Label("Due Date");

        dueDatePicker = new DatePicker();
        dueDatePicker.setPromptText("Choose due date");
        dueDatePicker.setMaxWidth(Double.MAX_VALUE);
        dueDatePicker.setPrefHeight(40);

        // ADD TASK BUTTON
        Button addTaskButton = new Button("Add Task");

        addTaskButton.setPrefWidth(150);
        addTaskButton.setPrefHeight(40);

        addTaskButton.setStyle(
                "-fx-background-color: #6CA6CD;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 14px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-background-radius: 8px;"
        );

        // BUTTON ACTION
        addTaskButton.setOnAction(event -> addTask());

        // ADD EVERYTHING TO PANEL
        getChildren().addAll(
                title,
                taskNameLabel,
                taskNameField,
                descriptionLabel,
                descriptionField,
                categoryLabel,
                categoryBox,
                priorityLabel,
                priorityBox,
                dueDateLabel,
                dueDatePicker,
                addTaskButton
        );

        setStyle("-fx-background-color: #EAF5FF;");
    }

    // ADD TASK METHOD
    private void addTask() {

        String taskName = taskNameField.getText();
        String description = descriptionField.getText();

        Category selectedCategory = categoryBox.getValue();
        String priority = priorityBox.getValue();

        LocalDate dueDate = dueDatePicker.getValue();

        // VALIDATION
        if (taskName == null || taskName.trim().isEmpty()) {
            System.out.println("Please enter a task name.");
            return;
        }

        if (selectedCategory == null) {
            System.out.println("Please select a category.");
            return;
        }

        if (priority == null) {
            System.out.println("Please select a priority.");
            return;
        }

        if (dueDate == null) {
            System.out.println("Please select a due date.");
            return;
        }

        // CREATE TASK OBJECT
        Task task = new Task(
                taskName,
                description,
                selectedCategory.getName(),
                priority,
                dueDate
        );

        // SAVE TASK TO REPOSITORY
        taskRepository.addTask(task);

        System.out.println("Task successfully added!");
        System.out.println("Title: " + task.getTitle());
        System.out.println("Category: " + task.getCategory());
        System.out.println("Priority: " + task.getPriority());

        showSuccess(task.getTitle());
    }

    private void showSuccess(String taskTitle) {
        Label message = new Label("Task successfully added!");
        message.setWrapText(true);
        message.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;"
                + "-fx-text-fill: #247044;");

        Label details = new Label(taskTitle);
        details.setWrapText(true);

        Button closeButton = new Button("Close");
        closeButton.setOnAction(event -> getScene().getWindow().hide());

        Button addAnotherButton = new Button("Add Another Task");
        addAnotherButton.setOnAction(event ->
                getScene().setRoot(new AddNewTaskPanel(taskRepository))
        );

        setAlignment(Pos.CENTER);
        getChildren().setAll(message, details, closeButton, addAnotherButton);
    }
}
