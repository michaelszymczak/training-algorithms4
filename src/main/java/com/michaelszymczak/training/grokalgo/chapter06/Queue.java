package com.michaelszymczak.training.grokalgo.chapter06;

class Queue
{
    private int[] elements;
    private int capacity;
    private final boolean resizeable;

    private int tail = 0;
    private int head = 0;
    private int size = 0;

    public Queue(final int capacity)
    {
        this(capacity, false);
    }

    public Queue(final int capacity, final boolean resizeable)
    {
        this.elements = new int[capacity];
        this.capacity = capacity;
        this.resizeable = resizeable;
    }

    public void push(final int element)
    {
        if (size == capacity - 1 && resizeable)
        {
            int newCapacity = this.capacity * 2;
            int[] newElements = new int[newCapacity];
            System.arraycopy(this.elements, 0, newElements, 0, this.capacity);
            this.capacity = newCapacity;
            this.elements = newElements;

        }
        if (isFull())
        {
            throw new IllegalStateException("The queue is full");
        }
        elements[tail] = element;
        tail = (tail + 1) % capacity;
        size++;
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

    public boolean isEmpty()
    {
        return size == 0;
    }

    public boolean isFull()
    {
        return size == capacity;
    }
}
