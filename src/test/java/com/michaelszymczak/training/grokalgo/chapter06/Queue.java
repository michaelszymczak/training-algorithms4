package com.michaelszymczak.training.grokalgo.chapter06;

class Queue
{
    private int element = 0;
    private int size = 0;

    public boolean isEmpty()
    {
        return size == 0;
    }

    public int pop()
    {
        if (size == 0)
        {
            throw new IllegalStateException("The queue is empty");
        }
        size--;
        return element;
    }

    public void push(final int element)
    {
        if (size == 0)
        {
            this.element = element;
        }
        size++;
    }
}
