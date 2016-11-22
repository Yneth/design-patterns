package ua.abond.pattern.chain;

import ua.abond.pattern.chain.domain.*;

public class FixingPaymentHandler extends PaymentHandler {

    public FixingPaymentHandler() {
    }

    public FixingPaymentHandler(PaymentHandler next) {
        super(next);
    }

    @Override
    protected void doHandle(Payment payment) {
        checkPrice(payment);
    }

    private void checkPrice(Payment payment) {
        if (payment.getPrice() < 0) {
            throw new IllegalStateException("Price cannot be less than zero.");
        }
    }
}
