package ua.abond.pattern.abstractfactory.factory;

import ua.abond.pattern.abstractfactory.Film;
import ua.abond.pattern.abstractfactory.ForrestGumpFilm;

import java.util.Objects;

public class ForrestGumpFilmFactory extends FilmFactory {
    private static final FilmFactory INSTANCE = new ForrestGumpFilmFactory();

    private ForrestGumpFilmFactory() {
    }

    public static FilmFactory getInstance() {
        return INSTANCE;
    }

    @Override
    public Film create(Language language) {
        Objects.requireNonNull(language);
        return new ForrestGumpFilm(language);
    }
}
