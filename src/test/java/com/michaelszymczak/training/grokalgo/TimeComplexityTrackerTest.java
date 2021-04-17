package com.michaelszymczak.training.grokalgo;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TimeComplexityTrackerTest
{
    @Test
    void shouldDecideIfCanBeLogNWithSomeErrorMargin()
    {
        final TimeComplexityTracker tracker = new TimeComplexityTracker().reset();

        // When
        timesRun(10, tracker::onOperation);

        // Then
        assertThat(tracker.probablyLogN((int)Math.pow(2, 13))).isFalse();
        assertThat(tracker.probablyLogN((int)Math.pow(2, 12))).isTrue();
        assertThat(tracker.probablyLogN((int)Math.pow(2, 10))).isTrue();
        assertThat(tracker.probablyLogN((int)Math.pow(2, 8))).isTrue();
        assertThat(tracker.probablyLogN((int)Math.pow(2, 7))).isFalse();
    }

    @Test
    void shouldDecideIfCanBeLinearWithSomeErrorMargin()
    {
        final TimeComplexityTracker tracker = new TimeComplexityTracker().reset();

        // When
        timesRun(1000, tracker::onOperation);

        // Then
        assertThat(tracker.probablyN(1201)).isFalse();
        assertThat(tracker.probablyN(1200)).isTrue();
        assertThat(tracker.probablyN(1000)).isTrue();
        assertThat(tracker.probablyN(800)).isTrue();
        assertThat(tracker.probablyN(799)).isFalse();
    }

    private void timesRun(final int num, final Runnable r)
    {
        IntStream.range(0, num).forEach(value -> r.run());
    }
}