package com.michaelszymczak.training.grokalgo.chapter06;

public final class Stack implements Queue
{
    private final boolean resizeable;
    private int[] elements;
    private int capacity;
    private int size = 0;

    public Stack(final int capacity)
    {
        this(capacity, false);
    }

    public Stack(final int capacity, final boolean resizeable)
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
            throw new IllegalStateException("The stack is full");
        }
        elements[size++] = element;
    }

    @Override
    public int pop()
    {
        if (isEmpty())
        {
            throw new IllegalStateException("The stack is empty");
        }
        return elements[size-- - 1];
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

    @Override
    public int size()
    {
        return size;
    }
}
