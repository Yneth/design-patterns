package ua.abond.pattern.abstractfactory.factory;

import ua.abond.pattern.abstractfactory.Film;

public abstract class FilmFactory {
    public abstract Film create(Language language);
}
