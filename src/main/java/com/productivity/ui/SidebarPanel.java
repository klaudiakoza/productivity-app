package com.productivity.ui;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

public class SidebarPanel extends VBox {
    public SidebarPanel(Runnable openTaskPanel, Runnable openDashboard) {

        // sidebar layout
        setSpacing(15);
        setPadding(new Insets(25));
        setAlignment(Pos.TOP_LEFT);

        // application name
        Label appName = new Label("Better Tasks");
        appName.setStyle(
                "-fx-font-size: 20px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #222222;"
        );
        appName.setPadding(new Insets(0, 0, 25, 5));

        // add logo
        Image logoImage = new Image(
                getClass().getResourceAsStream("/images/tasks.png")
        );

        ImageView logo = new ImageView(logoImage);
        logo.setFitWidth(50);
        logo.setFitHeight(50);
        logo.setPreserveRatio(true);
        HBox branding = new HBox(10);
        branding.setAlignment(Pos.CENTER_LEFT);
        branding.getChildren().addAll(logo, appName);

        // navigation buttons
        Button dashboardButton = new Button("Dashboard");
        dashboardButton.setOnAction(e -> openDashboard.run());
        Button tasksButton = new Button("My Tasks");
        tasksButton.setOnAction(e -> openTaskPanel.run());
        Button categoriesButton = new Button("Categories");
        Button calendarButton = new Button("Calendar");
        Button settingsButton = new Button("Settings");
        // Style for regular navigation buttons
        String buttonStyle =
                "-fx-background-color: transparent;" +
                        "-fx-text-fill: #555555;" +
                        "-fx-font-size: 13px;" +
                        "-fx-alignment: CENTER_LEFT;" +
                        "-fx-padding: 10 12;" +
                        "-fx-background-radius: 6;" +
                        "-fx-cursor: hand;";

        // apply regular style
        dashboardButton.setStyle(buttonStyle);
        tasksButton.setStyle(buttonStyle);
        categoriesButton.setStyle(buttonStyle);
        calendarButton.setStyle(buttonStyle);
        settingsButton.setStyle(buttonStyle);

        // Apply hover colors and restore each button's original style on exit.
        for (Button button : new Button[]{dashboardButton, tasksButton,
                categoriesButton, calendarButton, settingsButton}) {
            String normalStyle = button.getStyle();
            button.setOnMouseEntered(e -> button.setStyle(normalStyle
                    + "-fx-background-color: #153A63;"
                    + "-fx-text-fill: white;"));
            button.setOnMouseExited(e -> button.setStyle(normalStyle));
        }

        // Make buttons fill the sidebar width
        dashboardButton.setMaxWidth(Double.MAX_VALUE);
        tasksButton.setMaxWidth(Double.MAX_VALUE);
        categoriesButton.setMaxWidth(Double.MAX_VALUE);
        calendarButton.setMaxWidth(Double.MAX_VALUE);
        settingsButton.setMaxWidth(Double.MAX_VALUE);

        Region spacer = new Region();
        VBox.setVgrow(spacer, Priority.ALWAYS);

        // add components to sidebar
        getChildren().addAll(
                branding,
                dashboardButton,
                tasksButton,
                categoriesButton,
                calendarButton,
                spacer,
                settingsButton
        );
    }
}
