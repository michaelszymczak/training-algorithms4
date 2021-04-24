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
        timesRun(20, tracker::onOperation);

        // Then
        assertThat(tracker.probablyLogN((long)Math.pow(2, 35))).isFalse();
        assertThat(tracker.probablyLogN(2 * (long)Math.pow(2, 20))).isTrue();
        assertThat(tracker.probablyLogN((long)Math.pow(2, 20) / 2)).isTrue();
        assertThat(tracker.probablyLogN((long)Math.pow(2, 15))).isTrue();
        assertThat(tracker.probablyLogN((int)Math.pow(2, 7))).isFalse();
    }

    @Test
    void shouldDecideIfCanBeLinearWithSomeErrorMargin()
    {
        final TimeComplexityTracker tracker = new TimeComplexityTracker().reset();

        // When
        timesRun(10000, tracker::onOperation);

        // Then
        assertThat(tracker.probablyN(2000)).isFalse();
        assertThat(tracker.probablyN(5000)).isTrue();
        assertThat(tracker.probablyN(10000)).isTrue();
        assertThat(tracker.probablyN(15000)).isTrue();
        assertThat(tracker.probablyN(20000)).isFalse();
    }

    @Test
    void shouldDecideIfCanBeQuadraticWithSomeErrorMargin()
    {
        final TimeComplexityTracker tracker = new TimeComplexityTracker().reset();

        // When
        timesRun(50 * 50, tracker::onOperation);

        // Then
        assertThat(tracker.probablyN2(30)).isFalse();
        assertThat(tracker.probablyN2(40)).isTrue();
        assertThat(tracker.probablyN2(50)).isTrue();
        assertThat(tracker.probablyN2(60)).isTrue();
        assertThat(tracker.probablyN2(70)).isFalse();
    }

    private void timesRun(final int num, final Runnable r)
    {
        IntStream.range(0, num).forEach(value -> r.run());
    }
}