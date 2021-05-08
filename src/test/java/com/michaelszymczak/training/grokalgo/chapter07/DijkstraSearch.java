package com.michaelszymczak.training.grokalgo.chapter07;

public class DijkstraSearch
{
    public int[] shortestPath(final int[][] graph, final int startNode, final int endNode)
    {
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
