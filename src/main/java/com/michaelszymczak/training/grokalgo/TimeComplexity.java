package com.michaelszymczak.training.grokalgo;

public interface TimeComplexity
{
    void onOperation();

    void reset();

    TimeComplexity IGNORE_TIME_COMPLEXITY = new TimeComplexity()
    {

        @Override
        public void onOperation()
        {

        }

        @Override
        public void reset()
        {

        }
    };
}
