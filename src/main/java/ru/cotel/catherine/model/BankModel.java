package ru.cotel.catherine.model;

import ru.cotel.catherine.bank.Bank;
import ru.cotel.catherine.person.Person;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BankModel {
    private final Bank bank = new Bank();
    private final Map<String, Person> count = new HashMap<>(bank.getCountsBank());

    public long checkCount(String pincode) {
        for (Map.Entry<String, Person> map : count.entrySet()) {
            if (map.getKey().equals(pincode)) {
                return bank.getCount();
            }
        }
        return 0L;
    }

    public boolean isAccountExist(String pincod) {
        boolean isExist = false;
        Optional<Map.Entry<String, Person>> opBank = count.entrySet().stream()
                .filter(it -> it.getKey().equalsIgnoreCase(pincod))
                .findFirst();

        if (opBank.isEmpty()) {
            return isExist;
        } else {
            return true;
        }
    }

    public void withdraw(String pincode, long amount) {
        long moneyCount = 0L;
        for (Map.Entry<String, Person> map : count.entrySet()) {
            if (map.getKey().equals(pincode)) {
                moneyCount = bank.getCount();
                break;
            }
        }

        if (moneyCount != 0 && moneyCount >= amount) {
            moneyCount -= amount;
            bank.setCount(moneyCount);
        } else {
            throw new RuntimeException("Недостаточно средств");
        }
    }

    public void toPup(String pincode, long amountToPup) {
        long moneyCount = 0L;
        for (Map.Entry<String, Person> map : count.entrySet()) {
            if (map.getKey().equals(pincode)) {
                moneyCount = bank.getCount();
                break;
            }
        }
        moneyCount += amountToPup;
        bank.setCount(moneyCount);
    }

    public String getFullNamePerson(String pincode) {
        String fullName = "";
        for (Map.Entry<String, Person> bankCount : count.entrySet()) {
            if (bankCount.getKey().equals(pincode)) {
                fullName = bankCount.getValue().getFullNamePerson();
            }
        }
        return fullName;
    }
}
