package lab1;

import lab2.model.Card;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private Root<BankAccount> root;
    private Node<BankAccount> node;

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
}
