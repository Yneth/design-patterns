package ua.abond.pattern.chain;

import ua.abond.pattern.chain.domain.Payment;
import ua.abond.pattern.chain.domain.PaymentType;

public class BankTaxPaymentHandler extends PaymentHandler {

    public BankTaxPaymentHandler() {
    }

    public BankTaxPaymentHandler(PaymentHandler next) {
        super(next);
    }

    @Override
    protected void doHandle(Payment payment) {
        int tax = 0;

        if (payment.getType() == PaymentType.PREFERENTIAL) {
            tax = payment.getPrice() / 32;
        }
        else if (payment.getType() == PaymentType.GOVERNMENT) {
            tax = payment.getPrice() / 16;
        }
        else if (payment.getType() == PaymentType.CASUAL) {
            tax = payment.getPrice() / 8;
        }
        payment.setPrice(payment.getPrice() + tax);
    }
}
