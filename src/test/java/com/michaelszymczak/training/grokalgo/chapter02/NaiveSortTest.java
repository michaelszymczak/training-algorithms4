package com.michaelszymczak.training.grokalgo.chapter02;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NaiveSortTest
{
    private final NaiveSort sort = new NaiveSort();

    @Test
    void shouldResultInEmptyArrayWhenNoItems()
    {

        assertThat(sort.sort(new int[0])).isEmpty();
    }

    @Test
    void shouldReturnTheOnlyElement()
    {

        assertThat(this.sort.sort(new int[]{3})).isEqualTo(new int[]{3});
    }

    @Test
    void shouldHandleAlreadySortedInput()
    {
        assertThat(this.sort.sort(new int[]{-1, 2, 3})).isEqualTo(new int[]{-1, 2, 3});
    }

    @Test
    void shouldPrioritizeLowerValues()
    {
        assertThat(this.sort.sort(new int[]{2, 1})).isEqualTo(new int[]{1, 2});
    }

    @Test
    void shouldKeepTheSameValueTogether()
    {
        assertThat(this.sort.sort(new int[]{5, 5, 3, 5, 3})).isEqualTo(new int[]{3, 3, 5, 5, 5});
    }

    @Test
    void shouldNotAllowSentinelValueUntilTested()
    {
        assertThatThrownBy(() -> sort.sort(new int[]{Integer.MAX_VALUE})).isInstanceOf(IllegalArgumentException.class);
    }
}
