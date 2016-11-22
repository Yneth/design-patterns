package ua.abond.pattern.chain;

import org.junit.Test;
import ua.abond.pattern.chain.domain.Payment;
import ua.abond.pattern.chain.domain.PaymentType;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FixingPaymentHandlerTest {

    @Test(expected = IllegalStateException.class)
    public void testHandleWithWrongPriceOnPayment() {
        Payment payment = mock(Payment.class);
        when(payment.getPrice()).thenReturn(-100);

        new FixingPaymentHandler().handle(payment);
    }

    @Test
    public void testHandleOk() {
        new FixingPaymentHandler().handle(new Payment(100, false, PaymentType.INTRABANK));
    }
}