package com.productivity.ui;

import com.productivity.repository.TaskRepository;
import com.productivity.model.Task;

import javafx.scene.control.Label;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

import java.time.LocalDate;

public class DashboardPanel extends VBox {
    private ArrayList<String> messages = new ArrayList<>();

    private TaskRepository taskRepository;
    private Label totalNumber;
    private Label pendingNumber;
    private Label completedNumber;
    private VBox todayTasksSection;
    private VBox upcomingDeadlinesSection;

    public DashboardPanel(TaskRepository taskRepository, Runnable openTaskPanel) {
        this.taskRepository = taskRepository;

        // set dashboard layout
        setSpacing(25);
        setPadding(new Insets(35));
        setAlignment(Pos.TOP_LEFT);

        Label heading = new Label("My Dashboard");
        heading.setStyle(
                "-fx-font-family: 'Arial';" +
                        "-fx-font-size: 28px; " +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #222222;"
        );

        // welcome messages options:
        messages.add("Hello! Ready to make today count?");
        messages.add("Small steps lead to big achievements.");
        messages.add("You've got this! Let's get things done.");
        messages.add("Because sometimes all you need is a deadline.");

        // create a Random object to generate a random index
        Random random = new Random();

        // generate a random index within the range of available messages
        int index = random.nextInt(messages.size());

        // retrieve the message at the randomly selected index
        String selectedMessage = messages.get(index);

        // create a label displaying the selected welcome message
        Label welcomeLabel = new Label(selectedMessage);
        welcomeLabel.setStyle(
                "-fx-font-size: 18px;" +
                        "-fx-text-fill: #888888;"
        );

        // apply the welcome label to the VBox
        getChildren().add(heading);
        getChildren().add(welcomeLabel);


        //SUMMARY CARDS SECTION
        // create a horizontal layout for task summary cards
        HBox summaryBox = new HBox();
        summaryBox.setSpacing(15);

        totalNumber = new Label("0");
        totalNumber.setStyle(
                "-fx-font-family: 'Arial';" +
                "-fx-font-size: 28px; " +
                "-fx-font-weight: bold;");
        totalNumber.setMinWidth(60);
        Label totalTitle = new Label("Total Tasks");
        VBox totalCard = new VBox(totalNumber, totalTitle);
        totalCard.setPadding(new Insets(20));
        totalCard.setSpacing(8);
        totalCard.setPrefWidth(180);
        totalCard.setStyle(
                "-fx-background-color: #F7F7F7;" +
                        "-fx-background-radius: 8;"
        );

        pendingNumber = new Label("0");
        pendingNumber.setStyle(
                "-fx-font-family: 'Arial';" +
                "-fx-font-size: 28px; " +
                "-fx-font-weight: bold;");
        pendingNumber.setMinWidth(60);
        Label pendingTitle = new Label("Pending");
        VBox pendingCard = new VBox(pendingNumber, pendingTitle);
        pendingCard.setPadding(new Insets(20));
        pendingCard.setSpacing(8);
        pendingCard.setPrefWidth(180);
        pendingCard.setStyle(
                "-fx-background-color: #FFF5D9;" +
                        "-fx-background-radius: 8;"
        );

        completedNumber = new Label("0");
        completedNumber.setStyle(
                "-fx-font-family: 'Arial';" +
                "-fx-font-size: 28px;" +
                "-fx-font-weight: bold;");
        completedNumber.setMinWidth(60);
        Label completedTitle = new Label("Completed");
        VBox completedCard = new VBox(completedNumber, completedTitle);
        completedCard.setPadding(new Insets(20));
        completedCard.setSpacing(8);
        completedCard.setPrefWidth(180);
        completedCard.setStyle(
                "-fx-background-color: #E8F4EA;" +
                        "-fx-background-radius: 8;"
        );

        summaryBox.getChildren().addAll(
                totalCard,
                pendingCard,
                completedCard
        );

        getChildren().add(summaryBox);

        // TODAY'S TASKS SECTION
        todayTasksSection = new VBox(15);
        todayTasksSection.setPadding(new Insets(20));
        todayTasksSection.getStyleClass().add("content-card");


        // UPCOMING DEADLINES SECTION
        upcomingDeadlinesSection = new VBox(10);
        upcomingDeadlinesSection.setPadding(new Insets(20));
        upcomingDeadlinesSection.getStyleClass().add("content-card");

        getChildren().addAll(todayTasksSection, upcomingDeadlinesSection);


        // QUICK ACTIONS SECTION
        VBox quickActionsSection = new VBox(15);

        Label quickActionsHeading = new Label("Quick Actions");
        quickActionsHeading.setStyle(
                "-fx-font-size: 18px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #222222;"
        );

        // Create action cards
        HBox actionCards = new HBox(15);

        VBox addTaskCard = createActionCard(
                "+",
                "Add New Task",
                "Create a new task",
                "#F1EEFF",
                "#6855C8"
        );
        // Open New Task window when clicked
        addTaskCard.setOnMouseClicked(event -> {
            AddNewTaskPanel newTaskPanel =
                    new AddNewTaskPanel(taskRepository);

            Stage taskStage = new Stage();
            taskStage.setTitle("Add New Task");
            taskStage.setScene(new Scene(newTaskPanel, 450, 500));
            taskStage.setOnHidden(e -> updateCounters());
            taskStage.show();
        });

        addTaskCard.setStyle(
                "-fx-background-color: #F1EEFF;" +
                        "-fx-background-radius: 8;" +
                        "-fx-cursor: hand;"
        );

        addTaskCard.setOnMouseEntered(e ->
                addTaskCard.setStyle(
                        "-fx-background-color: #E8E3FA;" +
                                "-fx-background-radius: 8;" +
                                "-fx-cursor: hand;"
                )
        );

        addTaskCard.setOnMouseExited(e ->
                addTaskCard.setStyle(
                        "-fx-background-color: #F1EEFF;" +
                                "-fx-background-radius: 8;" +
                                "-fx-cursor: hand;"
                )
        );

        VBox viewTasksCard = createActionCard(
                "☷",
                "View All Tasks",
                "Manage your tasks",
                "#EAF3FF",
                "#3976BA"
        );

        viewTasksCard.setOnMouseClicked(e -> openTaskPanel.run());
        viewTasksCard.setStyle(
                viewTasksCard.getStyle() + "-fx-cursor: hand;"
        );

        actionCards.getChildren().addAll(
                addTaskCard,
                viewTasksCard
        );

        quickActionsSection.getChildren().addAll(
                quickActionsHeading,
                actionCards
        );

        getChildren().add(quickActionsSection);
        updateCounters();
    }
    public void updateCounters() {
        int total = taskRepository.getAllTasks().size();
        int completed = 0;

        for (Task task : taskRepository.getAllTasks()) {
            if (task.isCompleted()) {
                completed++;
            }
        }

        totalNumber.setText(String.valueOf(total));
        pendingNumber.setText(String.valueOf(total - completed));
        completedNumber.setText(String.valueOf(completed));
        updateTaskSections();
    }

    private void updateTaskSections() {
        Label todayHeading = new Label("Today's Tasks");
        todayHeading.getStyleClass().add("heading");
        todayTasksSection.getChildren().setAll(todayHeading);

        Label deadlinesHeading = new Label("Upcoming Deadlines");
        deadlinesHeading.getStyleClass().add("heading");
        upcomingDeadlinesSection.getChildren().setAll(deadlinesHeading);

        LocalDate today = LocalDate.now();

        for (Task task : taskRepository.getAllTasks()) {
            LocalDate dueDate = task.getDueDate();
            if (dueDate == null) {
                continue;
            }

            if (dueDate.equals(today)) {
                CheckBox taskBox = new CheckBox(task.getTitle());
                taskBox.setSelected(task.isCompleted());
                taskBox.setWrapText(true);
                taskBox.setOnAction(e -> {
                    task.setCompleted(taskBox.isSelected());
                    updateCounters();
                });
                todayTasksSection.getChildren().add(taskBox);
            } else if (dueDate.isAfter(today) && !task.isCompleted()) {
                Label deadline = new Label(task.getTitle() + " — Due: " + dueDate);
                deadline.setWrapText(true);
                upcomingDeadlinesSection.getChildren().add(deadline);
            }
        }

        if (todayTasksSection.getChildren().size() == 1) {
            todayTasksSection.getChildren().add(new Label("No tasks due today."));
        }
        if (upcomingDeadlinesSection.getChildren().size() == 1) {
            upcomingDeadlinesSection.getChildren().add(new Label("No upcoming deadlines."));
        }
    }

    private VBox createActionCard(String icon, String title,
                                  String description,
                                  String backgroundColor,
                                  String textColor) {
        Label iconLabel = new Label(icon);
        iconLabel.setStyle("-fx-font-size: 24px; -fx-text-fill: " + textColor + ";");

        Label titleLabel = new Label(title);
        titleLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: " + textColor + ";");

        Label descriptionLabel = new Label(description);

        VBox card = new VBox(8, iconLabel, titleLabel, descriptionLabel);
        card.setPadding(new Insets(20));
        card.setPrefWidth(220);
        card.setStyle("-fx-background-color: " + backgroundColor + ";"
                + "-fx-background-radius: 8;");

        return card;
    }
}
