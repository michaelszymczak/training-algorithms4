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
        final Queue queue = new Queue(10);
        for (int i = 0; i < graph[startNode].length; i++)
        {
            queue.push(graph[startNode][i]);
        }
        while (!queue.isEmpty())
        {
            int nodeToCheck = queue.pop();
            if (nodeToCheck == endNode)
            {
                return new int[]{startNode, endNode};
            }
        }

        return NO_PATH;
    }
}
