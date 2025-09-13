package dk.zentoc;


import com.microsoft.playwright.Page;
import com.microsoft.playwright.TimeoutError;


public class Utils {
    public static boolean waitForUrl(String urlToWaitFor, Page page) {

        do {
            try {
                System.out.println("awaiting url");
                page.waitForURL(urlToWaitFor);
                System.out.println("url changed");
                return true;
            } catch (TimeoutError ignored) {
            }
        } while (true);
    }
}

