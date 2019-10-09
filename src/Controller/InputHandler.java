package Controller;

import Interpreter.Main;
import Model.Cell;

import java.util.List;

import static Controller.UtilMethods.getCellList;
import static Controller.UtilMethods.isNumeric;

public class InputHandler {
    List<Cell> cellList;

    public InputHandler(List<Cell> cellList) {
        this.cellList = cellList;
    }

    public void parse(Object input, Cell currentCell) {

        if (currentCell.getEquation() != null) {
            for (int cellIndex : getCellList(currentCell.getEquation())) {
                System.out.println("INDEX " + cellList.get(cellIndex).getValue());
                cellList.get(cellIndex).deleteObserver(currentCell);
            }
            currentCell.setEquation(null);
        }

        if (isNumeric((String) input)) {
            currentCell.setValue(Double.parseDouble(input.toString()));
            currentCell.notifyObservers(cellList);
        } else {
            String newEquation = (String) input;
            for (int cellIndex : getCellList(newEquation)) {
                cellList.get(cellIndex).addObserver(currentCell);
            }

            currentCell.setEquation((String) input);

            String updatedExpression = new UtilMethods(cellList).getUpdatedExpression(newEquation.trim());
            double newValue = new Main().evaluate(updatedExpression);
            currentCell.setValue(newValue);
            currentCell.notifyObservers(cellList);
        }
    }


}
