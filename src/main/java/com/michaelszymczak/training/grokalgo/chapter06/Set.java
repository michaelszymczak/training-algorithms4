package com.michaelszymczak.training.grokalgo.chapter06;

import static java.lang.System.arraycopy;

public final class Set
{
    private static final int SENTINEL = 0;
    private final int bucketCount;
    private final int[][] buckets;
    private final int[] elementsInBucket;
    private boolean containsSentinel = false;

    public Set()
    {
        this(128, 16);
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
        this.buckets = new int[bucketCount][initialBucketSize];
        this.elementsInBucket = new int[bucketCount];
    }

    public boolean contains(final int element)
    {
        return contains(element, hash(element));
    }

    private boolean contains(final int element, final int hash)
    {
        if (element == SENTINEL)
        {
            return containsSentinel;
        }

        final int[] bucket = buckets[hash];
        final int numberOfElementsInBucket = elementsInBucket[hash];
        for (int i = 0; i < numberOfElementsInBucket; i++)
        {
            int e = bucket[i];
            if (e == SENTINEL)
            {
                throw new IllegalStateException();
            }
            if (e == element)
            {
                return true;
            }
        }
        return false;
    }

    public Set add(final int element)
    {
        if (element == SENTINEL)
        {
            containsSentinel = true;
            return this;
        }
        final int hash = hash(element);
        if (!contains(element, hash))
        {
            int[] bucket = buckets[hash];
            for (int i = 0; i < bucket.length; i++)
            {
                if (bucket[i] == SENTINEL)
                {
                    bucket[i] = element;
                    elementsInBucket[hash]++;
                    return this;
                }
            }
            int[] biggerBucket = new int[bucket.length * 2];
            arraycopy(bucket, 0, biggerBucket, 0, bucket.length);
            buckets[hash] = biggerBucket;
            add(element);
        }
        return this;
    }

    public Set remove(final int element)
    {
        if (element == SENTINEL)
        {
            containsSentinel = false;
            return this;
        }
        final int hash = hash(element);
        if (contains(element, hash))
        {
            int[] bucket = buckets[hash];
            for (int i = 0; i < bucket.length; i++)
            {
                if (bucket[i] == element)
                {
                    int indexOfTheLastPresentElement = elementsInBucket[hash] - 1;
                    bucket[i] = bucket[indexOfTheLastPresentElement];
                    bucket[indexOfTheLastPresentElement] = SENTINEL;
                    elementsInBucket[hash]--;
                    break;
                }
            }
        }
        return this;
    }

    private int hash(final int element)
    {
        int hash = element % bucketCount;
        return hash < 0 ? -hash : hash;
    }
}
