package com.michaelszymczak.training.grokalgo.chapter06;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


import static java.util.stream.IntStream.range;

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

    @Test
    void shouldRemoveElementRegardlesHowManyTimesAdded()
    {
        Set set = new Set();
        set.add(1);
        set.add(1);
        set.remove(1);

        assertThat(set.contains(1)).isFalse();
    }

    @Test
    void shouldAllowAddingManyElements()
    {
        Set set = new Set();
        range(0, 100).forEach(set::add);

        range(0, 100).forEach(value -> assertThat(set.contains(value)));
    }

    @Test
    void shouldAllowAddingElementsOfAnyValue()
    {
        Set set = new Set();
        set.add(0);
        set.add(Integer.MAX_VALUE);
        set.add(-100);
        set.add(100_000);
        set.add(Integer.MIN_VALUE);

        assertThat(set.contains(0)).isTrue();
        assertThat(set.contains(Integer.MAX_VALUE)).isTrue();
        assertThat(set.contains(-100)).isTrue();
        assertThat(set.contains(100_000)).isTrue();
        assertThat(set.contains(Integer.MIN_VALUE)).isTrue();
    }

    private static class Set
    {
        private final boolean[] elements = new boolean[10];

        public boolean contains(final int element)
        {
            return elements[hash(element)];
        }

        public void add(final int element)
        {
            elements[hash(element)] = true;
        }

        public void remove(final int element)
        {
            elements[hash(element)] = false;
        }

        private int hash(final int element)
        {
            return element == Integer.MIN_VALUE ? 0 : (Math.abs(element) % 10);
        }
    }
}
