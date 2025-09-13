package dk.zentoc;


import com.microsoft.playwright.Page;
import com.microsoft.playwright.TimeoutError;


public class Utils {
    public static boolean waitForUrl(String urlToWaitFor, Page page) {

        do {
            try {
                page.waitForURL(urlToWaitFor);
                return true;
            } catch (TimeoutError ignored) {
            }
        } while (true);
    }
}

