package com.michaelszymczak.training.grokalgo.chapter07;

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
        if (graph.length == 0)
        {
            return new int[0];
        }
        if (graph[startNode][endNode] != Integer.MIN_VALUE)
        {
            if (startNode == endNode)
            {
                return new int[]{startNode};
            }
            else
            {
                return new int[]{startNode, endNode};
            }
        }
        return new int[0];
    }
}
