package dk.zentoc;


import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.options.Cookie;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.zip.DataFormatException;

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
        return new LectioSession(playwright, browser, context, page, schoolId);
    }

    public LectioSession lectioSessionFromCookies(String schoolId, List<Cookie> cookies) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();
        context.addCookies(cookies);
        Page page = context.newPage();
        String standardUrl = String.format("https://www.lectio.dk/lectio/%s/SkemaNy.aspx", schoolId);
        page.navigate(standardUrl);
        if (page.url().equals(standardUrl)) {
         return new LectioSession(playwright, browser, context, page, schoolId);
        }
        return null;
    }

    public LectioSession lectioSessionFromFile(Path jsonFile) throws IOException, DataFormatException {
        LectioSessionDataService service = new LectioSessionDataService();
        LectioSessionData data = service.loadFromFile(jsonFile);
        return lectioSessionFromCookies(data.getSchoolId(), data.getCookies());
    }


}

