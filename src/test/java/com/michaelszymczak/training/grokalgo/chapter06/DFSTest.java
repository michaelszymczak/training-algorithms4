package com.michaelszymczak.training.grokalgo.chapter06;

import org.junit.jupiter.api.Disabled;

@Disabled
public class DFSTest extends GraphSearchTest
{
    @Override
    protected GraphSearch graphSearch()
    {
        return new DFS();
    }
}
