package com.michaelszymczak.training.grokalgo;

public class TimeComplexityTracker implements TimeComplexity
{
    private int ops = 0;
    @Override
    public void onOperation()
    {
        ops++;
    }

    @Override
    public void reset()
    {
        ops = 0;
    }

    public int operationsCount()
    {
        return ops;
    }
}
