package model;

import controller.InputHandler;
import program.Context;

import java.util.Hashtable;
import java.util.Observable;
import java.util.Observer;

public class Cell extends Observable implements Observer {
    private final int row;
    private final int column;
    private Object value;
    private String equation;


    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
        this.value = 0.0;
        this.equation = "0";
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

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public Object getValue() {
        return value;
    }


    public void setValue(Object value) {
        this.value = value;
    }


    public String getEquation() {
        return equation;
    }


    public void setEquation(String equation) {
        this.equation = equation;
    }


    // Whenever the parent cell's state changes, we parse the current cell's equation again.
    @Override
    public void update(Observable o, Object context) {
        InputHandler inputHandler = new InputHandler((Context) context);
        inputHandler.parse(this.equation, this, false);
    }


    public Hashtable<Integer, CellMemento> createMemento() {
        CellMemento currentState = new CellMemento();
        currentState.setState("equation", this.equation);

        Hashtable stateTable = new Hashtable();
        stateTable.put(this.column, currentState);
        return stateTable;
    }


    /**
     * After restoring the previous state, we handle old state like
     * another input and pass it to input handler to handle the input.
     */
    public void restoreState(CellMemento oldState, Context context) {
        String oldEquation = (String) oldState.getState("equation", this.equation);

        InputHandler inputHandler = new InputHandler(context);
        inputHandler.parse(oldEquation, this, true);
    }

}