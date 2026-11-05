# Productivity App — Team Setup Guide

A collaborative productivity application developed by our team of three.

## 1. Prerequisites

Before getting started, make sure you have:

* Git installed.
* IntelliJ IDEA installed.
* Access to our GitHub repository as a collaborator.
* A GitHub account.

## 2. Clone the Repository

Each team member needs to download their own local copy of the shared GitHub repository.

### Step 1: Create a folder for your projects

Create a folder wherever you prefer on your computer.

For example:

**Windows:**

```text
C:\Users\YourName\project
```

**macOS:**

```text
/Users/YourName/project
```

> **Important:** The parent folder can have any name and be located anywhere on your computer. It does not have to match anyone else’s folder structure.

### Step 2: Open IntelliJ IDEA

1. Open IntelliJ IDEA.
2. Select **Open**.
3. Select the folder you just created (e.g., `project`).
4. Open the built-in **Terminal** at the bottom of IntelliJ.

### Step 3: Clone the repository

In IntelliJ’s built-in Terminal, enter:

```sh
git clone https://github.com/klaudiakoza/productivity-app.git
```

Git will automatically create a folder called `productivity-app` inside your current directory.

### Step 4: Open the application

1. In IntelliJ, select **File → Open**.
2. Navigate to your newly created `productivity-app` folder.
3. Open the folder.
4. If prompted, trust the project.
5. Allow IntelliJ to import the Maven project from `pom.xml` and download dependencies.

The project's source files are organized as follows:

```text
productivity-app/
├── pom.xml
├── README.md
├── SETUP.md
└── src/
    ├── main/
    │   └── java/
    │       └── com/
    │           └── productivity/
    │               ├── Main.java
    │               ├── model/
    │               │   ├── Category.java
    │               │   ├── Task.java
    │               │   └── User.java
    │               ├── repository/
    │               │   └── TaskRepository.java
    │               ├── service/
    │               │   ├── TaskService.java
    │               │   └── TaskValidationService.java
    │               └── ui/
    │                   ├── DashboardPanel.java
    │                   ├── MainFrame.java
    │                   └── TaskPanel.java
    └── test/
        └── java/
            └── com/
                └── productivity/
                    ├── TaskRepositoryTest.java
                    ├── TaskServiceTest.java
                    └── TaskValidationTest.java
```

Your actual folder location may differ.

#### Package responsibilities

The application packages are under `src/main/java/com/productivity/`.
Their intended responsibilities are:

| Package or file | Purpose |
| --- | --- |
| `Main.java` | Starts the application. |
| `model` | Represents application data: tasks, users, and categories. |
| `repository` | Stores and retrieves task data. |
| `service` | Handles task operations and validates task input. |
| `ui` | Contains the application window, dashboard, and task screen. |
| `src/test/java/com/productivity/` | Contains tests for task storage, services, and validation. |
| `pom.xml` | Configures the Java target, dependencies, and Maven build plugins. |

The model, repository, service, UI, and test classes are currently placeholders.
As they are implemented, the intended flow is for the UI to call services and
for services to use repositories. Models represent the data used across these
layers.

### Step 5: Verify your setup

Open IntelliJ’s built-in Terminal and run:

```sh
git status
```

You should see something similar to:

```text
On branch main
Your branch is up to date with 'origin/main'.
nothing to commit, working tree clean
```

You’re ready to start developing!

## 3. Everyday Git Commands

> **Important:** Always synchronize your local repository before starting work.

### Before making changes

Download the latest changes from GitHub:

```sh
git pull origin main
```

### After making changes

Your changes are now uploaded to GitHub and available to the rest of the team.

### When another teammate pushes changes

To download their latest updates:

```sh
git pull origin main
```

## 4. Useful Git Commands

| Command | Purpose |
| --- | --- |
| `git status` | Check the current state of your files |
| `git pull origin main` | Download and integrate the latest changes |
| `git add .` | Stage new, modified, and deleted files under the current directory |
| `git add filename` | Stage a specific file |
| `git commit -m "message"` | Save a commit |
| `git push origin main` | Upload commits to GitHub |
| `git log --oneline` | View recent commits |
| `git branch` | View local branches |

## 5. Important Team Guidelines

To avoid conflicts and keep our project organized:

1. Always run `git pull origin main` before starting work.
2. Communicate with teammates about which files or features you’re working on.
3. Avoid editing the same files simultaneously whenever possible.
4. Write meaningful commit messages.
5. Push your changes regularly.
6. Never delete or overwrite another teammate’s work without communicating first.
7. Do not commit passwords, API keys, or other sensitive information.

> **Remember:** Everyone has their own local copy of the project. GitHub does not automatically synchronize files in real time.

* `git push` uploads your changes.
* `git pull` downloads and integrates other people’s changes.

Happy coding!
