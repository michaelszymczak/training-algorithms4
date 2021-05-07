package com.michaelszymczak.training.grokalgo.chapter06;

import java.util.concurrent.ThreadLocalRandom;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StackTest
{
    private static final int A = ThreadLocalRandom.current().nextInt(100);
    private static final int B = A + 1;
    private static final int C = B + 1;

    private final Stack stack = new Stack(2);

    @Test
    void shouldBeEmptyInitially()
    {
        assertThat(stack.isEmpty()).isTrue();
        assertThat(stack.isFull()).isFalse();
        assertThatThrownBy(stack::pop).isInstanceOf(IllegalStateException.class);
    }

    @Nested
    class GivenA
    {
        @BeforeEach
        void setUp()
        {
            stack.push(A);
        }

        @Test
        void shouldNotBeEmpty()
        {
            assertThat(stack.isEmpty()).isFalse();
        }

        @Test
        void shouldNotBeFull()
        {
            assertThat(stack.isFull()).isFalse();
        }

        @Test
        void shouldBeEmptyAfterRemovingTheElement()
        {
            stack.pop();
            assertThat(stack.isEmpty()).isTrue();
        }

        @Test
        void shouldReturnTheElement()
        {
            assertThat(stack.pop()).isEqualTo(A);
        }

        @Nested
        class GivenAB
        {
            @BeforeEach
            void setUp()
            {
                stack.push(B);
            }

            @Test
            void shouldBeFull()
            {
                assertThat(stack.isFull()).isTrue();
            }

            @Test
            void shouldReturnLastAddedElement()
            {
                assertThat(stack.pop()).isEqualTo(B);
            }

            @Test
            void shouldNotAllowNewElements()
            {
                assertThatThrownBy(() -> stack.push(C)).isInstanceOf(IllegalStateException.class);

                assertThat(stack.pop()).isEqualTo(B);
            }

            @Nested
            class GivenAAgain
            {
                @BeforeEach
                void setUp()
                {
                    stack.pop();
                }

                @Test
                void shouldNotBeFull()
                {
                    assertThat(stack.isFull()).isFalse();
                }

                @Test
                void shouldNotBeEmpty()
                {
                    assertThat(stack.isEmpty()).isFalse();
                }

                @Test
                void shouldReturnFirstAddedElement()
                {
                    assertThat(stack.pop()).isEqualTo(A);
                }

                @Nested
                class Given_
                {
                    @BeforeEach
                    void setUp()
                    {
                        stack.pop();
                    }

                    @Test
                    void shouldBeEmptyAgain()
                    {
                        assertThat(stack.isEmpty()).isTrue();
                    }

                    @Test
                    void shouldNotBeFull()
                    {
                        assertThat(stack.isFull()).isFalse();
                    }
                }

                @Nested
                class GivenAC
                {
                    @BeforeEach
                    void setUp()
                    {
                        stack.push(C);
                    }

                    @Test
                    void shouldReturnLastAddedElement()
                    {
                        assertThat(stack.pop()).isEqualTo(C);
                    }

                    @Nested
                    class GivenAAgainAgain
                    {
                        @BeforeEach
                        void setUp()
                        {
                            stack.pop();
                        }

                        @Test
                        void shouldReturnLastAddedElement()
                        {
                            assertThat(stack.pop()).isEqualTo(A);
                        }
                    }
                }
            }
        }
    }
}
