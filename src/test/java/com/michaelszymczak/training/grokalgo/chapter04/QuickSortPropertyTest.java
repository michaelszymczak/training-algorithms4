package com.michaelszymczak.training.grokalgo.chapter04;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import com.michaelszymczak.training.grokalgo.Fixtures;
import com.michaelszymczak.training.grokalgo.Properties;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

public class QuickSortPropertyTest
{
    private final QuickSort sort = new QuickSort();

    static Stream<int[]> unsortedInput()
    {
        return Stream.of(
                Fixtures.generate(Integer.MIN_VALUE, Integer.MAX_VALUE - 1, ThreadLocalRandom.current().nextInt(1000)),
                Fixtures.generate(-2, 2, ThreadLocalRandom.current().nextInt(1000)),
                Fixtures.generate(0, 1, ThreadLocalRandom.current().nextInt(1000))
        );
    }

    @ParameterizedTest
    @MethodSource("unsortedInput")
    void shouldReturnMonotonicallyIncreasingArray(final int[] input)
    {
        final int[] inputCopy = Fixtures.copy(input);

        // When
        int[] result = sort.sorted(input);

        // Then
        assertThat(result.length).isEqualTo(input.length).describedAs("property: length is the same as the input");
        assertThat(input).isEqualTo(inputCopy).describedAs("property: input array is not modified");
        Properties.assertMonotonicallyIncreasing(result);
        Properties.assertValuesAddUp(input, result);
    }
}
