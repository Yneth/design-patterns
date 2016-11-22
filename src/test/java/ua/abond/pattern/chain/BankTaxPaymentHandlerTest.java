package ua.abond.pattern.chain;

import org.junit.Test;
import ua.abond.pattern.chain.domain.Payment;
import ua.abond.pattern.chain.domain.PaymentType;

import static org.junit.Assert.assertEquals;

public class BankTaxPaymentHandlerTest {

    @Test
    public void testDoHandlePayment() throws Exception {
        Payment payment = new Payment(800, true, PaymentType.CASUAL);
        new BankTaxPaymentHandler().handle(payment);
        assertEquals(900, payment.getPrice());
    }

    @Test
    public void testDoHandleIntrabankPayment() throws Exception {
        Payment payment = new Payment(3333, true, PaymentType.INTRABANK);
        new BankTaxPaymentHandler().handle(payment);
        assertEquals(3333, payment.getPrice());
    }

    @Test
    public void testDoHandlePreferentialPayment() throws Exception {
        Payment payment = new Payment(3200, true, PaymentType.PREFERENTIAL);
        new BankTaxPaymentHandler().handle(payment);
        assertEquals(3300, payment.getPrice());
    }

    @Test
    public void testDoHandleStatePayment() throws Exception {
        Payment payment = new Payment(1600, true, PaymentType.GOVERNMENT);
        new BankTaxPaymentHandler().handle(payment);
        assertEquals(1700, payment.getPrice());
    }

}