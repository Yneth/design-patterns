package ua.abond.pattern.abstractfactory.factory;

public enum Language {
    UKRAINIAN("ua/"),
    ENGLISH("en/");

    private final String path;

    Language(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
