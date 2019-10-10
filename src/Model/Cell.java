package Model;

import Controller.InputHandler;
import program.Context;

import java.util.Hashtable;
import java.util.Observable;
import java.util.Observer;

public class Cell extends Observable implements Observer {
    private int row;
    private int column;
    private double value;
    private String equation;

    public int getColumn() {
        return column;
    }

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
        this.value = 0;
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
    public void update(Observable o, Object context) {
        new InputHandler((Context) context).parse(this.equation, this);
    }

    public Hashtable<Integer, CellMemento> createMemento() {
        CellMemento currentState = new CellMemento();
        currentState.setState( "equation", this.equation );
        currentState.setState( "column", new Integer(this.column) );
        currentState.setState( "value", new Double(this.value) );
        Hashtable stateTable = new Hashtable();
        stateTable.put(this.column, currentState);
        return stateTable;
    }

    public void restoreState( CellMemento oldState, Context context) {
        this.equation = (String) oldState.getState("equation", this.equation);

        CellTableModel cellTableModel = new CellTableModel(context.getCellList());
        cellTableModel.setValueAt(this.equation, this.row, this.column);
    }

}