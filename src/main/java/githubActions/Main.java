package githubActions;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        //recording video
        BrowserContext context = browser.newContext(
                new Browser.NewContextOptions().setRecordVideoDir(Paths.get("videos/"))
        );
        //tracing
        context.tracing().start( new Tracing.StartOptions().setScreenshots(true) );

        Page page = context.newPage();
        page.navigate("https://www.google.com");

        //screenshot
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshot.png")));

        System.out.println(page.title());

        // STOP TRACING
        context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("trace.zip")));
        context.close();
        browser.close();

    }

}