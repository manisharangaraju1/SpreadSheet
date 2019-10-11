package controller;

import interpreter.Parse;
import model.CareTaker;
import model.Cell;
import program.Context;

import java.util.List;

/**
 * A class to handle the input of a cell when entered.
 *
 * Dettaches (old equation) and attaches(new equation) itself to the dependent cell's observer's list.
 *
 * Sends the new input to the parser for it to interpret.
 * The returned value is assigned to the cell's value.
 * Notifies all its observers.
 */

public class InputHandler {
    Context context;

    public InputHandler(Context context) {
        this.context = context;
    }


    public void parse(Object input, Cell currentCell, boolean isUndo) {
        if (!isUndo) {
            CareTaker careTaker = MomentoHandler.getCareTakerInstace();
            careTaker.addMemento(currentCell);
        }
        String oldEquation = currentCell.getEquation();
        if (oldEquation != "0") {
            editObserversList(currentCell, oldEquation, false);
            currentCell.setEquation(null);
        }

        currentCell.setEquation((String) input);

        String newEquation = currentCell.getEquation();
        editObserversList(currentCell, newEquation, true);

        double newValue = Parse.parse(newEquation, context);
        currentCell.setValue(newValue);
        currentCell.notifyObservers(context);
    }


    public void editObserversList(Cell currentCell, String equation, boolean isAddObserver) {

        for (String token : equation.split(" ")) {
            if (token.charAt(0) == '$') {
                int index = context.getIndexValue(token);
                List<Cell> cellList = context.getCellList().get(0);
                Cell cellToModify = cellList.get(index);
                if (isAddObserver) {
                    cellToModify.addObserver(currentCell);
                } else {
                    cellToModify.deleteObserver(currentCell);
                }
            }
        }
    }
}


