import java.util.ArrayList;
import java.util.List;

public class CompositePattern {
    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount();
        System.out.println("Savings: " + savingsAccount.getBalance());
        CurrentAccount currentAccount = new CurrentAccount();
        System.out.println("Current: " + currentAccount.getBalance());
        CompositeAccount compositeAccount = new CompositeAccount();
        compositeAccount.addAccount(savingsAccount);
        compositeAccount.addAccount(currentAccount);
        System.out.println("Total: " + compositeAccount.getBalance());
    }
}

abstract class Account {
    abstract int getBalance();
}

class SavingsAccount extends Account {
    @Override
    int getBalance() {
        return 10000;
    }
}

class CurrentAccount extends Account {

    @Override
    int getBalance() {
        return 5000;
    }
}

class CompositeAccount extends Account {

    private List<Account> accountList = new ArrayList<>();

    @Override
    int getBalance() {
        int totalBalance = 0;
        for (Account acc : accountList) {
            totalBalance += acc.getBalance();
        }
        return totalBalance;
    }

    public void addAccount(Account account) {
        accountList.add(account);
    }
}
