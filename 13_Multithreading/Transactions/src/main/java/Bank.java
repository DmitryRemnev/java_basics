import java.util.*;

public class Bank {

    public static final String TRANSFER_BLOCKED = "Перевод заблокирован!";
    public static final String TRANSACTION_NOT_POSSIBLE = "Транзакция невозможна - один или оба аккаунта заблокированы!";
    public static final String TRANSLATION_IS_SUCCESSFULLY = "Перевод упешно звершён!";
    public static final String INSUFFICIENT_FUNDS = "Недостаточно средств!";

    private Map<String, Account> accounts;
    private final Random random = new Random();

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    public void transfer(String fromAccountNum, String toAccountNum, long amount) {

        if (amount > 50_000) {
            try {
                if (isFraud(fromAccountNum, toAccountNum, amount)) {

                    Account fromAccount = accounts.get(fromAccountNum);
                    fromAccount.setBlocked(true);

                    Account toAccount = accounts.get(toAccountNum);
                    toAccount.setBlocked(true);

                    System.out.println(TRANSFER_BLOCKED);

                } else {
                    transaction(fromAccountNum, toAccountNum, amount);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            transaction(fromAccountNum, toAccountNum, amount);
        }
    }

    public synchronized void transaction(String fromAccountNum, String toAccountNum, long amount) {
        Account fromAccount = accounts.get(fromAccountNum);
        Account toAccount = accounts.get(toAccountNum);

        if (fromAccount.isBlocked() || toAccount.isBlocked()) {
            System.out.println(TRANSACTION_NOT_POSSIBLE);

        } else {

            if (fromAccount.getMoney() >= amount) {

                fromAccount.setMoney(fromAccount.getMoney() - amount);
                toAccount.setMoney(toAccount.getMoney() + amount);
                System.out.println(TRANSLATION_IS_SUCCESSFULLY);

            } else {
                System.out.println(INSUFFICIENT_FUNDS);
            }
        }
    }

    public long getBalance(String accountNum) {
        Account account = accounts.get(accountNum);
        return account.getMoney();
    }

    public long getSumAllAccounts() {
        List<Account> list = new ArrayList<>(accounts.values());
        long fullAmount = 0;

        for (Account account : list) {
            fullAmount += account.getMoney();
        }

        return fullAmount;
    }
}