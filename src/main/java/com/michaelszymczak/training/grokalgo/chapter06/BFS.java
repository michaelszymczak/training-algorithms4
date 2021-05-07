package com.michaelszymczak.training.grokalgo.chapter06;

import static com.michaelszymczak.training.grokalgo.chapter06.GraphSearchAlgo.SearchType.BREADTH_FIRST;

final public class BFS implements GraphSearch
{
    private final GraphSearchAlgo algo = new GraphSearchAlgo(BREADTH_FIRST, 10, true);

    @Override
    public boolean pathExists(final int[][] graph, final int startNode, final int endNode)
    {
        return algo.pathExists(graph, startNode, endNode);
    }
}
