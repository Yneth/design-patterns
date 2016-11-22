package ua.abond.pattern.factorymethod;

import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

public class TetrisShapeFactoryTest {

    @Test
    public void testReturnNotNull() throws Exception {
        TetrisShapeFactory instance = TetrisShapeFactory.getInstance();

        assertNotNull(instance.createRandom());
    }

    @Test
    public void testShouldNotThrowOutOfBounds() throws Exception {
        TetrisShapeFactory instance = TetrisShapeFactory.getInstance();

        for (int i = 0; i < 1000; i++) {
            assertNotNull(instance.createRandom());
        }
    }
}