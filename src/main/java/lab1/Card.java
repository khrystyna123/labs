package lab1;

import java.util.Objects;

public class Card {
    private long cardNumber;

    private long pin;

    private String type;

    private String currency;

    private long balance;

    public static class Builder {
        private long cardNumber;

        private long pin;

        private String type;

        private String currency;

        private long balance;

        public Builder cardNumber(long ownersCard) {
            this.cardNumber = ownersCard;
            return this;
        }

        public Builder pin(long pinCard) {
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

        public Builder balance(long cardBalance) {
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

    public long getBalance() {
        return this.balance;
    }

    public void withdraw(long amount) {
        this.balance -= amount;
    }

    public void deposit(long amount) {
        this.balance += amount;
    }
}