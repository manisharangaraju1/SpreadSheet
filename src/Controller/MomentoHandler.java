package Controller;

import Momento.CareTaker;

public class MomentoHandler {
    private static CareTaker careTaker = new CareTaker();
    public static CareTaker getCareTakerInstace() {
        return careTaker;
    }
}
