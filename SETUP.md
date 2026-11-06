# Productivity App — Setup Guide

Use this guide to set up your local project and collaborate on the code by
integrating GitHub with IntelliJ IDEA.

You will **clone** the existing repository. Cloning automatically downloads the
entire project onto your computer and connects the local folder to our shared
GitHub repository.

This guide also explains which terminal commands to use when you make changes:
**stage** your files, **commit** your changes, and **push** them to GitHub so your
teammates can see and download your updates. It also shows how to **pull** your
teammates' latest changes before you start working.

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

Open the built-in IntelliJ Terminal (located on the bottom left) and run:

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

---

## 3. Everyday Git Commands

> **Important:** Always synchronize your local repository before starting work.

### Before making changes

Download the latest changes from GitHub:

```sh
git pull origin main
```

This command is very important as it ensures you are working on the code that's up to date.

### After making changes

#### 1. Stage files

**Option 1: Create a new file.**

If you want to create a new file, you will do so using **File --> New...** in your IntelliJ IDEA menu.sh
Then, in your built in IntelliJ IDEA terminal, stage your changes using
`git add` followed by the file's name that you just created:

```sh
git add <file_name>
```

For example, if you just created a new class called `Task.java`:

```sh
git add Task.java
```

**Option 2: Edit an existing file.**

The same Git command is used when making changes in your files.
For example, if you just finished coding in `Main.java`, you would type this in your Intelli terminal:

```sh
git add Task.java
```

> **Note:** You do not have to do `add` after every little change you make. Think of it as working on a unit of code, completing some tasks within a file.
> You can also stage (apply changes) to multiple files you worked on.

**Stage multiple specific files:**

```sh
git add Main.java Task.java
```

**Stage all changes at once:**

```sh
git add .
```

This stages all new, modified, and deleted files within the current directory and its subdirectories.

> **Tip:** If other files contain incomplete work, stage individual files instead of using `git add .`.
> Staging individual files is generally recommended for a more organized work.

> `add` is case sensitive. Make sure to match the file name's capitalization when staging changes. For a file named `SETUP.md`, enter:
>
> ```sh
> git add SETUP.md
> ```

> **Important:** You can run `git add` multiple times before creating a **commit**. You do not need a separate `git commit -m` for every file.
> Once you've staged everything you want to include in GitHub, create one commit in the next step.

#### 2. Commit changes locally

A commit saves your staged changes in Git.
Once you made changes to your code, save them as a local commit:

```sh
git commit -m "Describe your changes here"
```

For example, if you made changes to TaskRepository.java, your commit would look something like this:

```sh
git commit -m "Updated TaskRepository"
```

**When to commit:** Commit whenever you finish a working unit of code, such as a
bug fix, a completed method, or a working feature. A commit can include changes
across multiple files. You can make multiple changes, stage them all, and then create one single commit.

For example, if you edited the following files, stage them individually
(these file names are examples):

```sh
git add Category.java
git add Task.java
git add User.java
```

Then commit everything together:

```sh
git commit -m "Added categories, task list, and user info"
```

You can stage multiple files individually and include all of them in a single commit.

#### 3. Push changes to GitHub

Upload your local commits to the shared repository:

```sh
git push origin main
```

Your changes are now uploaded to GitHub and available to the rest of the team.

#### Suggested workflow

- **Stage and commit:** Whenever a specific task works and passes basic checks.
- **Push:** At the end of your coding session, or sooner when teammates need your changes.

Think of the process like packing a basket:

- **`git add`:** Put changes into a basket.
- **`git commit`:** Close the basket and save it as one package.
- **`git push`:** Send that package to GitHub.

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

---

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

- `git push` uploads your changes.
- `git pull` downloads and integrates other people’s changes.

Happy coding!
