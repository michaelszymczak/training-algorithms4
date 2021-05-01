package com.michaelszymczak.training.grokalgo.chapter06;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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

    private static class Set
    {

        private boolean empty = true;
        private int element;

        public boolean contains(final int element)
        {
            return !empty && this.element == element;
        }

        public void add(final int element)
        {
            empty = false;
            this.element = element;
        }

        public void remove(final int element)
        {
            empty = true;
        }
    }
}
