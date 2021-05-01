package com.michaelszymczak.training.grokalgo.chapter06;

class Queue
{
    private final int[] elements;
    private final int capacity;
    private int tail = 0;
    private int head = 0;
    private int size = 0;

    public Queue(final int capacity)
    {
        this.elements = new int[capacity];
        this.capacity = capacity;
    }

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
        head = (head + 1) % capacity;
        size--;
        return element;
    }

    public void push(final int element)
    {
        if (isFull())
        {
            throw new IllegalStateException("The queue is full");
        }
        elements[tail] = element;
        tail = (tail + 1) % capacity;
        size++;
    }

    public boolean isFull()
    {
        return size == capacity;
    }
}
