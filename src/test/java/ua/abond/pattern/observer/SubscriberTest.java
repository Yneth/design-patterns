package ua.abond.pattern.observer;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class SubscriberTest {

    @Test(expected = NullPointerException.class)
    public void testReceiveNull() {
        new Subscriber("test").receive(null);
    }

    @Test
    public void testReceive() {
        Subscriber subscriber = new Subscriber("test");
        Magazine times = new Magazine("Times");
        subscriber.receive(times);

        assertTrue(Arrays.asList(times).equals(subscriber.getOwnedMagazines()));
    }
}