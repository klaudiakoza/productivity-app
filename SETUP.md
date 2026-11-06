# Productivity App — Setup Guide

## How We Will Work on This Project

We will use **IntelliJ IDEA** to write, edit, and organize our application code, and its **built-in Terminal** to run Git commands. You do not need a separate Terminal application.

This guide walks you through cloning the shared repository, then using Git to collaborate:

- **Clone:** Download the entire project and connect your local folder to our GitHub repository.
- **Pull:** Download and integrate teammates' latest changes before starting work.
- **Stage and commit:** Select your changes and save them locally in Git.
- **Push:** Upload your commits to GitHub so teammates can download them.

## Contents

- [Prerequisites](#1-prerequisites)
- [Clone the repository](#2-clone-the-repository)
- [Everyday Git commands](#3-everyday-git-commands)
- [Useful Git commands](#4-useful-git-commands)
- [Important team guidelines](#5-important-team-guidelines)

---

## 1. Prerequisites

Before getting started, make sure you have:

- Git installed.
- IntelliJ IDEA installed.
- Access to our GitHub repository as a collaborator.
- A GitHub account.

### Check if Git is installed

Open the built-in IntelliJ Terminal (usually located on the bottom left) and run:

```sh
git --version
```

If Git is installed, you should see a version number, for example:

```text
git version 2.39.5
```

Your version number may be different.
You can now skip to step 2, which is cloning the repository.

### If Git is not installed

IntelliJ IDEA's built-in Terminal uses your computer's installed command-line tools. It does not include Git, so Git must be installed separately.
If the git command is not recognized, follow the instructions for your operating system.

#### macOS

1. Open **Terminal** from **Applications → Utilities**, or use IntelliJ's built-in terminal.
2. Run the following command to install Apple's Command Line Tools, which include Git:

   ```sh
   xcode-select --install
   ```

3. Follow the installation prompts and wait for installation to finish.
4. Open a new terminal tab and verify the installation:

   ```sh
   git --version
   ```

See the [official Git installation instructions for macOS](https://git-scm.com/install/mac) for other installation options.

#### Windows

1. Open the [official Git for Windows download page](https://git-scm.com/install/windows) and download the installer for your computer.
2. Run the installer and follow the setup prompts.
3. When asked how Git should be used from the command line, choose **Git from the command line and also from 3rd-party software** so IntelliJ's terminal can find it. Keep the defaults for the other options unless you need a specific setting.
4. After installation, close and reopen IntelliJ IDEA so it picks up the updated `PATH`.
5. Open IntelliJ's built-in terminal and verify the installation:

   ```sh
   git --version
   ```

Once a Git version number appears, continue with cloning the repository below.

---

## 2. Clone the Repository

Each team member needs to download their own local copy of the shared GitHub repository.

### Step 1: Create a folder for your projects

Create a folder wherever you prefer on your computer.

For example:

**Windows:**

```text
C:\Users\YourName\School\CS1012FinalProject
```

**macOS:**

```text
/Users/YourName/School/CS1012FinalProject
```

> **Important:** The parent folder can have any name and be located anywhere on your computer. It does not have to match anyone else’s folder structure.

### Step 2: Open IntelliJ IDEA

1. Open IntelliJ IDEA.
2. Select **File → Open**.
3. Select the folder you just created (e.g., `CS1012FinalProject`).
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

---

## 3. Everyday Git Commands

Run these commands in IntelliJ's built-in Terminal from the `productivity-app` project folder. File paths below are relative to that folder.

### Step 1: Pull the latest changes

Before starting work, download and integrate the latest changes from GitHub:

```sh
git pull origin main
```

### Step 2: Create or edit your files

Write your code in IntelliJ IDEA. To create a new file, use **File → New...**; to edit an existing file, open it in the editor. Save your changes before staging them.
In Terminal, type:

``` sh
git add path/to/created-file
```

For example, if you created a new class in repository package and want to stage it, your Terminal command would look like this
```sh
git add src/main/java/com/productivity/repository/(Class_Name).java
```

#### Optional: Remove code or a file

To remove part of a file, delete the unwanted code in IntelliJ and save the file. Stage it like any other edit in Step 3.

To remove an entire file, right-click it in IntelliJ's Project panel and select **Delete**. Then stage the deletion using its original path:

```sh
git add path/to/deleted-file
```

Replace `path/to/deleted-file` with the file's actual path relative to the project folder.

Alternatively, if the file is tracked by Git and you have not deleted it yet, this command deletes it and stages the removal in one step:

```sh
git rm path/to/file
```

Run `git status` to review the staged deletion, then follow Steps 4 and 5 to commit and push it. Teammates receive the removal when they pull your changes.

### Step 3: Stage your changes

Staging selects the changes to include in your next commit. Use the same command for a new or edited file:

```sh
git add src/main/java/com/productivity/model/Task.java
```

To stage multiple specific files, separate their paths with spaces, without commas:

```sh
git add src/main/java/com/productivity/Main.java src/main/java/com/productivity/model/Task.java
```

Alternatively, stage all new, modified, and deleted files under the current directory:

```sh
git add .
```

> **Tip:** Stage individual files if other files contain incomplete work. You can run `git add` multiple times before committing; you do not need to stage every small edit as you make it.

Match each file name's capitalization. For example, to stage this guide:

```sh
git add SETUP.md
```

### Step 4: Commit changes locally

A commit saves your staged changes in Git. Commit when you finish a working unit of code that passes basic checks, such as a bug fix, a completed method, or a working feature.

```sh
git commit -m "Describe your changes here"
```

Use a meaningful message, such as `"Updated TaskRepository"`. One commit can include all the files you staged for that unit of work; you do not need a separate commit for every file.

For example, if you updated `Task.java` and `Category.java` in the `model` package and `TaskRepository.java` in the `repository` package, stage the related changes and commit them together:

```sh
git add src/main/java/com/productivity/model/Task.java
git add src/main/java/com/productivity/model/Category.java
git add src/main/java/com/productivity/repository/TaskRepository.java

git commit -m "Added task management functionality"
```

### Step 5: Push changes to GitHub

Upload your local commits so teammates can download them:

```sh
git push origin main
```

Push at the end of your coding session, or sooner when teammates need your changes.

Think of the process like packing a basket:

- **`git add`:** Put changes into a basket.
- **`git commit`:** Close the basket and save it as one package.
- **`git push`:** Send that package to GitHub.

---

## 4. Useful Git Commands

| Command | When to use it | Purpose |
| --- | --- | --- |
| `git status` | Before staging or committing | Check the current state of your files. |
| `git pull origin main` | Before starting work | Download and integrate the team's latest changes. |
| `git add path/to/file` | When a change is ready to commit | Select a file's changes for your next commit. |
| `git add .` | When all changes under the current directory are ready | Stage new, modified, and deleted files. |
| `git commit -m "message"` | After staging a working unit of code | Save a local commit with a meaningful message. |
| `git push origin main` | When ready to share your commits | Upload your local commits to GitHub. |
| `git log --oneline` | When reviewing project history | View recent commits. |
| `git branch` | When checking branches | View local branches. |

---

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

Happy coding!
