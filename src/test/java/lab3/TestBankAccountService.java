package lab3;

import lab3.model.BankAccount;
import lab3.model.Card;
import lab3.service.BankAccountService;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.*;

public class TestBankAccountService {

    private BankAccountService bankAccountService;
    private BankAccount bankAccount;
    private Card card1;
    private Card card2;
    private Card card3;
    private Card card4;

    {
        card1 = new Card.Builder()
                .cardNumber(225564235)
                .pin(2432)
                .type(Card.CardType.PAYMENT)
                .currency("USD")
                .balance(2454)
                .build();

        card2 = new Card.Builder()
                .cardNumber(923790937)
                .pin(9374)
                .type(Card.CardType.PREPAID)
                .currency("UAH")
                .balance(9823776)
                .build();

        card3 = new Card.Builder()
                .cardNumber(987345256)
                .pin(0217)
                .type(Card.CardType.CREDIT)
                .currency("EU")
                .balance(1004)
                .build();

        card4 = new Card.Builder()
                .cardNumber(390847877)
                .pin(8462)
                .type(Card.CardType.DEBIT)
                .currency("UAH")
                .balance(243454)
                .build();
    }

    @BeforeMethod
    public void createBankAccount() {
        bankAccount = new BankAccount();
    }

    @BeforeMethod
    public void createBankAccountService() {
        bankAccountService = new BankAccountService(bankAccount);
    }

    @Test
    public void sortCardsByNumber() {
        bankAccount.addCard(card2);
        bankAccount.addCard(card1);

        SortedSet<Card> actual = bankAccountService.sortCardsByNumber();
        SortedSet<Card> expected = new TreeSet<>();
        expected.add(card1);
        expected.add(card2);

        Assert.assertEquals(expected, actual, "Cards aren't sorted");
    }

    @Test
    public void sortCardsByCurrency() {
        bankAccount.addCard(card3);
        bankAccount.addCard(card4);

        SortedSet<Card> actual = bankAccountService.sortCardsByCurrency();
        SortedSet<Card> expected = new TreeSet<>();
        expected.add(card3);
        expected.add(card4);
        Assert.assertEquals(expected, actual, "Cards aren't sorted");
    }

    @Test
    public void countCardTypeTest() {
        bankAccount.addCard(card2);
        bankAccount.addCard(card3);

        long expected = 1;
        long actual = bankAccountService.countCardType(Card.CardType.CREDIT);
        Assert.assertEquals(expected, actual, "Invalid number of cards type");
    }

    @Test
    public void searchCardsByCurrency() {
        bankAccount.addCard(card1);
        bankAccount.addCard(card3);

        Assert.assertTrue(bankAccountService.isExistCardByCurrency("USD"),"This currency doesn't exist");
    }
}
