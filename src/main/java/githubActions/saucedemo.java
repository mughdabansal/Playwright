package githubActions;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class saucedemo {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch( new BrowserType.LaunchOptions().setHeadless(false));
        //recording video
        BrowserContext context = browser.newContext(
                new Browser.NewContextOptions().setRecordVideoDir(Paths.get("videos/"))
        );

        //tracing
        context.tracing().start( new Tracing.StartOptions().setScreenshots(true) );

        Page page = context.newPage();

        page.navigate("https://www.saucedemo.com/");
        String currentUrl = page.url();
        System.out.println("current url : "+currentUrl);

        String title = page.title();
        System.out.println("page tittle : "+title);

        if (currentUrl.equals("https://www.saucedemo.com/")) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
        page.fill("#user-name", "standard_user");
        page.fill("#password", "secret_sauce");

        page.click("#login-button");

        page.waitForLoadState();

        if(page.url().contains("inventory.html")) {
            System.out.println("successfully logged in!");
        }
        else{
            System.out.println("Login Failed");
        }
        //screenshot
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("saucedemoscreenshot.png")));
        // STOP TRACING
        context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("saucedemotrace.zip")));
        context.close();
        browser.close();


    }
}
