package com.michaelszymczak.training.grokalgo.chapter06;

final class FifoQueue implements Queue
{
    private final boolean resizeable;
    private int[] elements;
    private int capacity;
    private int tail = 0;
    private int head = 0;
    private int size = 0;

    public FifoQueue(final int capacity)
    {
        this(capacity, false);
    }

    public FifoQueue(final int capacity, final boolean resizeable)
    {
        this.elements = new int[capacity];
        this.capacity = capacity;
        this.resizeable = resizeable;
    }

    @Override
    public void push(final int element)
    {
        if (size == capacity - 1 && resizeable)
        {
            int newCapacity = capacity * 2;
            int[] newElements = new int[newCapacity];
            System.arraycopy(elements, 0, newElements, 0, capacity);
            capacity = newCapacity;
            elements = newElements;
        }
        if (isFull())
        {
            throw new IllegalStateException("The queue is full");
        }
        elements[tail] = element;
        tail = (tail + 1) % capacity;
        size++;
    }

    @Override
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

    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    @Override
    public boolean isFull()
    {
        return size == capacity;
    }
}
