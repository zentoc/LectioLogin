package dk.zentoc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.microsoft.playwright.options.Cookie;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class LectioSessionDataService {
    private final ObjectMapper mapper;
    private final ObjectWriter writer;

    public LectioSessionDataService() {
        this.mapper = new ObjectMapper()
                .enable(SerializationFeature.INDENT_OUTPUT);
        this.mapper.addMixIn(Cookie.class, CookieMixin.class);
        this.writer = mapper.writerFor(LectioSessionData.class);
    }

    public Path saveFromSession(LectioSession session) throws IOException {
        return saveFromSession(session, Paths.get("lectio-session.json"));
    }

    public Path saveFromSession(LectioSession session, Path outputFile) throws IOException {
        if (session == null) throw new IllegalArgumentException("session must not be null");
        LectioSessionData data = toData(session);

        Path parent = outputFile.toAbsolutePath().getParent();
        if (parent != null) {
            Files.createDirectories(parent);
        }

        writer.writeValue(outputFile.toFile(), data);
        return outputFile;
    }

    public Path saveFromData(LectioSessionData sessionData) throws IOException {
        return saveFromData(sessionData, Paths.get("lectio-session-data.json"));
    }

    public Path saveFromData(LectioSessionData sessionData, Path outputFile) throws IOException {
        if (sessionData == null) throw new IllegalArgumentException("sessionData must not be null");

        Path parent = outputFile.toAbsolutePath().getParent();
        if (parent != null) {
            Files.createDirectories(parent);
        }

        writer.writeValue(outputFile.toFile(), sessionData);
        return outputFile;
    }

    public LectioSessionData loadFromFile(Path inputFile) throws IOException, IllegalArgumentException {
        if (inputFile == null) throw new IllegalArgumentException("inputFile must not be null");
        return mapper.readValue(inputFile.toFile(), LectioSessionData.class);
    }
    public LectioSessionData loadFromJson(String json) throws IOException, IllegalArgumentException {
        if (json == null) throw new IllegalArgumentException("inputFile must not be null");
        return mapper.readValue(json, LectioSessionData.class);
    }

    private LectioSessionData toData(LectioSession session) {
        LectioSessionData data = new LectioSessionData();
        data.setSchoolId(session.schoolId());
        data.setCookies(session.context().cookies());
        return data;
    }
}