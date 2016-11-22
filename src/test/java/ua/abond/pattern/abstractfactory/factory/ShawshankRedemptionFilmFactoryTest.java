package ua.abond.pattern.abstractfactory.factory;

import org.junit.Test;
import ua.abond.pattern.abstractfactory.Film;
import ua.abond.pattern.abstractfactory.ShawshankRedemptionFilm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ShawshankRedemptionFilmFactoryTest {

    @Test(expected = NullPointerException.class)
    public void testExpectedNullPointerOnNullArg() {
        ShawshankRedemptionFilmFactory.getInstance().create(null);
    }

    @Test
    public void createEnglish() throws Exception {
        FilmFactory factory = ShawshankRedemptionFilmFactory.getInstance();

        assertNotNull(factory);
        Film film = factory.create(Language.ENGLISH);
        assertNotNull(film);
        assertEquals("audio/" + ShawshankRedemptionFilm.class.getSimpleName() + "en/", film.getSoundtrackPath());
        assertEquals("sub/" + ShawshankRedemptionFilm.class.getSimpleName() + "en/", film.getSubtitles());
    }

    @Test
    public void createUkrainian() throws Exception {
        FilmFactory factory = ShawshankRedemptionFilmFactory.getInstance();

        assertNotNull(factory);
        Film film = factory.create(Language.UKRAINIAN);
        assertNotNull(film);
        assertEquals("audio/" + ShawshankRedemptionFilm.class.getSimpleName() + "ua/", film.getSoundtrackPath());
        assertEquals("sub/" + ShawshankRedemptionFilm.class.getSimpleName() + "ua/", film.getSubtitles());
    }

}