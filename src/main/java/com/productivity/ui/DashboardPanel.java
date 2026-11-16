package com.productivity.ui;

import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.Random;

public class DashboardPanel extends VBox {
    private ArrayList<String> messages = new ArrayList<>();
    public DashboardPanel() {
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

        Label totalNumber = new Label("0");
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

        Label pendingNumber = new Label("0");
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

        Label completedNumber = new Label("0");
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
        VBox todayTasksSection = new VBox();
        todayTasksSection.setSpacing(10);

        Label todayHeading = new Label("Today's Tasks");
        todayHeading.setStyle(
                "-fx-font-size: 16px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #222222;"
        );
        todayTasksSection.getChildren().add(todayHeading);

        // create task checkboxes
        // !NOTE: THESE ARE JUST PLACEHOLDERS!
        CheckBox task1 = new CheckBox("Finish Java assignment");
        CheckBox task2 = new CheckBox("Study for CS 2013 exam");
        CheckBox task3 = new CheckBox("Review cybersecurity presentation");

        // style checkboxes
        String taskStyle =
                "-fx-font-size: 13px;" +
                        "-fx-text-fill: #333333;";

        task1.setStyle(taskStyle);
        task2.setStyle(taskStyle);
        task3.setStyle(taskStyle);

        // add tasks to today's section
        todayTasksSection.getChildren().addAll(task1, task2, task3);
        getChildren().add(todayTasksSection);

        // UPCOMING DEADLINES SECTION
        VBox upcomingDeadlinesSection = new VBox();
        upcomingDeadlinesSection.setSpacing(10);
        Label deadlinesHeading = new Label("Upcoming Deadlines");
        deadlinesHeading.setStyle(
                "-fx-font-size: 16px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #222222;"
        );
        upcomingDeadlinesSection.getChildren().add(deadlinesHeading);


        // create example deadline previews
        // !NOTE: THESE ARE JUST PLACEHOLDERS!
        Label deadline1 = new Label("• Java Assignment - November 18");
        Label deadline2 = new Label("• Database Project - November 21");
        Label deadline3 = new Label("• Cybersecurity Presentation - December 7");

        // add deadlines to section
        upcomingDeadlinesSection.getChildren().addAll(
                deadline1,
                deadline2,
                deadline3
        );

        getChildren().add(upcomingDeadlinesSection);

        // QUICK ACTIONS SECTION
        VBox quickActionsSection = new VBox();
        quickActionsSection.setSpacing(10);
        Label quickActionsHeading = new Label("Quick Actions");
        quickActionsHeading.setStyle(
                "-fx-font-size: 16px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #222222;"
        );

        // create buttons
        Button addTaskButton = new Button("+ Add New Task");
        Button viewTasksButton = new Button("View All Tasks");

        // add heading and buttons to section
        quickActionsSection.getChildren().addAll(
                quickActionsHeading,
                addTaskButton,
                viewTasksButton
        );
        getChildren().add(quickActionsSection);
    }
}
