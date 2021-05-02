package com.michaelszymczak.training.grokalgo.chapter06;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BFSTest
{
    @Test
    void shouldShowEmptyPathWhenEmptyGraph()
    {
        assertThat(new BFS().shortestPath(new int[][]{

        }, 0, 0)).isEqualTo(BFS.NO_PATH);
    }

    @Test
    void shouldFindTheSingleNode()
    {
        assertThat(new BFS().shortestPath(new int[][]{
                new int[]{}
        }, 0, 0)).isEqualTo(new int[]{0});
    }

    @Test
    void shouldNotFindAnyPathIfTheSingleNodeDoesNotMatchTheSoughtOne()
    {
        assertThat(new BFS().shortestPath(new int[][]{
                new int[]{}
        }, 1, 2)).isEqualTo(BFS.NO_PATH);
    }

    @Test
    void shouldNotFindAnyPathIfTwoNodesNotConnected()
    {
        assertThat(new BFS().shortestPath(new int[][]{
                new int[]{},
                new int[]{}
        }, 0, 1)).isEqualTo(BFS.NO_PATH);

        assertThat(new BFS().shortestPath(new int[][]{
                new int[]{},
                new int[]{}
        }, 1, 0)).isEqualTo(BFS.NO_PATH);

        assertThat(new BFS().shortestPath(new int[][]{
                new int[]{1},
                new int[]{}
        }, 1, 0)).isEqualTo(BFS.NO_PATH);
    }

    @Test
    void shouldFindDirectPath()
    {
        assertThat(new BFS().shortestPath(new int[][]{
                new int[]{1},
                new int[]{},
                }, 0, 1)).isEqualTo(new int[]{0, 1});

        assertThat(new BFS().shortestPath(new int[][]{
                new int[]{2},
                new int[]{},
                new int[]{},
                }, 0, 2)).isEqualTo(new int[]{0, 2});

        assertThat(new BFS().shortestPath(new int[][]{
                new int[]{},
                new int[]{0},
                new int[]{},
                }, 1, 0)).isEqualTo(new int[]{1, 0});
    }
}
