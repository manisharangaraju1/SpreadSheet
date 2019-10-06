package Controller;

import View.TableView;

import javax.swing.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class SpreadSheet {
    public static final Map<Character, Integer> cellMap;
    static {
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('B', 1);
        map.put('C', 2);
        map.put('D', 3);
        map.put('E', 4);
        map.put('F', 5);
        map.put('G', 6);
        map.put('H', 7);
        map.put('I', 8);
        cellMap = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {


        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TableView();
            }
        });

    }

}
