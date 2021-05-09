package com.michaelszymczak.training.grokalgo.chapter07;

import com.michaelszymczak.training.grokalgo.chapter06.Path;
import com.michaelszymczak.training.grokalgo.chapter06.Set;


import static com.michaelszymczak.training.grokalgo.chapter06.Path.NO_NODE;


public class DijkstraSearch
{
    public static final int NO_EDGE = Integer.MIN_VALUE;

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
                boolean hasEdge = originNodeNeighbours[targetNode] != NO_EDGE;
                if (hasEdge)
                {
                    path.addParent(targetNode, node);
                }
            }
        }

        return path.generate(startNode, endNode);
    }

    private int nextNodeToCheck(int[] nodeCosts, Set nodesWithLowestCostCalculated)
    {
        for (int edge = 0; edge < nodeCosts.length; edge++)
        {
            if (!nodesWithLowestCostCalculated.contains(edge))
            {
                nodesWithLowestCostCalculated.add(edge);
                return edge;
            }
        }
        return NO_NODE;
    }
}
