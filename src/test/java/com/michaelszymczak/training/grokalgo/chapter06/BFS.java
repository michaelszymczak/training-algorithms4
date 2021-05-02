package com.michaelszymczak.training.grokalgo.chapter06;

public class BFS
{
    public boolean pathExists(final int[][] graph, final int startNode, final int endNode)
    {
        if (graph.length < startNode + 1)
        {
            return false;
        }
        if (endNode == startNode)
        {
            return true;
        }
        final Queue queue = new Queue(10);
        final Set set = new Set();
        for (int i = 0; i < graph[startNode].length; i++)
        {
            queue.push(graph[startNode][i]);
        }
        while (!queue.isEmpty())
        {
            final int nodeToCheck = queue.pop();
            if (nodeToCheck == endNode)
            {
                return true;
            }
            else
            {
                for (int i = 0; i < graph[nodeToCheck].length; i++)
                {
                    int nextNodeToCheck = graph[nodeToCheck][i];
                    if (!set.contains(nextNodeToCheck))
                    {
                        queue.push(nextNodeToCheck);
                        set.add(nextNodeToCheck);
                    }
                }
            }
        }

        return false;
    }
}
