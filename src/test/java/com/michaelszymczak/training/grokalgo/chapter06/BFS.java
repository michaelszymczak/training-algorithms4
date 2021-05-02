package com.michaelszymczak.training.grokalgo.chapter06;

public class BFS
{

    public static final int[] NO_PATH = new int[0];

    public int[] shortestPath(final int[][] graph, final int startNode, final int endNode)
    {
        if (graph.length < startNode + 1)
        {
            return NO_PATH;
        }
        if (endNode == startNode)
        {
            return new int[]{startNode};
        }
        for (int i = 0; i < graph[startNode].length; i++)
        {
            if (graph[startNode][i] == endNode)
            {
                return new int[]{startNode, endNode};
            }
        }

        return NO_PATH;
    }
}
