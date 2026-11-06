# Productivity App — Setup Guide

Use this guide to set up your local project and work with the team through GitHub.

## Contents

- [Prerequisites](#1-prerequisites)
- [Clone the repository](#2-clone-the-repository)
- [Everyday Git commands](#3-everyday-git-commands)
- [Useful Git commands](#4-useful-git-commands)
- [Important team guidelines](#5-important-team-guidelines)

## 1. Prerequisites

Before getting started, make sure you have:

* Git installed.
* IntelliJ IDEA installed.
* Access to our GitHub repository as a collaborator.
* A GitHub account.

### Check if Git is installed

Open the built-in IntelliJ Terminal and run:

```sh
git --version
```

If Git is installed, you should see a version number, for example:

```text
git version 2.39.5
```

Your version number may be different.

### If Git is not installed

If the command is not recognized or prompts you to install developer tools,
follow the instructions for your operating system below.

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
> Make sure you copy the correct path.

### Step 2: Open IntelliJ IDEA

1. Open IntelliJ IDEA.
2. Select **Open**.
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

## 3. Everyday Git Commands

> **Important:** Always synchronize your local repository before starting work.

### Before making changes

Download the latest changes from GitHub:

```sh
git pull origin main
```

### After making changes: stage files

After you create a new file or edit an existing one, stage your changes using
`git add` followed by the file's path relative to the project root:

```sh
git add path/to/file
```

For example, after editing `Main.java`:

```sh
git add src/main/java/com/productivity/Main.java
```

The same command works for a new or edited file, such as `Task.java`:

```sh
git add src/main/java/com/productivity/model/Task.java
```

Stage multiple specific files:

```sh
git add src/main/java/com/productivity/Main.java src/main/java/com/productivity/model/Task.java
```

Stage all changes under the current directory, including new, modified, and deleted files:

```sh
git add .
```

> **Tip:** If other files contain incomplete work, stage individual files instead of using `git add .`.

### Commit changes locally

Save your staged changes as a local commit:

```sh
git commit -m "Describe your changes here"
```

**When to commit:** Commit whenever you finish a working unit of code, such as a
bug fix, a completed method, or a working feature. A commit can include changes
across multiple files.

### Push changes to GitHub

Upload your local commits to the shared repository:

```sh
git push origin main
```

Your changes are now uploaded to GitHub and available to the rest of the team.

#### Suggested workflow

- **Stage and commit:** Whenever a specific task works and passes basic checks.
- **Push:** At the end of your coding session, or sooner when teammates need your changes.

#### Quick cheat sheet

| Command | When to use it | Purpose |
| --- | --- | --- |
| `git pull origin main` | Before starting work | Download and integrate the team's latest changes. |
| `git add path/to/file` | When a change is ready to commit | Select the changes to include in your next commit. |
| `git commit -m "message"` | After staging a working unit of code | Save a local commit with a meaningful message. |
| `git push origin main` | When ready to share your commits | Upload your local commits to GitHub. |

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
