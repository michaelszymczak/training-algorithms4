package com.michaelszymczak.training.grokalgo.chapter06;

class Queue
{
    private int element = 0;
    private int element2 = 0;
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
        return element;
    }

    public void push(final int element)
    {
        if (isEmpty)
        {
            this.element = element;
        }
        else
        {
            this.element2 = element;
        }
        isEmpty = false;

    }
}
