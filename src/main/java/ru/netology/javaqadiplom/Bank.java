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
