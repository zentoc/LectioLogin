package dk.zentoc;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

public class SessionRunner {
    private final ObjectMapper mapper = new ObjectMapper();
    private final LectioLogin lectioLogin = new LectioLogin();

    @SneakyThrows
    public LectioSession initSession(String json) {
        LectioSession lectioSession;
        LectioSessionData sessionData =  mapper.readValue(json, LectioSessionData.class );
        lectioSession = lectioLogin.lectioSessionFromCookies(sessionData.getSchoolId(), sessionData.getCookies());
        if (lectioSession == null) {
            lectioLogin.loginLectio(sessionData.getSchoolId());
        }
        return lectioSession;
    }
}
