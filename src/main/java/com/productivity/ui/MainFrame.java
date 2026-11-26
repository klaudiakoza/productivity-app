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
import com.productivity.repository.TaskRepository;
import com.productivity.ui.DashboardPanel;

public class MainFrame extends Application {
    public void start(Stage stage) {

        BorderPane root = new BorderPane();

        // create shared repository
        TaskRepository taskRepository = new TaskRepository();

        // create a dashboard in the center
        DashboardPanel dashboard = new DashboardPanel(
                taskRepository,
                () -> root.setCenter(new TaskPanel(taskRepository))
        );

        root.setCenter(dashboard);
        // create sidebar on the left side
        SidebarPanel sidebar = new SidebarPanel(() -> {
            root.setCenter(new TaskPanel(taskRepository));
        }, () -> {
            dashboard.updateCounters();
            root.setCenter(dashboard);
        });
        root.setLeft(sidebar);

        // window size
        Scene scene = new Scene(root, 1200, 800);

        scene.getStylesheets().add(
                getClass().getResource("/style.css").toExternalForm()
        );

        stage.setTitle("Better Tasks: Your Productivity Tool");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
