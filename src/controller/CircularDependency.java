package controller;

import model.Cell;
import program.Context;

import java.util.*;

/**
 * A class to detect if a circular dependency exists among all cell's equations.
 * A directed graph is constructed.
 * It is traversed in a depth first way to detect a cycle.
 */

public class CircularDependency {
    private Context context;
    private Map<Integer, Set<Integer>> dependentsMap;

    public CircularDependency(Context context) {
        this.context = context;
        createDependentsMap();
    }

    private void createDependentsMap() {
        Map<Integer, Set<Integer>> dependentsMap = new HashMap<>();
        List<List<Cell>> cellList = context.getCellList();

        for (int index = 0; index < cellList.get(0).size(); index++) {
            Cell cell = cellList.get(0).get(index);
            Set<Integer> dependents = new HashSet<>();
            for (String token : cell.getEquation().split(" ")) {
                if (token.charAt(0) == '$') {
                    dependents.add(context.getIndexValue(token));
                }
            }
            dependentsMap.put(cell.getColumn(), dependents);
        }
        this.dependentsMap = dependentsMap;
    }

    public boolean hasCycle() {
        Set<Integer> unvisited = new HashSet<>(); // Have to explore
        Set<Integer> visiting = new HashSet<>(); // Still exploring
        Set<Integer> visited = new HashSet<>(); // Explored

        for (int index = 0; index < context.getCellList().size(); index++) {
            unvisited.add(context.getCellList().get(0).get(index).getColumn());
        }

        while (unvisited.size() > 0) {
            int current = unvisited.iterator().next();
            if (depthFirstTraversal(current, unvisited, visiting, visited)) {
                return true;
            }
        }
        return false;
    }


    private boolean depthFirstTraversal(int currentIndex, Set<Integer> unvisited,
                                        Set<Integer> visiting, Set<Integer> visited) {

        moveCellIndex(currentIndex, unvisited, visiting);

        for (int neighbour : dependentsMap.get(currentIndex)) {
            //Already explored that path.
            if (visited.contains(neighbour)) {
                continue;
            }

            //If still being explored, then cycle is detected
            if (visiting.contains(neighbour)) {
                return true;
            }
            if (depthFirstTraversal(neighbour, unvisited,
                                    visiting, visited)) {
                return true;
            }
        }

        //Completed exploring the path, so moving it to visited set
        // (explored).
        moveCellIndex(currentIndex, visiting, visited);
        return false;
    }

    private void moveCellIndex(int currentIndex, Set<Integer> source, Set<Integer> destination) {
        source.remove(currentIndex);
        destination.add(currentIndex);
    }

}
