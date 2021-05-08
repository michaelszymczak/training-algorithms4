package com.michaelszymczak.training.grokalgo.chapter07;

import java.util.Arrays;

import com.michaelszymczak.training.grokalgo.chapter06.Queue;
import com.michaelszymczak.training.grokalgo.chapter06.Stack;

public class DijkstraSearch
{
    public int[] shortestPath(final int[][] graph, final int startNode, final int endNode)
    {
        for (final int[] ints : graph)
        {
            if (ints.length != graph.length)
            {
                throw new IllegalArgumentException("The graph should be in the adjacency matrix format");
            }
        }
        final int[] parents = new int[graph.length];
        Arrays.fill(parents, Integer.MIN_VALUE);
        if (graph.length == 0)
        {
            return new int[0];
        }
        for (int originNodeIndex = 0; originNodeIndex < graph.length; originNodeIndex++)
        {
            int[] originNodeNeighbours = graph[originNodeIndex];
            for (int targetNodeIndex = 0; targetNodeIndex < originNodeNeighbours.length; targetNodeIndex++)
            {
                boolean hasEdge = originNodeNeighbours[targetNodeIndex] != Integer.MIN_VALUE;
                if (hasEdge)
                {
                    parents[targetNodeIndex] = originNodeIndex;
                }
            }
        }
        return constructPath(parents, startNode, endNode);
    }

    private int[] constructPath(final int[] parents, final int startNode, final int endNode)
    {
        final Queue path = new Stack(10, true);
        int currentNode = endNode;
        while (true)
        {
            if (currentNode == Integer.MIN_VALUE)
            {
                return new int[0];
            }
            path.push(currentNode);
            if (currentNode == startNode)
            {
                break;
            }
            currentNode = parents[currentNode];
        }

        final int pathSize = path.size();
        final int[] result = new int[pathSize];
        for (int i = 0; i < pathSize; i++)
        {
            result[i] = path.pop();
        }
        return result;
    }
}
