package com.michaelszymczak.training.grokalgo.chapter06;

final public class BFS implements GraphSearch
{
    private final GraphSearchAlgo algo = new GraphSearchAlgo(false);

    @Override
    public boolean pathExists(final int[][] graph, final int startNode, final int endNode)
    {
        return algo.pathExists(graph, startNode, endNode);
    }
}
