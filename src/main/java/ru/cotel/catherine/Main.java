package ru.cotel.catherine;

import ru.cotel.catherine.controller.BankController;
import ru.cotel.catherine.model.BankModel;
import ru.cotel.catherine.view.BankView;

public class Main {
    public static void main(String[] args) {
        BankModel model = new BankModel();
        BankView view = new BankView();
        BankController bankController = new BankController(view, model);
        bankController.start();
    }
}