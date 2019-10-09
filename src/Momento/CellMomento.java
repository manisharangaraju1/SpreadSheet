package Momento;

import Model.Cell;

import java.util.List;

public class CellMomento {
    int index;
    double value;
    String equation;
    List<Cell> cellList;

    public CellMomento(int index, double value, String equation, List<Cell> cellList) {
        this.index = index;
        this.value = value;
        this.equation = equation;
        this.cellList = cellList;
    }

    public int getIndex() {
        return index;
    }

    public double getValue() {
        return value;
    }

    public String getEquation() {
        return equation;
    }
}
