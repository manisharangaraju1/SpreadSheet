package program;

import Model.Cell;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Context needed by the expressions to interpret. Contains cell Data and
 * a map with column headers and its respective column indices to make it easier to access values from the cellList
 * , along with methods to access the context data.
 */


public class Context  {
    private Map<String, Integer> columnIndices = new HashMap<>();
    private List<Cell> cellList;

    public List<Cell> getCellList() {
        return cellList;
    }

    public Context(List<Cell> cellList) {
        this.cellList = cellList;
        this.columnIndices = getColumnIndices();
    }

    public Double getVariableValue(String name) {
        int index = columnIndices.get(name);
        return (Double)this.cellList.get(index).getValue();
    }

    public int getIndexValue(String name) {
        return columnIndices.get(name);
    }

    private Map<String, Integer> getColumnIndices() {
        Map<String, Integer> columnIndices = new HashMap<>();
        columnIndices.put("$A", 0);
        columnIndices.put("$B", 1);
        columnIndices.put("$C", 2);
        columnIndices.put("$D", 3);
        columnIndices.put("$E", 4);
        columnIndices.put("$F", 5);
        columnIndices.put("$G", 6);
        columnIndices.put("$H", 7);
        columnIndices.put("$I", 8);
        return columnIndices;
    }

}
