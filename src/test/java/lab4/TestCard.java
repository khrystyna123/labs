package lab4;

import lab4.model.Card;
import org.testng.annotations.Test;

public class TestCard {

    @Test(expectedExceptions = IllegalStateException.class)
    public void testBuilder() {
        Card card = new Card.Builder()
                .setCardNumber(2836249)
                .setCurrency(Card.Currency.EU)
                .setBalance(199.6)
                .build();
    }

    @Test
    public void testMinBalanceValidator() {
        Card card = new Card.Builder()
                .setCardNumber(287636249)
                .setPin(4432)
                .setType(Card.CardType.DEBIT)
                .setCurrency(Card.Currency.EU)
                .setBalance(199.6)
                .build();
    }

    @Test(expectedExceptions = IllegalStateException.class)
    public void testMinBalanceValidatorNegative() {
        Card card = new Card.Builder()
                .setCardNumber(397897)
                .setPin(423)
                .setType(Card.CardType.DEBIT)
                .setCurrency(Card.Currency.USD)
                .setBalance(-100)
                .build();
    }

}
