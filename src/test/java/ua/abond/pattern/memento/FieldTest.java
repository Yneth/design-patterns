package ua.abond.pattern.memento;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class FieldTest {

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFirstArgumentNegative() {
        new Field().set(-1, -1, 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFirstArgumentTooBig() {
        new Field().set(10, -1, 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSecondArgumentNegative() {
        new Field().set(0, -1, 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSecondArgumentTooBig() {
        new Field().set(0, 10, 1);
    }

    @Test
    public void testDoesNotReferToTheSameArray() {
        Field field = new Field();
        Field.Memento memento = field.createMemento();

        field.set(0, 0, 1);
        Field.Memento memento1 = field.createMemento();

        assertFalse(Arrays.equals(memento.getCells(), memento1.getCells()));
    }

    @Test
    public void testMementoRestoresPreviousState() {
        Field field = new Field();
        Field.Memento memento = field.createMemento();
        field.set(0, 0, 1);

        field.restore(memento);
        assertTrue(Arrays.equals(memento.getCells(), field.createMemento().getCells()));
    }
}