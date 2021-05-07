package com.michaelszymczak.training.grokalgo.chapter06;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StackResizeTest
{
    @Test
    void shouldPreventResizingIfNotConfiguredToDoSo()
    {
        final Stack stack = new Stack(1, false);
        stack.push(0);

        assertThat(stack.isFull()).isTrue();
        assertThatThrownBy(() -> stack.push(1)).isInstanceOf(IllegalStateException.class);
    }

    @Test
    void shouldBeNeverFullIfResizeable()
    {
        final Stack stack = new Stack(2, true);
        IntStream.range(0, 100).forEach(
                value ->
                {
                    assertThat(stack.isFull()).isFalse();
                    stack.push(99 - value);
                });
        IntStream.range(0, 100).forEach(value -> assertThat(stack.pop()).isEqualTo(value));
        assertThat(stack.isEmpty()).isTrue();
    }

    @Test
    void shouldExpandBeyondInitialCapacity()
    {
        final Stack stack = new Stack(2, true);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertThat(stack.pop()).isEqualTo(3);
        assertThat(stack.pop()).isEqualTo(2);
        assertThat(stack.pop()).isEqualTo(1);
    }
}
