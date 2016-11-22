package ua.abond.pattern.strategy.behaviour;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

public class FeetWalkBehaviourTest {

    @Test
    public void testWalk() {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        new FeetWalkBehaviour().walk();
        assertTrue(FeetWalkBehaviour.class.getSimpleName().equals(os.toString().trim()));
    }
}