package tests;

import controller.CircularDependency;
import controller.InputHandler;
import model.Cell;
import org.junit.jupiter.api.Test;
import program.Context;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObserverTest {
    Context context;
    List<List<Cell>> cellList;
    Cell cellOne;
    Cell cellTwo;
    Cell cellThree;
    InputHandler inputHandler;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        cellOne = new Cell(0, 0);
        cellTwo = new Cell(0, 1);
        cellThree = new Cell(0, 2);
        List<Cell> firstRow = new ArrayList<>();
        firstRow.add(cellOne);
        firstRow.add(cellTwo);
        firstRow.add(cellThree);
        cellList = new ArrayList<>();
        cellList.add(firstRow);
        context = new Context(cellList);
        inputHandler = new InputHandler(context);
    }

    @Test
    void countObservers() {
        inputHandler.parse("5", cellThree, false);
        inputHandler.parse("$C", cellOne, false);
        inputHandler.parse("$C", cellTwo, false);

        assertEquals(cellThree.countObservers(), 2);
    }
}
