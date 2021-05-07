package com.michaelszymczak.training.grokalgo.chapter06;

public class GraphSearchAlgo
{
    private final SearchType searchType;
    private final int capacity;
    private final boolean resizeable;

    public GraphSearchAlgo(final SearchType searchType, final int capacity, final boolean resizeable)
    {
        this.searchType = searchType;
        this.capacity = capacity;
        this.resizeable = resizeable;
    }

    public boolean pathExists(final int[][] graph, final int startNode, final int endNode)
    {
        if (Math.max(startNode, endNode) > graph.length - 1)
        {
            return false;
        }
        final Queue queue = searchType.createQueue(capacity, resizeable);
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

    enum SearchType
    {
        BREADTH_FIRST
                {
                    Queue createQueue(int capacity, boolean resizeable)
                    {
                        return new FifoQueue(capacity, resizeable);
                    }
                },
        DEPTH_FIRST
                {
                    Queue createQueue(int capacity, boolean resizeable)
                    {
                        return new Stack(capacity, resizeable);
                    }
                };

        abstract Queue createQueue(int capacity, boolean resizeable);
    }
}
