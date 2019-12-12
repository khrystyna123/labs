package lab5.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lab4.validation.MinBalance;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@JsonDeserialize(builder = Card.Builder.class)
public class Card implements Serializable {

    public enum CardType {
        PAYMENT,
        CREDIT,
        DEBIT,
        PREPAID
    }

    public enum Currency {
        USD,
        UAH,
        EU
    }

    private Long id;

    @NotNull(message = "can't be null")
    @Digits(integer = 9, fraction = 0, message = "card number should have 9 digits")
    private long cardNumber;

    @NotNull(message = "can't be null")
    @Digits(integer = 4, fraction = 0, message = "pin should have 4 digits")
    private long pin;

    @NotNull(message = "can't be null")
    @NotEmpty(message = "can't be empty")
    private CardType type;

    @NotNull(message = "can't be null")
    @NotEmpty(message = "can't be empty")
    private Currency currency;

    @NotNull(message = "can't be null")
    @MinBalance(value = 0, message = "balance can't be negative")
    @Max(value = 100000000, message = "balance can't be more than 1000000000")
    private double balance;

    private Card() {}

    public long getCardNumber() {
        return cardNumber;
    }

    public long getPin() {
        return pin;
    }

    public CardType getType() {
        return type;
    }

    public Currency getCurrency() {
        return currency;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardNumber=" + cardNumber +
                ", pin=" + pin +
                ", type=" + type +
                ", currency=" + currency +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return cardNumber == card.cardNumber &&
                pin == card.pin &&
                Double.compare(card.balance, balance) == 0 &&
                type == card.type &&
                currency == card.currency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber, pin, type, currency, balance);
    }

    @JsonPOJOBuilder(withPrefix = "set")
    public static class Builder {
        Card card;

        public Builder() {
            Card card = new Card();
        }

        public Builder setId(long id) {
            card.id = id;
            return this;
        }

        public Builder setCardNumber(long cardNumber) {
            card.cardNumber = cardNumber;
            return this;
        }

        public Builder setPin(long pin) {
            card.pin = pin;
            return this;
        }

        public Builder setType(CardType type) {
            card.type = type;
            return this;
        }

        public Builder setCurrency(Currency currency) {
            card.currency = currency;
            return this;
        }

        public Builder setBalance(double balance) {
            card.balance = balance;
            return this;
        }

        public Card build() throws IllegalStateException {
            Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<Card>> constraintViolations = validator.validate(card);

            if (constraintViolations.size() > 0) {
                Set<String> exceptionDetails = new HashSet<>();
                for (ConstraintViolation<Card> violation : constraintViolations) {
                    exceptionDetails.add(violation.getPropertyPath().toString() + " " + violation.getMessage());
                }
                throw new IllegalStateException(exceptionDetails.toString());
            }
            return card;
        }
    }

    public Long getId() {
        return id;
    }
}