package dk.zentoc;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.microsoft.playwright.options.Cookie;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class LectioSessionData {
    private String schoolId;
    private List<Cookie> cookies;
}
