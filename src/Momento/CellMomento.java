package Momento;

public class CellMomento {
        int index;
        double value;
        String equation;

    public CellMomento(int index, double value, String equation) {
        this.index = index;
        this.value = value;
        this.equation = equation;
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
