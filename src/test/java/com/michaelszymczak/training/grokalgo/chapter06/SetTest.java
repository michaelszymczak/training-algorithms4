package com.michaelszymczak.training.grokalgo.chapter06;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


import static java.util.Arrays.fill;
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

        range(0, 100).forEach(value -> assertThat(set.contains(value)).isTrue());
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

    @Test
    void shouldNotContainAnyValueApartExplicitlyAddedOnes()
    {
        Set set = new Set();
        range(-100, 100).forEach(set::add);

        range(-200, -100).forEach(value -> assertThat(set.contains(value)).isFalse());
        range(100, 200).forEach(value -> assertThat(set.contains(value)).isFalse());
        assertThat(set.contains(Integer.MAX_VALUE)).isFalse();
        assertThat(set.contains(100_000)).isFalse();
        assertThat(set.contains(Integer.MIN_VALUE)).isFalse();
    }

    private static class Set
    {
        private static final int SENTINEL = Integer.MIN_VALUE;
        private final int[] elements = new int[10];
        private final int[][] buckets = new int[10][15];
        private boolean containsSentinel = false;

        public Set()
        {
            for (final int[] bucket : buckets)
            {
                fill(bucket, SENTINEL);
            }
        }

        public boolean contains(final int element)
        {
            if (element == SENTINEL)
            {
                return containsSentinel;
            }
            final int hash = hash(element);
            if (elements[hash] == 0)
            {
                return false;
            }
            final int[] bucket = buckets[hash];
            for (final int e : bucket)
            {
                if (e == element)
                {
                    return true;
                }
            }
            return false;
        }

        public void add(final int element)
        {
            if (element == SENTINEL)
            {
                containsSentinel = true;
                return;
            }
            if (!contains(element))
            {
                int hash = hash(element);
                int[] bucket = buckets[hash];
                for (int i = 0; i < bucket.length; i++)
                {
                    if (bucket[i] == SENTINEL)
                    {
                        bucket[i] = element;
                        break;
                    }
                }
                elements[hash]++;
            }
        }

        public void remove(final int element)
        {
            if (element == SENTINEL)
            {
                containsSentinel = false;
                return;
            }
            if (contains(element))
            {
                int[] bucket = buckets[hash(element)];
                for (int i = 0; i < bucket.length; i++)
                {
                    if (bucket[i] == element)
                    {
                        bucket[i] = SENTINEL;
                        break;
                    }
                }
                elements[hash(element)]--;
            }
        }

        private int hash(final int element)
        {
            return Math.abs(element) % 10;
        }
    }
}
