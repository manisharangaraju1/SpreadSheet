package Model;

import Controller.InputHandler;
import Momento.CellMomento;
import View.TableView;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Cell extends Observable implements Observer {
    private int index;
    private double value;
    private String equation;
    InputHandler inputHandler;

    public void setInputHandler(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }


    public int getIndex() { return index; }

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

    public CellMomento save(List<Cell> cellList) {
        return new CellMomento(this.index, this.value, this.equation, cellList);
    }

    public void revert(CellMomento cell, List<Cell> cellList) {
        System.out.println("CellList after reverting passing: " + cellList);

        this.value = cell.getValue();
        this.equation = cell.getEquation();
        cellList.set(cell.getIndex(), this);
        System.out.println("CellList after reverting list : " + cellList);
        CellTableModel cellTableModel = TableView.getModel();
        cellTableModel.fireTableDataChanged();
//        System.out.println(this.countObservers());
//        this.notifyObservers(cellList);
    }

}