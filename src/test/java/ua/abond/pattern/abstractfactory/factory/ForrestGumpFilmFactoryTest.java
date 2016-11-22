package ua.abond.pattern.abstractfactory.factory;

import org.junit.Test;
import ua.abond.pattern.abstractfactory.Film;
import ua.abond.pattern.abstractfactory.ForrestGumpFilm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ForrestGumpFilmFactoryTest {

    @Test(expected = NullPointerException.class)
    public void testExpectedNullPointerOnNullArg() {
        ForrestGumpFilmFactory.getInstance().create(null);
    }

    @Test
    public void createEnglish() throws Exception {
        FilmFactory factory = ForrestGumpFilmFactory.getInstance();

        assertNotNull(factory);
        Film film = factory.create(Language.ENGLISH);
        assertNotNull(film);
        assertEquals("audio/" + ForrestGumpFilm.class.getSimpleName() + "en/", film.getSoundtrackPath());
        assertEquals("sub/" + ForrestGumpFilm.class.getSimpleName() + "en/", film.getSubtitles());
    }

    @Test
    public void createUkrainian() throws Exception {
        FilmFactory factory = ForrestGumpFilmFactory.getInstance();

        assertNotNull(factory);
        Film film = factory.create(Language.UKRAINIAN);
        assertNotNull(film);
        assertEquals("audio/" + ForrestGumpFilm.class.getSimpleName() + "ua/", film.getSoundtrackPath());
        assertEquals("sub/" + ForrestGumpFilm.class.getSimpleName() + "ua/", film.getSubtitles());
    }
}