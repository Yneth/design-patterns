package ua.abond.pattern.abstractfactory;

import ua.abond.pattern.abstractfactory.factory.Language;

public abstract class Film {
    public static final String SUBTITLE_PATH_PREFIX = "sub/";
    public static final String SOUNDTRACK_PATH_PREFIX = "audio/";

    protected final Language language;

    public Film(Language language) {
        this.language = language;
    }

    public String getSubtitles() {
        return SUBTITLE_PATH_PREFIX + getName() + language.getPath();
    }

    public String getSoundtrackPath() {
        return SOUNDTRACK_PATH_PREFIX + getName() + language.getPath();
    }

    public String getName() {
        return this.getClass().getSimpleName();
    }
}
