package com.michaelszymczak.training.grokalgo.chapter07;

import com.michaelszymczak.training.grokalgo.chapter06.FifoQueue;
import com.michaelszymczak.training.grokalgo.chapter06.Queue;

public class DijkstraSearch
{
    public int[] shortestPath(final int[][] graph, final int startNode, final int endNode)
    {
        if (graph.length == 0)
        {
            return new int[0];
        }
        final Queue queue = new FifoQueue(10, true);
        for (int i = 0; i < graph.length; i++)
        {
            int[] origin = graph[i];
            for (int j = 0; j < origin.length; j++)
            {
                int costToTarget = origin[j];
                if (costToTarget != Integer.MIN_VALUE)
                {
                    queue.push(i);
                    if (i != j)
                    {
                        queue.push(j);
                    }
                }
            }
        }

        int size = queue.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++)
        {
            result[i] = queue.pop();
        }
        return result;
    }
}
