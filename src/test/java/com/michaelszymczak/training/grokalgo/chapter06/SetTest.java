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
    void shouldRemoveElementRegardlessHowManyTimesAdded()
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
    void shouldKeepBothOldAndNewElementsWhenBucketResized()
    {
        Set set = new Set(1, 1);
        set.add(1);
        assertThat(set.contains(1)).isTrue();

        set.add(2);

        assertThat(set.contains(1)).isTrue();
        assertThat(set.contains(2)).isTrue();
    }

    @Test
    void shouldNotContainAnyOtherValuesApartFromExplicitlyInCaseOfResize()
    {
        Set set = new Set(1, 1);
        set.add(1);
        set.add(2);

        range(-100, 1).forEach(value -> assertThat(set.contains(value)).isFalse());
        range(3, 100).forEach(value -> assertThat(set.contains(value)).isFalse());
    }

    @Test
    void shouldNotContainRemovedElementsAfterResize()
    {
        Set set = new Set(2, 4);
        range(-100, 100).forEach(set::add);
        range(-100, 100).forEach(value -> assertThat(set.contains(value)).isTrue());

        range(-100, 100).filter(value -> value % 3 == 0).forEach(set::remove);

        range(-100, 100).filter(value -> value % 3 != 0).forEach(value -> assertThat(set.contains(value)).isTrue());
        range(-100, 100).filter(value -> value % 3 == 0).forEach(value -> assertThat(set.contains(value)).isFalse());
    }

}
