package com.productivity.ui;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class TaskPanel extends VBox {
    public TaskPanel() {
        setSpacing(15);
        setPadding(new Insets(25));

        Label heading = new Label("My Tasks");

        getChildren().add(heading);
    }
}
