package ua.abond.pattern.strategy.behaviour;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

public class VampireBatFlyBehaviourTest {
    @Test
    public void testFly() throws Exception {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        new VampireBatFlyBehaviour().fly();
        assertTrue(VampireBatFlyBehaviour.class.getSimpleName().equals(os.toString().trim()));
    }

}