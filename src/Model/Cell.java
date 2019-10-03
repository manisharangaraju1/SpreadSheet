package Model;

public class Cell {
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
}
