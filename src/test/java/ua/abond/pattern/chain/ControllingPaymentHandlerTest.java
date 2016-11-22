package ua.abond.pattern.chain;

import org.junit.Test;
import ua.abond.pattern.chain.domain.Payment;
import ua.abond.pattern.chain.domain.PaymentType;

import java.lang.reflect.Field;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class ControllingPaymentHandlerTest {

    @Test
    public void doHandleCasual() throws Exception {
        Payment payment = new Payment(100, false, PaymentType.CASUAL);
        PaymentHandler paymentHandler = new ControllingPaymentHandler();
        paymentHandler.handle(payment);

        assertFalse(getAllowNext(paymentHandler));
    }

    @Test
    public void doHandleIntrabank() throws Exception {
        Payment payment = new Payment(100, false, PaymentType.INTRABANK);
        PaymentHandler paymentHandler = new ControllingPaymentHandler();
        paymentHandler.handle(payment);

        assertTrue(getAllowNext(paymentHandler));
    }

    private boolean getAllowNext(PaymentHandler paymentHandler) throws Exception {
        Field allowNext = PaymentHandler.class.getDeclaredField("allowNext");
        allowNext.setAccessible(true);
        return (boolean) allowNext.get(paymentHandler);
    }
}