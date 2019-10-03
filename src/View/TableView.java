package View;

import Controller.StateHandler;
import Model.Cell;
import Model.CellTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TableView extends JFrame{

    private JPanel topPanel;
    private JScrollPane scrollPane;
    private CellTableModel model;
    private List<Cell> cellList;
    private JTable table;
    private JButton viewButton;
    private StateHandler stateHandler;

    public TableView() {
        stateHandler = new StateHandler();
        createCellList();
        topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        getContentPane().add(topPanel);

        model = new CellTableModel(cellList, stateHandler.getState());
        table = new JTable(model);
        viewButton = new JButton(stateHandler.getState().toString());
        scrollPane = new JScrollPane(table);
        topPanel.add(scrollPane, BorderLayout.CENTER);
        topPanel.add(viewButton, BorderLayout.SOUTH);

        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stateHandler.getState().handleViewRequest();
                viewButton.setText(stateHandler.getState().toString());
                CellTableModel model = new CellTableModel(cellList, stateHandler.getState());
                table.setModel(model);
            }
        });

        this.setTitle("SpreadSheet");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

    }

    private void createCellList() {
        cellList = new ArrayList<>();
        cellList.add(new Cell(1));
        cellList.add(new Cell(2));
        cellList.add(new Cell("$A$B+"));
        cellList.add(new Cell(78));
        cellList.add(new Cell(34));
        cellList.add(new Cell(3564));
        cellList.add(new Cell("$C$D*"));
        cellList.add(new Cell("$E"));
        cellList.add(new Cell("$B"));
    }

}
