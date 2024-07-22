package org.bith.ds.graph.dijkstras;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.IntUnaryOperator;

public class Graph {
    private final int numVertices;
    private final List<List<Integer>> adjacencyList;
    private final Map<List<Integer>, Integer> costMap;

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjacencyList = new ArrayList<>();
        for (int i = 0; i < this.numVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        costMap = new HashMap<>();
    }

    public int getNumVertices() {
        return numVertices;
    }

    public void addEdge(int src, int dest, Integer cost) {
        adjacencyList.get(src).add(dest);
        adjacencyList.get(dest).add(src);
        costMap.put(List.of(src, dest), cost);
        costMap.put(List.of(dest, src), cost);
    }

    public List<Integer> getAdjacencyList(int node) {
        return adjacencyList.get(node);
    }

    public int getCost(int src, Integer dest) {
        return costMap.get(List.of(src, dest));
    }
}
