package com.michaelszymczak.training.grokalgo;

public class TimeComplexityTracker implements TimeComplexity
{
    private static final double TOLERANCE = 0.2;
    private int ops = 0;

    @Override
    public void onOperation()
    {
        ops++;
    }

    @Override
    public TimeComplexityTracker reset()
    {
        ops = 0;
        return this;
    }

    public boolean probablyLogN(final int inputSize)
    {
        return matchesOpsCount((int)(Math.log(inputSize) / Math.log(2)));
    }

    public boolean probablyN(final int inputSize)
    {
        return matchesOpsCount(inputSize);
    }

    private boolean matchesOpsCount(final int expectedOps)
    {
        int lowerBound = (int)(ops - (ops * TOLERANCE));
        int upperBound = (int)(ops + (ops * TOLERANCE));
        return expectedOps >= lowerBound && expectedOps <= upperBound;
    }
}
