package ru.cotel.catherine.controller;

import ru.cotel.catherine.model.BankModel;
import ru.cotel.catherine.view.BankView;

import java.util.Scanner;

public class BankController {
    private final BankView view;
    private final BankModel model;

    public BankController(BankView view, BankModel model) {
        this.view = view;
        this.model = model;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        String pincode = null;
        while (true) {
            System.out.println("Команды ENTER, COUNT, WITHDRAW, TOPUP, EXIT");
            System.out.println("Введите команду: ");
            String command = scanner.nextLine();
            try {
                switch (command.toLowerCase()) {
                    case ("enter"):
                        System.out.println("Введите пин-код:");
                        pincode = scanner.nextLine();
                        boolean isExist = model.isAccountExist(pincode);
                        if (isExist) {
                            String fullNamePerson = model.getFullNamePerson(pincode);
                            view.displayEnterMessage("Вход выполнен! " + fullNamePerson + ", добро пожаловать!");
                        } else {
                            view.displayEnterMessage("Такого счета не существует");
                        }
                        break;

                    case ("count"):
                        if (pincode != null) {
                            view.displayCount(model.checkCount(pincode));
                            break;
                        } else {
                            view.displayMessage("Необходимо сначала войти!");
                            break;
                        }

                    case ("withdraw"):
                        if (pincode != null) {
                            System.out.println("Введите необходимую сумму: ");
                            long amountWithdraw = Long.parseUnsignedLong(scanner.nextLine());
                            model.withdraw(pincode, amountWithdraw);
                            view.displayMessage("Заберите деньги");
                            break;

                        } else {
                            view.displayMessage("Необходимо сначала войти!");
                            break;
                        }

                    case ("topup"):
                        if (pincode != null) {
                            System.out.println("Введите сумму, которую хотите положить на счет: ");
                            long amountToPup = Long.parseUnsignedLong(scanner.nextLine());
                            model.toPup(pincode, amountToPup);
                            view.displayMessage("Сумма внесена");
                            break;
                        } else {
                            view.displayMessage("Необходимо сначала войти!");
                            break;
                        }

                    case ("exit"):
                        view.displayMessage("Программа завершена");
                        return;
                    default:
                        System.out.println("Неизвестная команда");
                }

            } catch (Exception e) {
                view.displayMessage("Ошибка " + e.getMessage());
            }
        }
    }
}
