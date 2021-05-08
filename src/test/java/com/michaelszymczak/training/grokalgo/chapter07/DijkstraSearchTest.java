package com.michaelszymczak.training.grokalgo.chapter07;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DijkstraSearchTest
{
    private final DijkstraSearch search = new DijkstraSearch();

    @Test
    void shouldNotFindAnyPathInEmptyGraph()
    {
        assertThat(search.shortestPath(
                new int[][]{

                },
                1, 2
        )).isEqualTo(new int[0]);
    }

    @Test
    void shouldFindTheOnlyNode()
    {
        assertThat(search.shortestPath(
                new int[][]{
                        new int[]{0}
                },
                0, 0
        )).isEqualTo(new int[]{0});
    }
}