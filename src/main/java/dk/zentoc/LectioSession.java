package dk.zentoc;


import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public record LectioSession(
        Playwright playwright,
        Browser browser,
        BrowserContext context,
        Page page
        ) {

    public void close() {
        browser.close();
        playwright.close();
    }
}
