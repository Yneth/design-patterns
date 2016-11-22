package ua.abond.pattern.chain;

import ua.abond.pattern.chain.domain.*;

public abstract class PaymentHandler {
    protected PaymentHandler next;
    protected boolean allowNext = true;

    public PaymentHandler() {
        this(null);
    }

    public PaymentHandler(PaymentHandler next) {
        this.next = next;
    }

    public void handle(Payment payment) {
        doHandle(payment);
        if (hasNext() && allowNext)
            next.handle(payment);
    }

    protected abstract void doHandle(Payment payment);

    protected boolean hasNext() {
        return next != null;
    }
}
