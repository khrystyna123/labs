package lab1;

import java.util.ArrayList;
import java.util.Objects;

public class Owner {
    private String owner;

    private String password;

    private String type;

    private ArrayList<BankAccount> bankAccounts;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner1 = (Owner) o;
        return Objects.equals(owner, owner1.owner) &&
                Objects.equals(password, owner1.password) &&
                Objects.equals(type, owner1.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, password, type);
    }

    @Override
    public String toString() {
        return "Owner{" +
                "owner='" + owner + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}