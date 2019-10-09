package View;

import Controller.MomentoHandler;
import Controller.StateHandler;
import Model.Cell;
import Model.CellTableModel;
import Momento.CareTaker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TableView extends JFrame {

    private JPanel topPanel;
    private JScrollPane scrollPane;
    private static CellTableModel model;
    private List<Cell> cellList;
    private JTable table;
    private JButton viewButton;
    private JButton undoButton;
    private StateHandler stateHandler;

    public TableView() {
        stateHandler = new StateHandler();
        createCellList();
        topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        getContentPane().add(topPanel);

        model = new CellTableModel(cellList);
        model.getCurrentState(stateHandler.getState());
        table = new JTable(model);
        viewButton = new JButton(stateHandler.getState().toString());
        undoButton = new JButton("Undo");
        scrollPane = new JScrollPane(table);
        topPanel.add(scrollPane, BorderLayout.NORTH);
        topPanel.add(viewButton, BorderLayout.CENTER);
        topPanel.add(undoButton, BorderLayout.SOUTH);

        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stateHandler.getState().handleViewRequest();
                viewButton.setText(stateHandler.getState().toString());
                CellTableModel model = new CellTableModel(cellList);
                model.getCurrentState(stateHandler.getState());
                table.setModel(model);
            }
        });

        undoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MomentoHandler.getCareTakerInstace().revert(cellList);
            }
        });

        this.setTitle("SpreadSheet");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

    }

    private void createCellList() {
        cellList = new ArrayList<>();
        cellList.add(new Cell(0));
        cellList.add(new Cell(1));
        cellList.add(new Cell(2));
        cellList.add(new Cell(3));
        cellList.add(new Cell(4));
        cellList.add(new Cell(5));
        cellList.add(new Cell(6));
        cellList.add(new Cell(7));
        cellList.add(new Cell(8));
    }


    public static CellTableModel getModel() {
        return model;
    }
}
