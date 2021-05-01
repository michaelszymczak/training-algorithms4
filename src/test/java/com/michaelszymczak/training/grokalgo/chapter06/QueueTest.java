package com.michaelszymczak.training.grokalgo.chapter06;

import java.util.concurrent.ThreadLocalRandom;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class QueueTest
{
    private static final int A = ThreadLocalRandom.current().nextInt(100);
    private static final int B = A + 1;
    private static final int C = B + 1;

    private final Queue queue = new Queue();


    @Test
    void shouldBeEmptyInitially()
    {
        assertThat(queue.isEmpty()).isTrue();
        assertThat(queue.isFull()).isFalse();
        assertThatThrownBy(queue::pop).isInstanceOf(IllegalStateException.class);
    }

    @Nested
    class GivenA
    {
        @BeforeEach
        void setUp()
        {
            queue.push(A);
        }

        @Test
        void shouldNotBeEmpty()
        {
            assertThat(queue.isEmpty()).isFalse();
        }

        @Test
        void shouldNotBeFull()
        {
            assertThat(queue.isFull()).isFalse();
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
            assertThat(queue.pop()).isEqualTo(A);
        }

        @Nested
        class GivenAB
        {
            @BeforeEach
            void setUp()
            {
                queue.push(B);
            }

            @Test
            void shouldBeFull()
            {
                assertThat(queue.isFull()).isTrue();
            }

            @Test
            void shouldReturnFirstAddedElement()
            {
                assertThat(queue.pop()).isEqualTo(A);
            }

            @Test
            void shouldNotAllowNewElements()
            {
                assertThatThrownBy(() -> queue.push(C)).isInstanceOf(IllegalStateException.class);

                assertThat(queue.pop()).isEqualTo(A);
            }

            @Nested
            class GivenB
            {
                @BeforeEach
                void setUp()
                {
                    queue.pop();
                }

                @Test
                void shouldNotBeFull()
                {
                    assertThat(queue.isFull()).isFalse();
                }

                @Test
                void shouldNotBeEmpty()
                {
                    assertThat(queue.isEmpty()).isFalse();
                }

                @Test
                void shouldReturnSecondAddedElement()
                {
                    assertThat(queue.pop()).isEqualTo(B);
                }

                @Nested
                class Given_
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

                    @Test
                    void shouldNotBeFull()
                    {
                        assertThat(queue.isFull()).isFalse();
                    }
                }

                @Nested
                class GivenBC
                {
                    @BeforeEach
                    void setUp()
                    {
                        queue.push(C);
                    }

                    @Test
                    void shouldReturnSecondAddedElement()
                    {
                        assertThat(queue.pop()).isEqualTo(B);
                    }

                    @Nested
                    class GivenC
                    {
                        @BeforeEach
                        void setUp()
                        {
                            queue.pop();
                        }

                        @Test
                        void shouldReturnLastAddedElement()
                        {
                            assertThat(queue.pop()).isEqualTo(C);
                        }
                    }
                }
            }
        }
    }
}
