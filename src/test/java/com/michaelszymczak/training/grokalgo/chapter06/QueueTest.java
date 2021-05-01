package com.michaelszymczak.training.grokalgo.chapter06;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class QueueTest
{
    @Test
    void shouldBeEmptyInitially()
    {
        Queue queue = new Queue();
        assertThat(queue.isEmpty()).isTrue();
        assertThatThrownBy(queue::pop).isInstanceOf(IllegalStateException.class);
    }

    private static class Queue
    {
        public boolean isEmpty()
        {
            return true;
        }

        public int pop()
        {
            throw new IllegalStateException("The queue is empty");
        }
    }
}
