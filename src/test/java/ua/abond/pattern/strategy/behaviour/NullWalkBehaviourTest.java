package ua.abond.pattern.strategy.behaviour;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class NullWalkBehaviourTest {
    @Test
    public void testPrintNothing() {
        OutputStream os = new ByteArrayOutputStream();
        System.setOut(new PrintStream(os));
        new NullWalkBehaviour().walk();

        assertEquals("", os.toString());
    }
}