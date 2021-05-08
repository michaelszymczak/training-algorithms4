package com.michaelszymczak.training.grokalgo.chapter06;

import java.util.Arrays;

public class Path
{
    private static final int NO_NODE = -1;
    public static int[] NO_PATH = new int[0];
    private final int[] parents;

    public Path(final int length)
    {
        this.parents = new int[length];
        Arrays.fill(parents, NO_NODE);
    }

    public int[] generate(final int startNode, final int endNode)
    {
        final Stack pathBuilder = new Stack(10, true);
        int currentNode = endNode;
        while (true)
        {
            if (currentNode == NO_NODE)
            {
                return NO_PATH;
            }
            pathBuilder.push(currentNode);
            if (currentNode == startNode)
            {
                break;
            }
            currentNode = parents[currentNode];
        }

        final int pathSize = pathBuilder.size();
        final int[] result = new int[pathSize];
        for (int i = 0; i < pathSize; i++)
        {
            result[i] = pathBuilder.pop();
        }
        return result;
    }

    public void addParent(final int node, final int parent)
    {
        parents[node] = parent;
    }
}
