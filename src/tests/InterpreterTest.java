package tests;

import controller.InputHandler;
import model.Cell;
import org.junit.jupiter.api.Test;
import program.Context;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InterpreterTest {
    private Cell cell;
    private Context context;
    private InputHandler inputHandler;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        cell = new Cell(0, 0);
        cell.setEquation("4");
        List<Cell> firstRow = new ArrayList<>();
        firstRow.add(cell);
        List<List<Cell>> cellList = new ArrayList<>();
        cellList.add(firstRow);
        context = new Context(cellList);
        inputHandler = new InputHandler(context);
    }

    @Test
    void interpretAddtionTest() {
        inputHandler.parse("4 7 +", cell, false);
        assertEquals(cell.getValue(), 11.0);
    }

    @Test
    void interpretSubtractionTest() {
        inputHandler.parse("8 2 -", cell, false);
        assertEquals(cell.getValue(), 6.0);
    }

    @Test
    void interpretMultiplicationTest() {
        inputHandler.parse("3 7 *", cell, false);
        assertEquals(cell.getValue(), 21.0);
    }

}
