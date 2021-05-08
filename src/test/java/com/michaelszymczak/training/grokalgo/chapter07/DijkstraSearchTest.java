package com.michaelszymczak.training.grokalgo.chapter07;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class DijkstraSearchTest
{
    private final DijkstraSearch search = new DijkstraSearch();

    @Test
    void shouldNotFindAnyPathInEmptyGraph()
    {
        Assertions.assertThat(search.shortestPath(
                new int[]{

                },
                1, 2
        )).isEqualTo(new int[0]);
    }
}