package ua.abond.pattern.chain.domain;

import java.util.Objects;

public class Payment {
    private final PaymentType type;

    private int price;
    private boolean authorized;

    public Payment(int price, boolean authorized, PaymentType type) {
        checkPrice(price);
        Objects.requireNonNull(type);

        this.type = type;
        this.price = price;
        this.authorized = authorized;
    }

    private void checkPrice(int price) {
        if (price < 0) {
            throw new IllegalArgumentException();
        }
    }

    public PaymentType getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        checkPrice(price);
        this.price = price;
    }

    public boolean isAuthorized() {
        return authorized;
    }

    public void setAuthorized(boolean authorized) {
        this.authorized = authorized;
    }
}
