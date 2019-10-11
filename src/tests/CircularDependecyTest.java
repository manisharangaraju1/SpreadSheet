package tests;

import controller.CircularDependency;
import model.Cell;
import org.junit.jupiter.api.Test;
import program.Context;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CircularDependecyTest {
    Context context;
    List<List<Cell>> cellList;
    Cell cellOne;
    Cell cellTwo;
    Cell cellThree;
    CircularDependency circularDependency;

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
        circularDependency = new CircularDependency(context);
    }

    @Test
    void positiveDependencyTest() {
        cellOne.setEquation("$B $C +");
        cellTwo.setEquation("$A $C +");
        cellThree.setEquation("5");
        assertTrue(circularDependency.hasCycle());
    }

    @Test
    void negativeDependencyTest() {
        cellOne.setEquation("3");
        cellTwo.setEquation("$A 2 *");
        cellThree.setEquation("$A $B +");
        assertTrue(!circularDependency.hasCycle());
    }
}
