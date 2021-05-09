package com.michaelszymczak.training.grokalgo.chapter07;

import java.util.Arrays;

import com.michaelszymczak.training.grokalgo.chapter06.Path;
import com.michaelszymczak.training.grokalgo.chapter06.Set;


import static com.michaelszymczak.training.grokalgo.chapter06.Path.NO_NODE;


public class DijkstraSearch
{
    public static final int NO_EDGE = Integer.MIN_VALUE;

    private static final int UNREACHABLE = Integer.MAX_VALUE;

    private static int findNextConfirmedCheapestToReachNode(int[] nodeCosts, Set nodesWithFinalCostConfirmed)
    {
        int lowestCost = UNREACHABLE;
        int cheapestNode = NO_NODE;
        for (int node = 0; node < nodeCosts.length; node++)
        {
            if (!nodesWithFinalCostConfirmed.contains(node) && nodeCosts[node] < lowestCost)
            {
                lowestCost = nodeCosts[node];
                cheapestNode = node;
            }
        }
        nodesWithFinalCostConfirmed.add(cheapestNode);
        return cheapestNode;
    }

    private static int[] initializeRunningCosts(final int[][] graph, final int startNode)
    {
        final int[] runningNodeCosts = new int[graph.length];
        Arrays.fill(runningNodeCosts, UNREACHABLE);
        runningNodeCosts[startNode] = 0;
        return runningNodeCosts;
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

        final Path path = new Path(graph.length);
        final Set nodesWithFinalCostConfirmed = new Set();
        final int[] runningNodeCosts = initializeRunningCosts(graph, startNode);
        int node;
        while (true)
        {
            node = findNextConfirmedCheapestToReachNode(runningNodeCosts, nodesWithFinalCostConfirmed);
            if (node == NO_NODE)
            {
                break;
            }
            int[] originNodeNeighbours = graph[node];
            for (int targetNode = 0; targetNode < originNodeNeighbours.length; targetNode++)
            {
                int edgeWeight = originNodeNeighbours[targetNode];
                boolean hasEdge = edgeWeight != NO_EDGE;
                if (hasEdge && runningNodeCosts[targetNode] > runningNodeCosts[node] + edgeWeight)
                {
                    runningNodeCosts[targetNode] = runningNodeCosts[node] + edgeWeight;
                    path.addParent(targetNode, node);
                }
            }
        }

        return path.generate(startNode, endNode);
    }
}
