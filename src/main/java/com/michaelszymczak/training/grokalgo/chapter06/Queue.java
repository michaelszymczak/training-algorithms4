package com.michaelszymczak.training.grokalgo.chapter06;

public interface Queue
{
    void push(int element);

    int pop();

    boolean isEmpty();

    boolean isFull();

    int size();
}
