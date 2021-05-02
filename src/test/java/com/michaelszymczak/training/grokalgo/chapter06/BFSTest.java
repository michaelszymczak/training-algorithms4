package com.michaelszymczak.training.grokalgo.chapter06;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BFSTest
{
    @Test
    void shouldShowEmptyPathWhenEmptyGraph()
    {
        assertThat(new BFS().pathExists(new int[][]{

        }, 0, 0)).isEqualTo(false);
    }

    @Test
    void shouldFindTheSingleNode()
    {
        assertThat(new BFS().pathExists(new int[][]{
                new int[]{}
        }, 0, 0)).isEqualTo(true);
    }

    @Test
    void shouldNotFindAnyPathIfTheSingleNodeDoesNotMatchTheSoughtOne()
    {
        assertThat(new BFS().pathExists(new int[][]{
                new int[]{}
        }, 1, 2)).isEqualTo(false);
    }

    @Test
    void shouldNotFindAnyPathIfTwoNodesNotConnected()
    {
        assertThat(new BFS().pathExists(new int[][]{
                new int[]{},
                new int[]{}
        }, 0, 1)).isEqualTo(false);

        assertThat(new BFS().pathExists(new int[][]{
                new int[]{},
                new int[]{}
        }, 1, 0)).isEqualTo(false);

        assertThat(new BFS().pathExists(new int[][]{
                new int[]{1},
                new int[]{}
        }, 1, 0)).isEqualTo(false);
    }

    @Test
    void shouldFindDirectPathAsTheOnlyEdge()
    {
        assertThat(new BFS().pathExists(new int[][]{
                new int[]{1},
                new int[]{}
        }, 0, 1)).isEqualTo(true);

        assertThat(new BFS().pathExists(new int[][]{
                new int[]{2},
                new int[]{},
                new int[]{}
        }, 0, 2)).isEqualTo(true);

        assertThat(new BFS().pathExists(new int[][]{
                new int[]{},
                new int[]{0},
                new int[]{}
        }, 1, 0)).isEqualTo(true);
    }

    @Test
    void shouldFindDirectPath()
    {
        assertThat(new BFS().pathExists(new int[][]{
                new int[]{1, 2},
                new int[]{},
                new int[]{}
        }, 0, 2)).isEqualTo(true);
    }

    @Test
    void shouldFindPathRequiringTwoHops()
    {
        assertThat(new BFS().pathExists(new int[][]{
                new int[]{1},
                new int[]{2},
                new int[]{}
        }, 0, 2)).isEqualTo(true);

        assertThat(new BFS().pathExists(new int[][]{
                new int[]{3},
                new int[]{0,2},
                new int[]{0,4,3},
                new int[]{},
                new int[]{}
        }, 1, 4)).isEqualTo(true);
    }
}
