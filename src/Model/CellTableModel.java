package Model;

import Controller.StateHandler;
import State.State;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class CellTableModel extends AbstractTableModel {

    List<Cell> cellList = new ArrayList<>();
    State currentState;
    private final String[] columnHeaders = new String[]{"$A", "$B", "$C", "$D", "$E", "$F", "$G", "$H", "$I"};
//    private final Class[] columnClass = new Class[] {Integer.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class,
//            Integer.class, Integer.class, Integer.class,};
//

    public CellTableModel(List<Cell> cellList, State currentState) {
        this.cellList = cellList;
        this.currentState = currentState;
    }

    public String getColumnName(int column) {
        return columnHeaders[column];
    }
    @Override
    public int getRowCount() {
        return 1;
    }

    @Override
    public int getColumnCount() {
        return columnHeaders.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Cell cell = cellList.get(columnIndex);
        if(currentState.toString().equals("EQUATION") && cell.getEquation() != null) {
                return cell.getEquation();
        }
        return cell.getValue();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    {
        Cell cell = cellList.get(columnIndex);
        if(isNumeric((String)aValue)) {
            cell.setValue(Integer.parseInt(aValue.toString()));
        }else{
            cell.setEquation((String)aValue);
        }
    }

    public static boolean isNumeric(String str)
    {
        for (char c : str.toCharArray())
        {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

}
