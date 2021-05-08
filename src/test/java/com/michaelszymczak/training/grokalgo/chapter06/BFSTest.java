package com.michaelszymczak.training.grokalgo.chapter06;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BFSTest extends GraphSearchTest
{
    @Override
    protected GraphSearch graphSearch()
    {
        return new BFS();
    }

    @Test
    void shouldFindOnlyPathRequiringTwoHops()
    {
        assertThat(new BFS().shortestPath(new int[][]{
                new int[]{3},
                new int[]{0, 2},
                new int[]{0, 4, 3},
                new int[]{},
                new int[]{}
        }, 1, 4)).isEqualTo(new int[]{1, 2, 4});
    }

    @Test
    void shouldPreferDirectPathOverTwoHops()
    {
        assertThat(new BFS().shortestPath(new int[][]{
                new int[]{3},
                new int[]{0, 2, 4},
                new int[]{0, 4, 3},
                new int[]{},
                new int[]{}
        }, 1, 4)).isEqualTo(new int[]{1, 4});
    }

    @Test
    void shouldFindShortestPath()
    {
        assertThat(new BFS().shortestPath(new int[][]{
                new int[]{6, 2, 1},
                new int[]{0, 3, 4},
                new int[]{0, 6, 5, 3},
                new int[]{5, 4, 1, 2},
                new int[]{1, 3},
                new int[]{6, 3},
                new int[]{0, 2, 5}
        }, 0, 5)).isEqualTo(new int[]{0, 6, 5});

        assertThat(new BFS().shortestPath(new int[][]{
                new int[]{6, 2, 1},
                new int[]{4, 3},
                new int[]{3},
                new int[]{4, 5},
                new int[]{},
                new int[]{6},
                new int[]{2}
        }, 0, 5)).isEqualTo(new int[]{0, 2, 3, 5});
    }
}
