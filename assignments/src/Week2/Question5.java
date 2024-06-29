package Week2;

public class Question5 {
    public static class BankAccount {
        private String accountNumber;
        private double balance;
        private String ownerName;

        public BankAccount(String accountNumber, String ownerName) {
            this.accountNumber = accountNumber;
            this.ownerName = ownerName;
            this.balance = 0.0;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public double getBalance() {
            return balance;
        }

        public String getOwnerName() {
            return ownerName;
        }

        public void setOwnerName(String ownerName) {
                this.ownerName = ownerName;
        }

        public void deposit(double amount) {
            balance += amount;
        }

        public boolean withdraw(double amount) {
            if (amount > 0 && balance >= amount) {
                balance -= amount;
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount("123", "lakshya");
        account.deposit(2000);
        System.out.println(account.getBalance());
    }
}
