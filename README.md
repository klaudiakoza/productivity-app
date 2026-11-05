## Project structure
Application packages are under `src/main/java/com/productivity/`.

| Package or file | Intended responsibility |
| --- | --- |
| `Main.java` | Entry point that starts the application. |
| `model` | Represents application data through `Task`, `User`, and `Category`. |
| `service` | Handles task operations through `TaskService` and checks task input through `TaskValidationService`. |
| `ui` | Provides the application window and screens through `MainFrame`, `DashboardPanel`, and `TaskPanel`. |
| `src/test/java/com/productivity/` | Contains placeholders for repository, service, and validation tests. |
| `pom.xml` | Defines the Java target, dependencies, and Maven build plugins. |

The intended flow is for the UI to call services, and for services to use
repositories to store or retrieve data. Models hold the data used by these layers.

## Requirements
- JDK 26, matching the Java target in `pom.xml`.
- Maven for command-line builds, or IntelliJ IDEA's Maven integration.

JUnit 5.11.0 is configured as a test dependency in `pom.xml`.

## Run in IntelliJ IDEA
1. Open the project and load it as a Maven project.
2. Set the project SDK to JDK 26.
3. Reload the Maven project if prompted.
4. Open `src/main/java/com/productivity/Main.java` and run its `main` method.

## Build and test from the terminal
With Maven installed, run these commands from the project root:

```sh
mvn compile
mvn test
java -cp target/classes com.productivity.Main
```

The test classes are currently empty, so `mvn test` does not yet verify application
behavior.

## Planned work

- Define task and category data.
- Implement task operations and input validation.
- Choose and implement task storage.
- Build the task screen and dashboard.
- Add tests for task behavior, validation, and storage.
