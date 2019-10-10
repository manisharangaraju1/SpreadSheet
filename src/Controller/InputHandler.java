package Controller;

import Model.Cell;
import program.Context;
import program.Parse;

public class InputHandler {
    Context context;

    public InputHandler(Context context) {
        this.context = context;
    }

    public void parse(Object input, Cell currentCell) {
        if (currentCell.getEquation() != null) {
            editObserversList(currentCell, (String)currentCell.getEquation(), false);
            currentCell.setEquation(null);
        }

        currentCell.setEquation((String) input);
        editObserversList(currentCell, (String)currentCell.getEquation(), true);

        double newValue = Parse.parse((String)currentCell.getEquation(), context);
        currentCell.setValue(newValue);
        currentCell.notifyObservers(context);
    }

    public void editObserversList(Cell currentCell, String equation, boolean isAddObserver) {

        for (String token : equation.split(" ")) {
            if (token.charAt(0) == '$') {
                int index = context.getIndexValue(token);
                Cell cellToModify = context.getCellList().get(index);
                if (isAddObserver) {
                    cellToModify.addObserver(currentCell);
                } else {
                    cellToModify.deleteObserver(currentCell);
                }
            }
        }
    }

}


