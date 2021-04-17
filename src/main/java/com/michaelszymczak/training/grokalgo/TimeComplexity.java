package com.michaelszymczak.training.grokalgo;

public interface TimeComplexity
{
    TimeComplexity IGNORE_TIME_COMPLEXITY = new TimeComplexity()
    {

        @Override
        public void onOperation()
        {

        }

        @Override
        public TimeComplexity reset()
        {
            return this;
        }
    };

    void onOperation();

    TimeComplexity reset();
}
