package org.bith.ds.graph.dijkstras;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestDijkstrasAlgo {
    public static void main(String[] args) {
        int numVertices = 9;
        Graph g = new Graph(numVertices);
        g.addEdge(0, 1, 4);
        g.addEdge(0, 7, 8);
        g.addEdge(1, 2, 8);
        g.addEdge(1, 7, 11);
        g.addEdge(2, 3, 7);
        g.addEdge(2, 8, 2);
        g.addEdge(2, 5, 4);
        g.addEdge(3, 4, 9);
        g.addEdge(3, 5, 14);
        g.addEdge(4, 5, 10);
        g.addEdge(5, 6, 2);
        g.addEdge(6, 7, 1);
        g.addEdge(6, 8, 6);
        g.addEdge(7, 8, 7);
        DijkstrasAlgo dijkstrasAlgo = new DijkstrasAlgo();
        int[][] rsult = dijkstrasAlgo.shortestPathFromSource(g, 0);
        for (int[] j : rsult) {
            System.out.println(Arrays.toString(j));
        }
    }
}