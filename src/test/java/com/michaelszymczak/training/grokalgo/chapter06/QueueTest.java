package com.michaelszymczak.training.grokalgo.chapter06;

import java.util.concurrent.ThreadLocalRandom;

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

        private final int firstElement = ThreadLocalRandom.current().nextInt(100);

        @BeforeEach
        void setUp()
        {
            queue.push(firstElement);
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
            assertThat(queue.pop()).isEqualTo(firstElement);
        }

        @Nested
        class GivenTwoElements
        {
            private final int secondElement = firstElement + 1;

            @BeforeEach
            void setUp()
            {
                queue.push(secondElement);
            }

            @Test
            void shouldReturnFirstAddedElement()
            {
                assertThat(queue.pop()).isEqualTo(firstElement);
            }


            @Nested
            class GivenOneElementRemoved
            {
                @BeforeEach
                void setUp()
                {
                    queue.pop();
                }

                @Test
                void shouldNotBeEmpty()
                {
                    assertThat(queue.isEmpty()).isFalse();
                }

                @Test
                void shouldReturnSecondAddedElement()
                {
                    assertThat(queue.pop()).isEqualTo(secondElement);
                }

                @Nested
                class GivenLastElementRemoved
                {
                    @BeforeEach
                    void setUp()
                    {
                        queue.pop();
                    }

                    @Test
                    void shouldBeEmptyAgain()
                    {
                        assertThat(queue.isEmpty()).isTrue();
                    }
                }
            }
        }
    }
}
