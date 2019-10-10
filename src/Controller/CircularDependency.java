package Controller;

import Model.Cell;
import program.Context;

import java.util.*;

public class CircularDependency {
    private Context context;
    private Map<Integer, Set<Integer>> adjacencyMap;
    public CircularDependency(Context context) {
        this.context = context;
        createAdjacencyMap();
    }

    private void createAdjacencyMap() {
        Map<Integer, Set<Integer>> adjacencyMap = new HashMap<>();
        List<Cell> cellList = context.getCellList();

        for(int index=0; index<cellList.size(); index++) {
            Cell cell = cellList.get(index);
            Set<Integer> dependents = new HashSet<>();
            for(String token : cell.getEquation().split(" ")) {
                    if(token.charAt(0) == '$') {
                        dependents.add(context.getIndexValue(token));
                    }
            }
            adjacencyMap.put(cell.getColumn(), dependents);
        }
        this.adjacencyMap = adjacencyMap;
    }

    public boolean hasCycle() {
        Set<Integer> unvisited = new HashSet<>();
        Set<Integer> visiting = new HashSet<>();
        Set<Integer> visited = new HashSet<>();

        for(int index=0; index<context.getCellList().size(); index++) {
            unvisited.add(context.getCellList().get(index).getColumn());
        }

        while(unvisited.size() > 0) {
           int current = unvisited.iterator().next();
            if(dfs(current, unvisited, visiting, visited)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(int currentIndex, Set<Integer> unvisited, Set<Integer> visiting, Set<Integer> visited) {

        moveCellIndex(currentIndex, unvisited, visiting);

        for(int neighbour : adjacencyMap.get(currentIndex)) {
            //Already explored so dont have to redo it again
            if(visited.contains(neighbour)) {
                continue;
            }

            //If in this, cycle is detected
            if(visiting.contains(neighbour)) {
                return true;
            }
            if(dfs(neighbour, unvisited, visiting, visited)) {
                return true;
            }
        }

        //Completed exploring the path, so moving it to visited set.
        moveCellIndex(currentIndex, visiting, visited);
        return false;
    }

    private void moveCellIndex(int currentIndex, Set<Integer> source, Set<Integer> destination) {
        source.remove(currentIndex);
        destination.add(currentIndex);
    }


}
