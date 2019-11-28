package lab3.model;

import java.util.*;

public class BankAccount {
    private Root<BankAccount> root;
    private Node<BankAccount> node;
    private Set<Card> cards;

    {
        cards = new HashSet<Card>();
    }

    public BankAccount(long rootData, String type) {
        root = new Root<BankAccount>();
        root.accountNumber = rootData;
        root.type = type;
        root.children = new ArrayList<Node<BankAccount>>();
    }

    public BankAccount(Card nodeData) {
        node = new Node<BankAccount>();
        node.data = nodeData;
        node.parent = root;
    }

    public BankAccount() {

    }

    public static class Root<T> {
        private long accountNumber;
        private String type;
        private List<Node<T>> children;
    }

    public static class Node<T> {
        private Card data;
        private Root<T> parent;
    }

    public void transfer(BankAccount to, long amount) {
        BankAccount from = this;

        from.node.data.withdraw(amount);
        to.node.data.deposit(amount);
    }

    public Set<Card> getCards() {
        return cards;
    }

    public double getAllCardBalance() {
        double sum = 0;
        for (Card x : cards) {
            sum += x.getBalance();
        }
        return sum;
    }

    public boolean addCard(Card card) {
        cards.add(card);
        return true;
    }

}
