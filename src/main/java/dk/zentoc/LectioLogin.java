package dk.zentoc;


import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType;

public class LectioLogin {

    public LectioSession loginLectio(String schoolId) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        String frontPageUrl = String.format("https://www.lectio.dk/lectio/%s/forside.aspx", schoolId);
        page.navigate(frontPageUrl);

        while (!Utils.waitForUrl(frontPageUrl, page)) {
            // Vent på manuelt login
        }
        return new LectioSession(playwright, browser, context, page);
    }
}

