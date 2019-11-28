package lab3.service;

import lab3.model.Card;
import lab3.model.BankAccount;

import java.util.Comparator;
import java.util.TreeSet;
import java.util.SortedSet;

public class BankAccountService {
    private BankAccount bankAccount;

    public  BankAccountService(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public long countCardType(Card.CardType cardType) {
        return bankAccount.getCards().stream()
                .filter(c -> c.getType().equals(cardType))
                .count();
    }

    public SortedSet<Card> sortCardsByNumber() {
        SortedSet<Card> sortedCards = new TreeSet<>((a, b) -> b.compareTo(a));
        sortedCards.addAll(bankAccount.getCards());
        return sortedCards;
    }

    public SortedSet<Card> sortCardsByCurrency() {
        SortedSet<Card> sortedCards = new TreeSet<>(Comparator.comparing(Card::getCurrency));
        sortedCards.addAll(bankAccount.getCards());
        return sortedCards;
    }


    public boolean isExistCardByCurrency(String currency) {
        BankAccount result = new BankAccount();
        bankAccount.getCards().stream()
                .filter(c -> c.getCurrency().equalsIgnoreCase(currency))
                .forEach(result::addCard);

        return !result.getCards().isEmpty();
    }

}

