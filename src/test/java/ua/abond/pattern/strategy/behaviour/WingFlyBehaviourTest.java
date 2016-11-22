package ua.abond.pattern.strategy.behaviour;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

public class WingFlyBehaviourTest {

    @Test
    public void testFly() {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        new WingFlyBehaviour().fly();
        assertTrue(WingFlyBehaviour.class.getSimpleName().equals(os.toString().trim()));
    }

}