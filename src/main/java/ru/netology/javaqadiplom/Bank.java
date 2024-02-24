package ru.netology.javaqadiplom;

public class Bank {

    /**
     * Операция перевода указанной суммы с одного счёта на другой.
     * Если операция прошла успешно, то баланс счёта from должен
     * уменьшиться на эту сумму, а баланс счёта to увеличиться.
     * Если операция прошла неуспешно, балансы обоих счетов никак
     * измениться не должны.
     * @param from - счёт с которого переводим
     * @param to - счёт на который переводим
     * @param amount - сумма перевода
     * @return - true если операция прошла успешно, false иначе
     */
    public boolean transfer(Account from, Account to, int amount) {
        if (amount <= 0) {
            return false;
        }
        if (from.getBalance() < amount) { // Проверяем, достаточно ли средств на счете from
            return false;
        }
        if (from.pay(amount)) {
            if (to.add(amount)) {
                return true; // Перевод прошел успешно
            } else {
                // Откатываем операцию списания средств с счета from
                from.add(amount);
                return false; // Перевод не удался из-за неудачного пополнения счета to
            }
        }
        return false;
    }
}
