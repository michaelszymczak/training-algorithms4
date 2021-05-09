package com.michaelszymczak.training.grokalgo.chapter07;

import java.util.Arrays;

import com.michaelszymczak.training.grokalgo.chapter06.Path;
import com.michaelszymczak.training.grokalgo.chapter06.Set;


import static com.michaelszymczak.training.grokalgo.chapter06.Path.NO_NODE;


public class DijkstraSearch
{
    public static final int NO_EDGE = Integer.MIN_VALUE;

    private static int nextNodeToCheck(int[] nodeCosts, Set visitedNodes)
    {
        int lowestCost = Integer.MAX_VALUE;
        int cheapestNode = NO_NODE;
        for (int node = 0; node < nodeCosts.length; node++)
        {
            if (!visitedNodes.contains(node) && nodeCosts[node] < lowestCost)
            {
                lowestCost = nodeCosts[node];
                cheapestNode = node;
            }
        }
        visitedNodes.add(cheapestNode);
        return cheapestNode;
    }

    public int[] shortestPath(final int[][] graph, final int startNode, final int endNode)
    {
        for (final int[] ints : graph)
        {
            if (ints.length != graph.length)
            {
                throw new IllegalArgumentException("The graph should be in the adjacency matrix format");
            }
        }
        if (startNode >= graph.length || endNode >= graph.length)
        {
            return Path.NO_PATH;
        }
        if (graph.length == 0)
        {
            return Path.NO_PATH;
        }
        final Path path = new Path(graph.length);
        final int[] nodeCosts = new int[graph.length];
        Arrays.fill(nodeCosts, Integer.MAX_VALUE);
        nodeCosts[startNode] = 0;
        final Set nodesChecked = new Set();

        int node;
        while (true)
        {
            node = nextNodeToCheck(nodeCosts, nodesChecked);
            if (node == NO_NODE)
            {
                break;
            }
            int[] originNodeNeighbours = graph[node];
            for (int targetNode = 0; targetNode < originNodeNeighbours.length; targetNode++)
            {
                int edgeWeight = originNodeNeighbours[targetNode];
                boolean hasEdge = edgeWeight != NO_EDGE;
                if (hasEdge && nodeCosts[targetNode] > nodeCosts[node] + edgeWeight)
                {
                    nodeCosts[targetNode] = nodeCosts[node] + edgeWeight;
                    path.addParent(targetNode, node);
                }
            }
        }

        return path.generate(startNode, endNode);
    }
}
