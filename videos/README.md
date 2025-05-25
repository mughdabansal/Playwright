# 🎭 Playwright Java Automation Project

## 📌 About Playwright

[Playwright](https://playwright.dev/) is a modern end-to-end testing framework developed by Microsoft. It enables fast, reliable, and cross-browser testing for web applications. Playwright supports multiple languages like Java, JavaScript, Python, and C#. It works with Chromium, Firefox, and WebKit, and supports both headless and headed browser modes.

## 📁 Project Overview

This project demonstrates Playwright automation using **Java**, focusing on the website [SauceDemo.com](https://www.saucedemo.com/), a dummy e-commerce site used for testing login functionality.

---

## ✅ Tasks Covered

### 1. **Basic Setup**
- Initialized a Maven-based Java project.
- Added Playwright Java dependency in `pom.xml`.
- Verified installation by running a basic browser script.

### 2. **Open Browser and Navigate to Website**
```java
Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
Page page = browser.newPage();
page.navigate("https://www.saucedemo.com/");
Launched Chromium in non-headless mode.

Navigated to the website and fetched current URL and title.

3. Verify URL and Title
java
Copy
Edit
String currentUrl = page.url();
String title = page.title();
Validated the page URL and title for correctness using basic assertions.

4. Login Functionality Automation
java
Copy
Edit
page.fill("#user-name", "standard_user");
page.fill("#password", "secret_sauce");
page.click("#login-button");
Filled login credentials using Playwright selectors.

Clicked the login button.

Verified if redirected to inventory.html.

5. Capturing Screenshots
java
Copy
Edit
page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("saucedemoscreenshot.png")));
Took a screenshot after login to visually verify success.

6. Video Recording of Test
java
Copy
Edit
BrowserContext context = browser.newContext(
    new Browser.NewContextOptions().setRecordVideoDir(Paths.get("videos/"))
);
Configured video recording for each test session.

Recorded and saved videos in the /videos folder.

7. Trace Collection for Debugging
java
Copy
Edit
context.tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true));
...
context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("saucedemotrace.zip")));
Enabled tracing to capture execution steps, DOM snapshots, and network activity.

Generated saucedemotrace.zip for debugging.

Can be viewed using:

bash
Copy
Edit
npx playwright show-trace saucedemotrace.zip
🛠️ How to Run the Test
Install Dependencies:
Make sure Java (8+) and Maven are installed.

Install Browsers:
Run:

bash
Copy
Edit
mvn exec:java -e -Dexec.mainClass=com.microsoft.playwright.CLI -Dexec.args="install"
Run the Script:

bash
Copy
Edit
mvn exec:java -Dexec.mainClass="githubActions.saucedemo"
📦 Project Structure
css
Copy
Edit
PlaywrightJavaProject/
├── src/
│   └── main/
│       └── java/
│           └── githubActions/
│               └── saucedemo.java
├── videos/
│   └── (video recordings)
├── saucedemoscreenshot.png
├── saucedemotrace.zip
├── pom.xml
└── README.md
🔍 What I Learned
Setting up and configuring Playwright for Java.

Writing end-to-end UI tests using Playwright's intuitive API.

Working with browser context, page elements, and assertions.

Enhancing test quality with screenshots, videos, and trace logs.

Debugging failed tests with visual and trace-based tools.

Automating login workflows and validating navigation.

📌 Future Enhancements
Add JUnit/TestNG integration.

Parameterize credentials.

Build CI integration using GitHub Actions or Jenkins.

Extend tests for product page and checkout flow.

Feel free to clone this project and try it yourself!

Happy Testing! 🧪🎉
