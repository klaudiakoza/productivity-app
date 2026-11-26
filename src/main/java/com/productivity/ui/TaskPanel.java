package com.productivity.ui;

import com.productivity.model.Task;
import com.productivity.repository.TaskRepository;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class TaskPanel extends VBox {
    public TaskPanel(TaskRepository taskRepository) {
        setSpacing(15);
        setPadding(new Insets(25));

        Label heading = new Label("My Tasks");
        getChildren().add(heading);

        if (taskRepository.getAllTasks().isEmpty()) {
            getChildren().add(new Label("No tasks yet. Add your first task!"));
        }

        for (Task task : taskRepository.getAllTasks()) {
            CheckBox completedBox = new CheckBox(task.getTitle());
            completedBox.setSelected(task.isCompleted());

            completedBox.setOnAction(event ->
                    task.setCompleted(completedBox.isSelected())
            );

            Label details = new Label(
                    task.getCategory() + " | "
                            + task.getPriority() + " | Due: "
                            + task.getDueDate()
            );

            VBox taskCard = new VBox(5, completedBox, details);
            taskCard.setPadding(new Insets(12));
            taskCard.getStyleClass().add("content-card");

            getChildren().add(taskCard);
        }
    }
}