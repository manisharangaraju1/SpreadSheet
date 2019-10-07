package Model;

import Controller.InputHandler;
import Controller.MomentoHandler;
import Momento.CareTaker;
import State.State;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CellTableModel extends AbstractTableModel {

    List<Cell> cellList;
    State currentState;
    private final String[] columnHeaders = new String[]{"$A", "$B", "$C", "$D", "$E", "$F", "$G", "$H", "$I"};

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

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Cell cell = cellList.get(columnIndex);
        if (currentState.toString().equals("EQUATION") && cell.getEquation() != null) {
            return cell.getEquation();
        }
        if(cell.getValue() % 1 == 0) {
            return (int)cell.getValue();
        }

        return cell.getValue();
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if(aValue instanceof Double) {

        }
        Cell cell = cellList.get(columnIndex);
        MomentoHandler.getCareTakerInstace().save(cell);
        InputHandler inputHandler = new InputHandler(cellList);
        inputHandler.parse(aValue, cell);
    }


}
