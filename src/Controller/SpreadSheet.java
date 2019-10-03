package Controller;

import View.TableView;

import javax.swing.*;


public class SpreadSheet {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TableView();
            }
        });

    }

}
