# OrangeHRM Automation with Selenium WebDriver and TestNG

Automated UI tests for the OrangeHRM demo login page `https://opensource-demo.orangehrmlive.com/web/index.php/auth/login`.  
Implemented in Java with Selenium WebDriver, TestNG and Maven. Designed for development on Windows with IntelliJ IDEA.

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Prerequisites (Windows)](#prerequisites-windows)
- [Project Structure](#project-structure)
- [Setup and Run](#setup-and-run)
- [How Tests Work](#how-tests-work)
- [Reports and Artifacts](#reports-and-artifacts)
- [Troubleshooting](#troubleshooting)
- [Contributing](#contributing)
- [License](#license)

## Overview
This project validates the login functionality of the OrangeHRM demo site using automated UI tests. It includes positive and negative test cases, screenshot capture on failures and test reporting via ExtentReports.

## Features
- Positive test: successful login navigates to `/dashboard`.
- Negative tests: invalid credentials, empty username, empty password — verify error and validation messages.
- Screenshots on test failure (saved locally).
- ExtentReports integration for readable test reports.
- Programmatic TestNG runner available in test class `LoginTest`.

## Tech Stack
- Java (JDK 11+ recommended)
- Maven
- Selenium WebDriver
- TestNG
- ExtentReports
- ChromeDriver (Windows)
- IntelliJ IDEA 2025.2.1

## Prerequisites (Windows)
1. Install Java JDK 11 or later and set `JAVA_HOME`.
2. Install Maven and add to `PATH`.
3. Install Google Chrome.
4. Download matching `chromedriver.exe` for your Chrome version and either:
    - place `chromedriver.exe` on system `PATH`, or
    - set system property `webdriver.chrome.driver` in the IntelliJ run configuration.
5. Optional: IntelliJ IDEA configured for Maven projects.

## Project Structure (important files)
- `pom.xml` — Maven build and dependencies.
- `src/test/java/demo/orangehrm/org/base/BaseTest.java` — driver and reporting setup, screenshot capture.
- `src/test/java/demo/orangehrm/org/login/LoginTest.java` — positive and negative login tests and programmatic runner.
- `src/main/java` — page objects (e.g., `LoginPage`) and `BasePage`.
- `resources/screenshots` — screenshots saved on failures.
- `test-output` (or configured report folder in `ExtentManager`) — ExtentReports output (check `ExtentManager` for exact path).

## Setup and Run

1. Clone repository:
    - Open PowerShell and run:
        - `git clone <repository-url>`
2. Open project in IntelliJ IDEA.
3. Ensure `chromedriver.exe` is on `PATH` or set `webdriver.chrome.driver` VM option in run configurations.
4. Run tests:
    - From command line (Maven):
        - `mvn clean test`
    - From IntelliJ:
        - Run TestNG test classes or the programmatic `main` in `LoginTest`.
5. After tests complete, open the ExtentReports output location (configured in `ExtentManager`) and review screenshots in `resources/screenshots`.

## How Tests Work
- `BaseTest` initializes `ChromeDriver`, sets up `BasePage`, navigates to the login URL and integrates ExtentReports.
- Page objects encapsulate element interactions (enter username, enter password, click login).
- Each TestNG method performs actions and asserts expected outcomes (URL, alert text, validation messages).
- On failure, `BaseTest` captures a screenshot and saves it to `resources/screenshots` with the pattern `(<date>)_<testName>.png`.

## Reports and Artifacts
- ExtentReports are initialized via `ExtentManager.getInstance()`; check `ExtentManager` for report file location.
- Failure screenshots: `resources/screenshots/` with test name and date in the filename.
- TestNG default reports are available under `test-output` after Maven runs.

## Troubleshooting
- Browser not found / version mismatch: update `chromedriver.exe` to match installed Chrome.
- Tests fail due to timing: prefer using explicit waits in page objects over fixed sleeps.
- Permission errors saving screenshots: ensure write access to project folder.
- If `ChromeDriver` not found: confirm `chromedriver.exe` is on `PATH` or configured via `webdriver.chrome.driver`.

## Contributing
- Follow the existing package and naming structure.
- Add or update page objects under `src/main/java`.
- Add tests under `src/test/java`.
- Run `mvn clean test` locally before submitting changes.

## License
Add a license file at the repository root (for example `LICENSE`). Specify the desired open source license.
