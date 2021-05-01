package com.michaelszymczak.training.grokalgo.chapter06;

class Queue
{
    private final int[] elements = new int[2];
    private int tail = 0;
    private int head = 0;
    private int size = 0;

    public boolean isEmpty()
    {
        return size == 0;
    }

    public int pop()
    {
        if (isEmpty())
        {
            throw new IllegalStateException("The queue is empty");
        }
        int element = elements[head];
        head = (head + 1) % 2;
        size--;
        return element;
    }

    public void push(final int element)
    {
        if (size == 2)
        {
            throw new IllegalStateException("The queue is full");
        }
        elements[tail] = element;
        tail = (tail + 1) % 2;
        size++;
    }
}
