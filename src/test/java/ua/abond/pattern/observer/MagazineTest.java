package ua.abond.pattern.observer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MagazineTest {

    @Test(expected = NullPointerException.class)
    public void testConstructorNullArgument() {
        new Magazine(null);
    }

    @Test
    public void testConstructor() {
        String name = "Play";
        Magazine magazine = new Magazine(name);
        assertEquals(name, magazine.getName());
    }
}