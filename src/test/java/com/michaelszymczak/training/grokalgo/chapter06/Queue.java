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
        return elements[head++ % 2];
    }

    public void push(final int element)
    {
        if (!isEmpty() && tail % 2 == head)
        {
            throw new IllegalStateException("The queue is full");
        }
        elements[tail++ % 2] = element;
    }
}
