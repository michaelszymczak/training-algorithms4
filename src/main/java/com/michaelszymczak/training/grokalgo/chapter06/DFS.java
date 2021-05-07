package com.michaelszymczak.training.grokalgo.chapter06;

final public class DFS implements GraphSearch
{
    private final GraphSearchAlgo algo = new GraphSearchAlgo(true);

    @Override
    public boolean pathExists(final int[][] graph, final int startNode, final int endNode)
    {
        return algo.pathExists(graph, startNode, endNode);
    }
}
