package com.michaelszymczak.training.grokalgo.chapter06;

public class BFS
{
    public boolean pathExists(final int[][] graph, final int startNode, final int endNode)
    {
        int nodeToCheck = startNode;
        if (graph.length < nodeToCheck + 1)
        {
            return false;
        }

        final Queue queue = new Queue(10);
        final Set set = new Set();

        while (true)
        {
            if (nodeToCheck == endNode)
            {
                return true;
            }

            for (int i = 0; i < graph[nodeToCheck].length; i++)
            {
                int nextNodeToCheck = graph[nodeToCheck][i];
                if (!set.contains(nextNodeToCheck))
                {
                    queue.push(nextNodeToCheck);
                    set.add(nextNodeToCheck);
                }
            }

            if (queue.isEmpty())
            {
                return false;
            }
            nodeToCheck = queue.pop();
        }
    }
}
