/**
 * Main entry point of the UI.
 * Initializes the JavaFX application and sets up the main window.
 */
package com.productivity.ui;

import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class MainFrame extends Application {
    public void start(Stage stage) {

        BorderPane root = new BorderPane();

        // create a dashboard in the center
        DashboardPanel dashboard = new DashboardPanel();
        root.setCenter(dashboard);

        // window size
        Scene scene = new Scene(root, 900, 600);

        stage.setTitle("Productivity App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
