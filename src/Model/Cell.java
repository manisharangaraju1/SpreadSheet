package Model;

import java.util.Observable;
import java.util.Observer;

public class Cell extends Observable implements Observer {
    private int value;
    private String equation;

    public Cell(int value) {
        this.value = value;
        this.equation = null;
    }

    public Cell(String equation) {
        this.equation = equation;
        this.value = 0;
    }

    public Cell() {
    }

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
    }

    @Override
    public synchronized void deleteObserver(Observer o) {
        super.deleteObserver(o);
    }

    @Override
    public void notifyObservers(Object arg) {
        super.notifyObservers(arg);

    }


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getEquation() {
        return equation;
    }

    public void setEquation(String equation) {
        this.equation = equation;
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}