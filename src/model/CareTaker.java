package model;

import program.Context;

import java.util.Hashtable;
import java.util.List;
import java.util.Stack;

/**
 *  Class to save state of the cell that is last edited.
 *  package private access to protect list of stored states.
 */

public class CareTaker {

    private Stack<Hashtable<Integer, CellMemento>> cellHistory = new Stack<>();

    public void addMemento(Cell cell) {
        cellHistory.push(cell.createMemento());
    }

    // Invoke the restoreState() method of that cell whose state was last stored.
    public void getMemento(Context context) {
        if (cellHistory.size() > 0) {
            Hashtable oldState = cellHistory.pop();
            List<List<Cell>> cellList = context.getCellList();

            oldState.forEach((key, value) -> {
                Cell lastChangedCell = cellList.get(0).get((Integer) key);
                lastChangedCell.restoreState((CellMemento) value, context);
            });
        }
    }
}
