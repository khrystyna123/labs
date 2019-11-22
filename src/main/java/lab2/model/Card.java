package lab2.model;

import java.io.Serializable;
import java.util.Objects;

public class Card implements Serializable {
    private long cardNumber;

    private int pin;

    private String type;

    private String currency;

    private double balance;

    public static class Builder {
        private long cardNumber;

        private int pin;

        private String type;

        private String currency;

        private double balance;

        public Builder cardNumber(long ownersCard) {
            this.cardNumber = ownersCard;
            return this;
        }

        public Builder pin(int pinCard) {
            this.pin = pinCard;
            return this;
        }

        public Builder type(String cardType) {
            this.type = cardType;
            return this;
        }

        public Builder currency(String cardCurrency) {
            this.currency = cardCurrency;
            return this;
        }

        public Builder balance(double cardBalance) {
            this.balance = cardBalance;
            return this;
        }

        public Card build() {
            Card card = new Card();

            card.cardNumber = this.cardNumber;

            card.pin = this.pin;

            card.type = this.type;

            card.currency = this.currency;

            card.balance = this.balance;

            return card;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return cardNumber == card.cardNumber &&
                pin == card.pin;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber, pin);
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardNumber=" + cardNumber +
                ", balance=" + balance +
                ", currency=" + currency +
                '}';
    }

    public double getBalance() {
        return this.balance;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public int getPin() {
        return pin;
    }

    public String getType() {
        return type;
    }

    public String getCurrency() {
        return currency;
    }

    public void withdraw(long amount) {
        this.balance -= amount;
    }

    public void deposit(long amount) {
        this.balance += amount;
    }
}