package lab5.model;

import lab1.BankAccount;

import java.util.ArrayList;
import java.util.Objects;

public class Owner {
    private Long id;

    private String owner;

    private String password;

    private String type;

    private ArrayList<BankAccount> bankAccounts;

    public static class Builder {
        private Long id;

        private String owner;

        private String password;

        private String type;

        public Builder setId(Long ownerId) {
            this.id = ownerId;
            return this;
        }

        public Builder setOwner(String accountOwner) {
            this.owner = accountOwner;
            return this;
        }

        public Builder setPassword(String accountPassword) {
            this.password = accountPassword;
            return this;
        }

        public Builder setType(String accountType) {
            this.type = accountType;
            return this;
        }

        public Owner build() {
            Owner owner = new Owner();

            owner.id = this.id;

            owner.owner = this.owner;

            owner.password = this.password;

            owner.type = this.type;

            return owner;
        }
    }

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

    public Long getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public String getPassword() {
        return password;
    }

    public String getType() {
        return type;
    }

    public ArrayList<BankAccount> getBankAccounts() {
        return bankAccounts;
    }
}