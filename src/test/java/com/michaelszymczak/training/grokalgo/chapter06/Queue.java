package com.michaelszymczak.training.grokalgo.chapter06;

class Queue
{

    private boolean isEmpty = true;

    public boolean isEmpty()
    {
        return isEmpty;
    }

    public int pop()
    {
        if (isEmpty)
        {
            throw new IllegalStateException("The queue is empty");
        }
        isEmpty = true;
        return 5;
    }

    public void push(final int element)
    {
        isEmpty = false;
    }
}
