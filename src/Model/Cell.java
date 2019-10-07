package Model;

import Controller.InputHandler;
import Controller.UtilMethods;
import Interpreter.Main;
import Momento.CellMomento;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Cell extends Observable implements Observer {
    private int index;
    private double value;
    private String equation;
    InputHandler inputHandler;

    public int getIndex() {
        return index;
    }

    public Cell(int index) {
        this.index = index;
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
    protected synchronized void setChanged() {
        super.setChanged();
    }

    @Override
    public void notifyObservers(Object arg) {
        setChanged();
        super.notifyObservers(arg);
    }

    @Override
    public synchronized int countObservers() {
        return super.countObservers();
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getEquation() {
        return equation;
    }

    public void setEquation(String equation) {
        this.equation = equation;
    }

    @Override
    public void update(Observable o, Object cellList) {

         inputHandler = new InputHandler((ArrayList) cellList);

        if (this.equation != null) {
            inputHandler.parse(this.equation, this);
        } else {
            inputHandler.parse(this.value, this);
        }
        this.notifyObservers(cellList);
    }

    public String toString() {
        return "" + this.getValue();
    }

    public CellMomento save() {
        return new CellMomento(this.index, this.value, this.equation);
    }

    public void revert(CellMomento cell) {
        this.value = cell.getValue();
        this.equation = cell.getEquation();

        System.out.println(this.value);
        if (this.equation != null) {
            inputHandler.parse(this.equation, this);
        } else {
            inputHandler.parse(this.value, this);
        }
    }
}