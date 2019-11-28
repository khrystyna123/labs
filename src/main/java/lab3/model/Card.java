package lab3.model;

import java.util.Objects;

public class Card implements Comparable<Card> {

    public enum CardType {
        PAYMENT,
        CREDIT,
        DEBIT,
        PREPAID
    }

    private long cardNumber;

    private long pin;

    private CardType type;

    private String currency;

    private long balance;

    @Override
    public int compareTo(Card card) {
        return Long.compare(cardNumber, card.cardNumber);
    }

    public static class Builder {
        private long cardNumber;

        private long pin;

        private CardType type;

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

        public Builder type(CardType cardType) {
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
        return type.equals(card.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
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

    public long getCardNumber() {
        return cardNumber;
    }

    public long getPin() {
        return pin;
    }

    public CardType getType() {
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