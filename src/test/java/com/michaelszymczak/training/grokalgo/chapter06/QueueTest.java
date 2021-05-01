package com.michaelszymczak.training.grokalgo.chapter06;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class QueueTest
{
    private final Queue queue = new Queue();

    @Test
    void shouldBeEmptyInitially()
    {
        assertThat(queue.isEmpty()).isTrue();
        assertThatThrownBy(queue::pop).isInstanceOf(IllegalStateException.class);
    }

    @Nested
    class GivenOneElement
    {

        private static final int ELEMENT = 5;

        @BeforeEach
        void setUp()
        {
            queue.push(ELEMENT);
        }

        @Test
        void shouldNotBeEmpty()
        {
            assertThat(queue.isEmpty()).isFalse();
        }

        @Test
        void shouldBeEmptyAfterRemovingTheElement()
        {
            queue.pop();
            assertThat(queue.isEmpty()).isTrue();
        }

        @Test
        void shouldReturnTheElement()
        {
            assertThat(queue.pop()).isEqualTo(ELEMENT);
        }
    }

}
