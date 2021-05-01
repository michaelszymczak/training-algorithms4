package com.michaelszymczak.training.grokalgo.chapter06;

class Queue
{
    private final int[] elements = new int[2];
    private int tail = 0;
    private int head = 0;

    public boolean isEmpty()
    {
        return head == tail;
    }

    public int pop()
    {
        if (isEmpty())
        {
            throw new IllegalStateException("The queue is empty");
        }
        return elements[head++];
    }

    public void push(final int element)
    {
        elements[tail++ % 2] = element;
    }
}
