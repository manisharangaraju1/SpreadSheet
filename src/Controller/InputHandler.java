package Controller;

import Interpreter.Main;
import Model.Cell;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {
    List<Cell> cellList;

    public InputHandler( List<Cell> cellList) {
        this.cellList = cellList;
    }

    public void parse(Object input, Cell currentCell) {
        if (isNumeric((String) input)) {
            currentCell.setValue(Integer.parseInt(input.toString()));
            currentCell.notifyObservers(currentCell);
        }
        else {

            String oldEquation = currentCell.getEquation();
            if(oldEquation != null) {
                for(int cellIndex : getCellList(oldEquation)) {
                    cellList.get(cellIndex).deleteObserver(currentCell);
                }
            }

            String newEquation = (String)input;
            for(int cellIndex : getCellList(newEquation)) {
                cellList.get(cellIndex).addObserver(currentCell);
            }


            currentCell.setEquation((String) input);

            int newValue = new Main().evaluate(getUpdatedExpression(newEquation.trim()));
            currentCell.setValue(newValue);
        }
    }


    public static boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    private List<Integer> getCellList(String equation) {
        List<Integer> cellTokens = new ArrayList<>();
        String[] tokens = equation.split(" ");
        for(String token : tokens) {
            if(token.charAt(0) == '$') {
                cellTokens.add(SpreadSheet.cellMap.get(token.charAt(1)));
            }
        }
        return cellTokens;
    }

    private String getUpdatedExpression(String input) {
        String[] tokens = input.split(" ");
        String updatedEquation = "";
        for(String token : tokens) {
            if(token.charAt(0) == '$') {
                int index = SpreadSheet.cellMap.get(token.charAt(1));
                updatedEquation += String.valueOf(cellList.get(index).getValue()) + " ";
            }else{
                updatedEquation += token+ " ";
            }
        }
        return updatedEquation;
    }
}
