package com.michaelszymczak.training.grokalgo.chapter07;

import com.michaelszymczak.training.grokalgo.chapter06.Path;


public class DijkstraSearch
{
    public static final int NO_EDGE = Integer.MIN_VALUE;

    public int[] shortestPath(final int[][] graph, final int startNode, final int endNode)
    {
        for (final int[] ints : graph)
        {
            if (ints.length != graph.length)
            {
                throw new IllegalArgumentException("The graph should be in the adjacency matrix format");
            }
        }
        if (startNode >= graph.length || endNode >= graph.length)
        {
            return Path.NO_PATH;
        }
        if (graph.length == 0)
        {
            return Path.NO_PATH;
        }
        final Path path = new Path(graph.length);
        for (int originNodeIndex = 0; originNodeIndex < graph.length; originNodeIndex++)
        {
            int[] originNodeNeighbours = graph[originNodeIndex];
            for (int targetNodeIndex = 0; targetNodeIndex < originNodeNeighbours.length; targetNodeIndex++)
            {
                boolean hasEdge = originNodeNeighbours[targetNodeIndex] != NO_EDGE;
                if (hasEdge)
                {
                    path.addParent(targetNodeIndex, originNodeIndex);
                }
            }
        }
        return path.generate(startNode, endNode);
    }
}
