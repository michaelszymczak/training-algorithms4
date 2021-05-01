package com.michaelszymczak.training.grokalgo.chapter06;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest
{
    @Test
    void shouldNotContainAnyElementsInitially()
    {
        assertThat(new Set().contains(4)).isFalse();
    }

    @Test
    void shouldContainAddedElement()
    {
        Set set = new Set();
        set.add(4);

        assertThat(set.contains(4)).isTrue();
    }

    @Test
    void shouldNotContainRemovedElement()
    {
        Set set = new Set();
        set.add(4);
        set.remove(4);

        assertThat(set.contains(4)).isFalse();
    }

    @Test
    void shouldNotContainElementNotAdded()
    {
        Set set = new Set();
        set.add(5);

        assertThat(set.contains(4)).isFalse();
    }

    @Test
    void shouldContainBothAddedElements()
    {
        Set set = new Set();
        set.add(1);
        set.add(2);

        assertThat(set.contains(1)).isTrue();
        assertThat(set.contains(2)).isTrue();
    }

    private static class Set
    {
        private final int[] elements = new int[2];
        private int size = 0;

        public boolean contains(final int element)
        {
            for (int i = 0; i < size; i++)
            {
                if (elements[i] == element)
                {
                    return true;
                }
            }
            return false;
        }

        public void add(final int element)
        {
            elements[size++] = element;
        }

        public void remove(final int element)
        {
            for (int i = 0; i < size; i++)
            {
                if (elements[i] == element)
                {
                    elements[i] = 0;
                }
            }
        }
    }
}
