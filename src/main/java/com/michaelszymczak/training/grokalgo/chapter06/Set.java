package com.michaelszymczak.training.grokalgo.chapter06;

import static java.lang.System.arraycopy;
import static java.util.Arrays.fill;

class Set
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
            fill(biggerBucket, bucket.length, biggerBucket.length, SENTINEL);
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
