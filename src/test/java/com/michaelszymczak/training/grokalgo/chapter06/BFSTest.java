package com.michaelszymczak.training.grokalgo.chapter06;

public class BFSTest extends GraphSearchTest
{
    @Override
    protected GraphSearch graphSearch()
    {
        return new BFS();
    }
}
