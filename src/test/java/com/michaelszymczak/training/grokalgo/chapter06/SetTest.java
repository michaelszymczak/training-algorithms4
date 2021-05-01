package com.michaelszymczak.training.grokalgo.chapter06;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


import static java.lang.System.arraycopy;
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

    @Test
    void shouldExpandBucketIfNecessary()
    {
        Set set = new Set(1, 1);
        set.add(0);
        assertThat(set.contains(1)).isFalse();

        set.add(1);

        assertThat(set.contains(1)).isTrue();
    }

    @Test
    void shouldKeepExistingElementsWhenBucketResized()
    {
        Set set = new Set(1, 1);
        set.add(1);
        assertThat(set.contains(1)).isTrue();

        set.add(2);

        assertThat(set.contains(1)).isTrue();
    }

    private static class Set
    {
        private static final int SENTINEL = Integer.MIN_VALUE;
        private final int bucketCount;
        private final int[] elements;
        private final int[][] buckets;
        private boolean containsSentinel = false;

        public Set()
        {
            this(10, 15);
        }

        public Set(final int bucketCount, final int initialBucketSize)
        {
            if (bucketCount < 1)
            {
                throw new IllegalArgumentException("Insufficient number of buckets");
            }
            if (initialBucketSize < 1)
            {
                throw new IllegalArgumentException("Insufficient initial bucket size");
            }
            this.bucketCount = bucketCount;
            this.buckets = new int[this.bucketCount][initialBucketSize];
            for (final int[] bucket : this.buckets)
            {
                fill(bucket, SENTINEL);
            }
            this.elements = new int[this.bucketCount];
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
                        elements[hash]++;
                        return;
                    }
                }
                int[] biggerBucket = new int[bucket.length * 2];
                arraycopy(bucket, 0, biggerBucket, 0, bucket.length);
                fill(biggerBucket, bucket.length, biggerBucket.length - 1, SENTINEL);
                buckets[hash] = biggerBucket;
                add(element);
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
            return Math.abs(element) % bucketCount;
        }
    }
}
