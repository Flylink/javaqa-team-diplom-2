package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {
    Bank bank = new Bank();

    @Test
    void shouldTransferWithPositiveAmount() {

        SavingAccount account1 = new SavingAccount(2000, 100, 10000, 10);
        SavingAccount account2 = new SavingAccount(5000, 100, 20000, 10);

        System.out.println("Списываем средства c account1 текущий баланс:" + account1.getBalance() + " и переводим средства на account2 текущий баланс:" + account2.getBalance());
        boolean result = bank.transfer(account1, account2, 1000);
        System.out.println("Списали с account1 текущий баланс:" + account1.getBalance() + " и перевели на account2 текущий баланс:" + account2.getBalance());

        Assertions.assertTrue(result);
        Assertions.assertEquals(1000, account1.getBalance());
        Assertions.assertEquals(6000, account2.getBalance());
    }


    @Test
    void shouldTransferZeroAmountFailure() {
        SavingAccount account1 = new SavingAccount(2000, 1000, 10000, 10);
        CreditAccount account2 = new CreditAccount(5000, 1000, 10);

        System.out.println("Списываем средства c account1 текущий баланс:" + account1.getBalance() + " и переводим средства на account2 текущий баланс:" + account2.getBalance());
        boolean result = bank.transfer(account1, account2, 0);
        System.out.println("Списали с account1 текущий баланс:" + account1.getBalance() + " и перевели на account2 текущий баланс:" + account2.getBalance());

        Assertions.assertFalse(result);
        Assertions.assertEquals(2000, account1.getBalance());
        Assertions.assertEquals(5000, account2.getBalance());
    }

    @Test
    void shouldTransferNegativeAmountFailure() {
        SavingAccount account1 = new SavingAccount(2000, 1000, 10000, 10);
        CreditAccount account2 = new CreditAccount(5000, 1000, 10);

        System.out.println("Списываем средства c account1 текущий баланс:" + account1.getBalance() + " и переводим средства на account2 текущий баланс:" + account2.getBalance());
        boolean result = bank.transfer(account1, account2, -50);
        System.out.println("Списали с account1 текущий баланс:" + account1.getBalance() + " и перевели на account2 текущий баланс:" + account2.getBalance());

        Assertions.assertFalse(result);
        Assertions.assertEquals(2000, account1.getBalance());
        Assertions.assertEquals(5000, account2.getBalance());
    }

    @Test
    void shouldTransferFundsMoreThanAccount() {
        SavingAccount account1 = new SavingAccount(10000, 1000, 11000, 5);
        SavingAccount account2 = new SavingAccount(2000, 1000, 11000, 5);

        System.out.println("Списываем средства c account1 текущий баланс:" + account1.getBalance() + " и переводим средства на account2 текущий баланс:" + account2.getBalance());

        boolean result = bank.transfer(account1, account2, 15000);
        System.out.println("Списали с account1 текущий баланс:" + account1.getBalance() + " и перевели на account2 текущий баланс:" + account2.getBalance());

        Assertions.assertFalse(result);
        Assertions.assertEquals(10000, account1.getBalance());
        Assertions.assertEquals(2000, account2.getBalance());
    }
}
