package dk.zentoc.jackson;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class CookieMixin {
    @JsonCreator
    public CookieMixin(@JsonProperty("name") String name,
                       @JsonProperty("value") String value) {}
}