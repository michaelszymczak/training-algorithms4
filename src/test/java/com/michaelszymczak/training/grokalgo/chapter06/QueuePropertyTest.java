package com.michaelszymczak.training.grokalgo.chapter06;

import com.michaelszymczak.training.grokalgo.Fixtures;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class QueuePropertyTest
{
    @Test
    void shouldAddAsManyElementsAsCapacityAllows()
    {
        Queue queue = new Queue(3);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        assertThat(queue.isFull()).isTrue();

        assertThatThrownBy(() -> queue.push(4));
    }

    @Test
    void shouldRemoveAllAddedElements()
    {
        Queue queue = new Queue(3);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        assertThat(queue.isFull()).isTrue();

        queue.pop();
        queue.pop();
        queue.pop();
        assertThat(queue.isEmpty()).isTrue();

        assertThatThrownBy(queue::pop);
    }

    @Test
    void shouldReturnAllAddedElementsInTheFirstInFirstOutOrder()
    {
        Queue queue = new Queue(50);
        int[] inputs = Fixtures.generate(-100, 100, 50);

        for (final int input : inputs)
        {
            queue.push(input);
        }

        final int[] result = new int[50];
        for (int i = 0; i < result.length; i++)
        {
            result[i] = queue.pop();
        }

        assertThat(result).isEqualTo(inputs);
    }
}
