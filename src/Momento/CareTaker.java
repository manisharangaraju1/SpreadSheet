package Momento;

import Model.Cell;

import java.util.List;
import java.util.Stack;

public class CareTaker {
    private Stack<CellMomento> cellHistory = new Stack<>();

    public void save(Cell cell, List<Cell> cellList) {
        cellHistory.push(cell.save(cellList));
        for(int i=0;i<cellHistory.size();i++) {
            System.out.print(cellHistory.get(i).getValue() + " ");
        }
        System.out.println("\n");
    }

    public void revert(List<Cell> cellList) {

        System.out.println("CEll LIST IN REVERT" + cellList);
        if(cellHistory.size() > 0) {
            CellMomento cell = cellHistory.pop();
            System.out.println("Popping : " + cell.getValue());
            cellList.get(cell.getIndex()).revert(cell, cellList);
        }
        else System.out.println("NULL");
        for(int i=0;i<cellHistory.size();i++) {
            System.out.print(cellHistory.get(i).getValue() + " ");
        }
        System.out.println("\n");
    }
}
