package com.michaelszymczak.training.grokalgo.chapter06;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FifoQueueResizeTest
{
    @Test
    void shouldPreventResizingIfNotConfiguredToDoSo()
    {
        final FifoQueue queue = new FifoQueue(1, false);
        queue.push(0);

        assertThat(queue.isFull()).isTrue();
        assertThatThrownBy(() -> queue.push(1)).isInstanceOf(IllegalStateException.class);
    }

    @Test
    void shouldBeNeverFullIfResizeable()
    {
        final FifoQueue queue = new FifoQueue(2, true);
        IntStream.range(0, 100).forEach(
                value ->
                {
                    assertThat(queue.isFull()).isFalse();
                    queue.push(value);
                });
        IntStream.range(0, 100).forEach(value -> assertThat(queue.pop()).isEqualTo(value));
        assertThat(queue.isEmpty()).isTrue();
    }

    @Test
    void shouldExpandBeyondInitialCapacity()
    {
        final FifoQueue queue = new FifoQueue(2, true);
        queue.push(1);
        queue.push(2);
        queue.push(3);

        assertThat(queue.pop()).isEqualTo(1);
        assertThat(queue.pop()).isEqualTo(2);
        assertThat(queue.pop()).isEqualTo(3);
    }
}
