package com.michaelszymczak.training.grokalgo.chapter06;

final public class BFS extends GraphSearchAlgo implements GraphSearch
{
    private final GraphSearchAlgo algo = new GraphSearchAlgo();

    @Override
    public boolean pathExists(final int[][] graph, final int startNode, final int endNode)
    {
        return algo.pathExists(graph, startNode, endNode);
    }
}
