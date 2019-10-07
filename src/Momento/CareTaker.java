package Momento;

import Model.Cell;

import java.util.List;
import java.util.Stack;

public class CareTaker {
    private Stack<CellMomento> cellHistory = new Stack<>();


    public void save(Cell cell) {
        cellHistory.push(cell.save());
        System.out.println(cell.getValue());
    }

    public void revert(List<Cell> cellList) {
        System.out.println(cellHistory.size());
        if(cellHistory.size() > 0) {
            CellMomento cell = cellHistory.pop();
            System.out.println(cell.getIndex());
            System.out.println(cellList.get(cell.getIndex()).getValue());
                cellList.get(cell.getIndex()).revert(cell);

        }
        else
            System.out.println("NULL");

    }
}
