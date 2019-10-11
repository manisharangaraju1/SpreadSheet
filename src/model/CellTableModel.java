package model;

import controller.CircularDependency;
import controller.InputHandler;
import state.State;
import program.Context;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * A class to encapsulate the data model of the table view.
 */

public class CellTableModel extends AbstractTableModel {
    private final String[] columnHeaders = new String[]{"$A", "$B", "$C", "$D", "$E", "$F", "$G", "$H", "$I"};

    State currentState;
    Context context;

    public CellTableModel(Context context) {
        this.context = context;
    }


    public String getColumnName(int column) {
        return columnHeaders[column];
    }


    @Override
    public int getRowCount() {
        return context.getCellList().size();
    }


    @Override
    public int getColumnCount() {
        return columnHeaders.length;
    }


    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }


    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged();
    }


    // Returns the object depending on the currentState
    public Object getValueAt(int rowIndex, int columnIndex) {
        List<Cell> cellList = context.getCellList().get(rowIndex);
        Cell cell = cellList.get(columnIndex);
        if (currentState.toString().contains("VALUE"))
            return cell.getEquation();
        return cell.getValue();
    }


    /**
     * As soon as a value is entered, store the previous equation
     * to restore if circular dependency exists.
     * Check if circular dependency exists with the new equation.
     * If yes display Error, else pass it to the input handler.
     */
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        List<Cell> cellList = context.getCellList().get(rowIndex);
        Cell cell = cellList.get(columnIndex);

        String currentEquation = cell.getEquation();
        cell.setEquation((String) aValue);
        CircularDependency circularDependency = new CircularDependency(context);
        cell.setEquation(currentEquation);

        if (circularDependency.hasCycle())
            cell.setValue("Error");
        else {
            InputHandler inputHandler = new InputHandler(context);
            inputHandler.parse(aValue, cell, false);
        }

        fireTableDataChanged();
    }


    public void setCurrentState(State state) {
        this.currentState = state;
    }

}
