package com.michaelszymczak.training.grokalgo.chapter06;


import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


import static java.util.stream.IntStream.range;

public class SetTest
{
    private final Set set = new Set(10, 4);

    @Test
    void shouldNotContainAnyElementsInitially()
    {
        assertThat(new Set().contains(4)).isFalse();
    }

    @Test
    void shouldContainAddedElement()
    {
        set.add(4);

        assertThat(set.contains(4)).isTrue();
    }

    @Test
    void shouldNotContainRemovedElement()
    {
        set.add(4).remove(4);

        assertThat(set.contains(4)).isFalse();
    }

    @Test
    void shouldNotContainElementNotAdded()
    {
        set.add(5);

        assertThat(set.contains(4)).isFalse();
    }

    @Test
    void shouldContainBothAddedElements()
    {
        set.add(1).add(2);

        assertThat(set.contains(1)).isTrue();
        assertThat(set.contains(2)).isTrue();
    }

    @Test
    void shouldRemoveElementRegardlessHowManyTimesAdded()
    {
        set.add(1).add(1).remove(1);

        assertThat(set.contains(1)).isFalse();
    }

    @Test
    void shouldAllowAddingManyElements()
    {
        range(0, 100).forEach(set::add);

        range(0, 100).forEach(value -> assertThat(set.contains(value)).isTrue());
    }

    @Test
    void shouldBeAbleToRemoveAllElements()
    {
        range(0, 100).forEach(set::add);

        range(0, 100).forEach(set::remove);

        range(0, 100).forEach(value -> assertThat(set.contains(value)).isFalse());
    }

    @Test
    void shouldAllowAddingElementsOfAnyValue()
    {
        set.add(0).add(Integer.MAX_VALUE).add(-100).add(100_000).add(Integer.MIN_VALUE);

        assertThat(set.contains(0)).isTrue();
        assertThat(set.contains(Integer.MAX_VALUE)).isTrue();
        assertThat(set.contains(-100)).isTrue();
        assertThat(set.contains(100_000)).isTrue();
        assertThat(set.contains(Integer.MIN_VALUE)).isTrue();
    }

    @Test
    void shouldNotContainAnyValueApartExplicitlyAddedOnes()
    {
        range(-100, 100).forEach(set::add);

        range(-200, -100).forEach(value -> assertThat(set.contains(value)).isFalse());
        range(100, 200).forEach(value -> assertThat(set.contains(value)).isFalse());
        assertThat(set.contains(Integer.MAX_VALUE)).isFalse();
        assertThat(set.contains(100_000)).isFalse();
        assertThat(set.contains(Integer.MIN_VALUE)).isFalse();
    }

    @Test
    void shouldHandleAddingAndRemovingElement()
    {
        IntStream.range(0, 100).forEach(
                value ->
                {
                    assertThat(set.contains(value)).isFalse();
                    set.add(value);
                    assertThat(set.contains(value)).isTrue();
                    set.add(value);
                    assertThat(set.contains(value)).isTrue();
                    set.remove(value);
                    assertThat(set.contains(value)).isFalse();
                    set.remove(value);
                    assertThat(set.contains(value)).isFalse();
                });
    }
}
