package com.michaelszymczak.training.grokalgo;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Fixtures
{

    public static int[] generate(final int minValue, final int maxValue, final int size)
    {
        final ThreadLocalRandom random = ThreadLocalRandom.current();
        return IntStream.generate(() -> random.nextInt(minValue, maxValue + 1)).limit(size).toArray();
    }

    public static int[] copy(final int[] input)
    {
        final int[] inputCopy = new int[input.length];
        System.arraycopy(input, 0, inputCopy, 0, input.length);
        return inputCopy;
    }
}
