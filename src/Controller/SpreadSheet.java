package Controller;

import View.TableView;

import javax.swing.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


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
