package Model;

import Controller.CircularDependency;
import Controller.InputHandler;
import Controller.MomentoHandler;
import State.State;
import program.Context;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CellTableModel extends AbstractTableModel {
    private final String[] columnHeaders = new String[]{"$A", "$B", "$C", "$D", "$E", "$F", "$G", "$H", "$I"};

    List<Cell> cellList;
    State currentState;

    public CellTableModel(List<Cell> cellList) {
        this.cellList = cellList;
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
        if (currentState.toString().equals("EQUATION"))
            return cell.getEquation();
        return cell.getValue();
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Cell cell = cellList.get(columnIndex);

        MomentoHandler.getCareTakerInstace().addMemento(cell);

        String currentEquation = cell.getEquation();
        cell.setEquation((String) aValue);
        Context context = new Context(cellList);
        CircularDependency circularDependency = new CircularDependency(context);
        if (circularDependency.hasCycle()) {
//            cell.setValue("Error");
            System.out.println("CYCLE DETECTED!!!");
            cell.setEquation(currentEquation);
        } else {
            System.out.println("NO CYCLE");
            InputHandler inputHandler = new InputHandler(context);
            inputHandler.parse(aValue, cell);
        }
    }

    public void getCurrentState(State state) {
        this.currentState = state;
    }

    @Override
    public void fireTableDataChanged() {
        super.fireTableDataChanged();
    }
}
