package ru.cotel.catherine.bank;

import ru.cotel.catherine.person.Person;

import java.util.Map;

public class Bank {
    private long count;
    private final Map<String, Person> countsBank = Map.of(
            "5168", new Person("Кира", "Ким"),
            "1234", new Person("Вадим", "Шутов"),
            "7412", new Person("Рональд", "Темный"),
            "1598", new Person("Вика", "Поно")
    );

    public Bank() {
        this.count = 0;
    }

    public Map<String, Person> getCountsBank() {
        return countsBank;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getCount() {
        return count;
    }

}
