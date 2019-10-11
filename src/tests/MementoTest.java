package tests;

import model.CareTaker;
import model.Cell;
import model.CellMemento;
import org.junit.jupiter.api.Test;
import program.Context;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MementoTest {

    private Cell cell;
    private CareTaker careTaker;
    private CellMemento cellMemento;
    private Context context;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        cell = new Cell(0, 0);
        cell.setEquation("4");
        List<Cell> firstRow = new ArrayList<>();
        List<List<Cell>> cellList = new ArrayList<>();
        firstRow.add(cell);
        cellList.add(firstRow);
        context = new Context(cellList);
        careTaker = new CareTaker();
    }


    @Test
    void restoreState() {
        careTaker.addMemento(cell);
        cell.setEquation("2");
        careTaker.getMemento(context);
        assertEquals(cell.getEquation(), "4");
    }
}