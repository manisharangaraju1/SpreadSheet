package Controller;

import Model.Cell;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UtilMethods {
    List<Cell> cellList;


    public UtilMethods(List<Cell> cellList) {
        this.cellList = cellList;

    }

    private static final Map<Character, Integer> getCellMap() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('B', 1);
        map.put('C', 2);
        map.put('D', 3);
        map.put('E', 4);
        map.put('F', 5);
        map.put('G', 6);
        map.put('H', 7);
        map.put('I', 8);
        return map;
    }

    public static boolean isNumeric(String str) {
        try
        {
            Double.parseDouble(str);
        }
        catch(NumberFormatException e)
        {
            //not a double
            return false;
        }
        return true;
    }

    public  static List<Integer> getCellList(String equation) {
        List<Integer> cellTokens = new ArrayList<>();
        String[] tokens = equation.split(" ");
        for(String token : tokens) {
            if(token.charAt(0) == '$') {
                cellTokens.add(getCellMap().get(token.charAt(1)));
            }
        }
        return cellTokens;
    }

    public  String getUpdatedExpression(String input) {
        String[] tokens = input.split(" ");
        String updatedEquation = "";
        for(String token : tokens) {
            if(token.charAt(0) == '$') {
                int index = getCellMap().get(token.charAt(1));
                updatedEquation += cellList.get(index).getValue() + " ";
            }else{
                updatedEquation += token+ " ";
            }
        }
        return updatedEquation;
    }

}
