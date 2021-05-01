package com.michaelszymczak.training.grokalgo.chapter06;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


import static java.util.stream.IntStream.range;

public class SetResizeTest
{
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
        set.add(1).add(2);

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
