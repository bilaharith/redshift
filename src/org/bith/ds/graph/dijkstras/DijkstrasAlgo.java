package org.bith.ds.graph.dijkstras;

import java.util.*;

public class DijkstrasAlgo {

    public int[][] shortestPathFromSource(Graph g, int source) {
        final int numVertices = g.getNumVertices();
        Set<Integer> visitedNodes = new HashSet<>();
        int[] costFromSrc = new int[numVertices];
        int[] prevNode = new int[numVertices];
        Arrays.fill(costFromSrc, Integer.MAX_VALUE);
        visitedNodes.add(source);
        costFromSrc[source] = 0;
        prevNode[source] = -1;
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(list -> list.get(1)));
        pq.add(List.of(source, 0));
        while (!pq.isEmpty()) {
            List<Integer> adjInfo = pq.poll();
            int visitingNode = adjInfo.get(0);
            List<Integer> adjacentNodes = g.getAdjacencyList(visitingNode);
            adjacentNodes.removeAll(visitedNodes);
            for (Integer adjacentNode : adjacentNodes) {
                int adjNodeCost = costFromSrc[visitingNode] + g.getCost(visitingNode, adjacentNode);
                pq.add(List.of(adjacentNode, adjNodeCost));
                if (adjNodeCost < costFromSrc[adjacentNode]) {
                    costFromSrc[adjacentNode] = adjNodeCost;
                    prevNode[adjacentNode] = visitingNode;
                }
            }
            visitedNodes.add(visitingNode);
        }
        int[][] result = new int[2][numVertices];
        result[0] = costFromSrc;
        result[1] = prevNode;
        return result;
    }
}
