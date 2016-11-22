package ua.abond.pattern.chain;

import ua.abond.pattern.chain.domain.*;

public class ControllingPaymentHandler extends PaymentHandler {

    public ControllingPaymentHandler() {
    }

    public ControllingPaymentHandler(PaymentHandler next) {
        super(next);
    }

    @Override
    protected void doHandle(Payment payment) {
        if (payment.getType() == PaymentType.INTRABANK) {
            return;
        }

        if (!payment.isAuthorized()) {
            allowNext = false;
        }
    }
}
