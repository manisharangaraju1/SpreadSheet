package controller;


import model.CareTaker;

/**
 * A Class which handles the undo operation.
 * A single instance is used everywhere to invoke the respective function calls.
 */

public class MomentoHandler {
    private static CareTaker careTaker = new CareTaker();

    public static CareTaker getCareTakerInstace() {
        return careTaker;
    }
}
