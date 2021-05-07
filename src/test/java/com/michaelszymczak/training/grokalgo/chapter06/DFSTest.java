package com.michaelszymczak.training.grokalgo.chapter06;

public class DFSTest extends GraphSearchTest
{
    @Override
    protected GraphSearch graphSearch()
    {
        return new DFS();
    }
}
