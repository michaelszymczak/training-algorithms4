package com.michaelszymczak.training.grokalgo.chapter06;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BFSTest
{
    @Test
    void shouldShowEmptyPathWhenEmptyGraph()
    {
        assertThat(new BFS().shortestPath(new int[0][0], 4)).isEqualTo(new int[0]);
    }

    @Test
    void shouldFindTheSingleNode()
    {
        assertThat(new BFS().shortestPath(new int[][]{
                new int[0]
        }, 0)).isEqualTo(new int[]{0});
    }
}
