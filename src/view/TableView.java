package view;

import controller.MomentoHandler;
import model.CareTaker;
import state.StateHandler;
import model.Cell;
import model.CellTableModel;
import program.Context;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * A Class that encapsulates all the GUI components.
 * Displays the modified behaviour of the SpreadSheet with respect to the operations performed.
 */
public class TableView extends JFrame {

    private JPanel topPanel;
    private JScrollPane scrollPane;
    private CellTableModel model;
    private List<List<Cell>> cellList;
    private JTable table;
    private JButton viewButton;
    private JButton undoButton;
    private StateHandler stateHandler;
    private Context context;
    private static final String TITLE = "SpreadSheet";
    private static final String UNDO_BUTTON_LABEL = "UNDO";


    public TableView() {
        createCellList();
        context = new Context(this.cellList);
        stateHandler = new StateHandler();
        model = new CellTableModel(context);
        model.setCurrentState(stateHandler.getState());

        initializeUI();
    }

    private void createCellList() {
        cellList = new ArrayList<>();
        List<Cell> firstRow = new ArrayList<>();

        firstRow.add(new Cell(0,0));
        firstRow.add(new Cell(0,1));
        firstRow.add(new Cell(0,2));
        firstRow.add(new Cell(0,3));
        firstRow.add(new Cell(0,4));
        firstRow.add(new Cell(0,5));
        firstRow.add(new Cell(0,6));
        firstRow.add(new Cell(0,7));
        firstRow.add(new Cell(0,8));

        cellList.add(firstRow);
    }

    private void initializeUI() {
        topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        getContentPane().add(topPanel);

        table = new JTable(model);
        viewButton = new JButton(stateHandler.getState().toString());
        undoButton = new JButton(UNDO_BUTTON_LABEL);
        scrollPane = new JScrollPane(table);
        topPanel.add(scrollPane, BorderLayout.NORTH);
        topPanel.add(viewButton, BorderLayout.CENTER);
        topPanel.add(undoButton, BorderLayout.SOUTH);

        this.setTitle(TITLE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stateHandler.getState().handleViewRequest();
                String label = stateHandler.getState().toString();
                viewButton.setText(label);
                model.setCurrentState(stateHandler.getState());
                model.fireTableDataChanged();
            }
        });

        undoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CareTaker careTaker =  MomentoHandler.getCareTakerInstace();
                careTaker.getMemento(new Context(cellList));
            }
        });
    }
}
