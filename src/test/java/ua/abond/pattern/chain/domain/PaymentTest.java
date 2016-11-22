package ua.abond.pattern.chain.domain;

import org.junit.Test;

public class PaymentTest {

    @Test(expected = IllegalArgumentException.class)
    public void testNegativePrice() {
        new Payment(-1, false, null);
    }

    @Test(expected = NullPointerException.class)
    public void testTypeNull() {
        new Payment(100, false, null);
    }
}