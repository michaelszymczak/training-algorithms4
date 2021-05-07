package com.michaelszymczak.training.grokalgo.chapter06;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


import static java.util.stream.IntStream.range;

public abstract class GraphSearchTest
{
    protected abstract GraphSearch graphSearch();

    @Test
    void shouldNotFindAnyPathInEmptyGraph()
    {
        assertThat(graphSearch().pathExists(new int[][]{

        }, 0, 0)).isEqualTo(false);
    }

    @Test
    void shouldNotFindAnyPathWhenNodesNotInGraph()
    {
        assertThat(graphSearch().pathExists(new int[][]{
                new int[]{0}
        }, 0, 1)).isEqualTo(false);

        assertThat(graphSearch().pathExists(new int[][]{
                new int[]{0}
        }, 1, 0)).isEqualTo(false);
    }

    @Test
    void shouldFindTheSingleNode()
    {
        assertThat(graphSearch().pathExists(new int[][]{
                new int[]{}
        }, 0, 0)).isEqualTo(true);
    }

    @Test
    void shouldNotFindAnyPathIfTheSingleNodeDoesNotMatchTheSoughtOne()
    {
        assertThat(graphSearch().pathExists(new int[][]{
                new int[]{}
        }, 1, 2)).isEqualTo(false);
    }

    @Test
    void shouldNotFindAnyPathIfTwoNodesNotConnected()
    {
        assertThat(graphSearch().pathExists(new int[][]{
                new int[]{},
                new int[]{}
        }, 0, 1)).isEqualTo(false);

        assertThat(graphSearch().pathExists(new int[][]{
                new int[]{},
                new int[]{}
        }, 1, 0)).isEqualTo(false);

        assertThat(graphSearch().pathExists(new int[][]{
                new int[]{1},
                new int[]{}
        }, 1, 0)).isEqualTo(false);
    }

    @Test
    void shouldFindDirectPathAsTheOnlyEdge()
    {
        assertThat(graphSearch().pathExists(new int[][]{
                new int[]{1},
                new int[]{}
        }, 0, 1)).isEqualTo(true);

        assertThat(graphSearch().pathExists(new int[][]{
                new int[]{2},
                new int[]{},
                new int[]{}
        }, 0, 2)).isEqualTo(true);

        assertThat(graphSearch().pathExists(new int[][]{
                new int[]{},
                new int[]{0},
                new int[]{}
        }, 1, 0)).isEqualTo(true);
    }

    @Test
    void shouldFindDirectPath()
    {
        assertThat(graphSearch().pathExists(new int[][]{
                new int[]{1, 2},
                new int[]{},
                new int[]{}
        }, 0, 2)).isEqualTo(true);
    }

    @Test
    void shouldFindPathRequiringTwoHops()
    {
        assertThat(graphSearch().pathExists(new int[][]{
                new int[]{1},
                new int[]{2},
                new int[]{}
        }, 0, 2)).isEqualTo(true);

        assertThat(graphSearch().pathExists(new int[][]{
                new int[]{3},
                new int[]{0, 2},
                new int[]{0, 4, 3},
                new int[]{},
                new int[]{}
        }, 1, 4)).isEqualTo(true);
    }

    @Test
    void shouldNotBeDistractedByCycles()
    {
        assertThat(graphSearch().pathExists(new int[][]{
                new int[]{1},
                new int[]{0},
                new int[]{}
        }, 0, 2)).isEqualTo(false);

        assertThat(graphSearch().pathExists(new int[][]{
                new int[]{1},
                new int[]{0, 2},
                new int[]{}
        }, 0, 2)).isEqualTo(true);
    }

    @Test
    void shouldHandleLargerGraph()
    {
        final int[][] largeGraph = new int[100][100];
        range(0, 100).forEach(i -> largeGraph[i] = range(0, 100).toArray());
        assertThat(graphSearch().pathExists(largeGraph, 71, 19)).isEqualTo(true);
    }
}
