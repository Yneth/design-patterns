package ua.abond.pattern.abstractfactory.factory;

import ua.abond.pattern.abstractfactory.Film;
import ua.abond.pattern.abstractfactory.ShawshankRedemptionFilm;

import java.util.Objects;

public class ShawshankRedemptionFilmFactory extends FilmFactory {
    private static final FilmFactory INSTANCE = new ShawshankRedemptionFilmFactory();

    private ShawshankRedemptionFilmFactory() {
    }

    public static FilmFactory getInstance() {
        return INSTANCE;
    }

    @Override
    public Film create(Language language) {
        Objects.requireNonNull(language);

        return new ShawshankRedemptionFilm(language);
    }
}
