package Model;

import program.Context;

import java.util.Hashtable;
import java.util.List;
import java.util.Stack;

public class CareTaker {

    private Stack<Hashtable<Integer,CellMemento>> cellHistory = new Stack<>();

    public void addMemento(Cell cell) {
        cellHistory.push(cell.createMemento());
    }

    public void getMemento(Context context) {
        Hashtable oldState = cellHistory.pop();
        List<Cell> cellList = context.getCellList();
        oldState.forEach((key, value) -> {
            cellList.get((Integer) key).restoreState( (CellMemento) value,context);
        });
    }
}
