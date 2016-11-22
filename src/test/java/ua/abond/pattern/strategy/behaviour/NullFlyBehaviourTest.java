package ua.abond.pattern.strategy.behaviour;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class NullFlyBehaviourTest {

    @Test
    public void testPrintNothing() {
        OutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        new NullFlyBehaviour().fly();

        assertEquals("", os.toString());
    }
}