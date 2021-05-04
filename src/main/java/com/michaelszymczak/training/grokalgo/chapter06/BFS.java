package com.michaelszymczak.training.grokalgo.chapter06;

final public class BFS
{
    public boolean pathExists(final int[][] graph, final int startNode, final int endNode)
    {
        if (Math.max(startNode, endNode) > graph.length - 1)
        {
            return false;
        }

        final Queue queue = new Queue(10, true);
        final Set set = new Set();
        int nodeToCheck = startNode;
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
