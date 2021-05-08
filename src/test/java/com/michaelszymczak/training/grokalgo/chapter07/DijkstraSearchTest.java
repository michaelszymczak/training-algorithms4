package com.michaelszymczak.training.grokalgo.chapter07;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


import static com.michaelszymczak.training.grokalgo.chapter07.DijkstraSearch.NO_PATH;
import static com.michaelszymczak.training.grokalgo.chapter07.DijkstraSearch.X;

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
        )).isEqualTo(NO_PATH);
    }

    @Test
    void shouldFindTheOnlyNode()
    {
        assertThat(search.shortestPath(
                new int[][]{
                        new int[]{4}
                },
                0, 0
        )).isEqualTo(new int[]{0});

        assertThat(search.shortestPath(
                new int[][]{
                        new int[]{4, X},
                        new int[]{X, X},
                        },
                0, 0
        )).isEqualTo(new int[]{0});

        assertThat(search.shortestPath(
                new int[][]{
                        new int[]{X, X},
                        new int[]{X, X},
                        },
                0, 0
        )).isEqualTo(new int[]{0});

        assertThat(search.shortestPath(
                new int[][]{
                        new int[]{X},
                        },
                0, 0
        )).isEqualTo(new int[]{0});

        assertThat(search.shortestPath(
                new int[][]{
                        new int[]{4},
                        },
                0, 0
        )).isEqualTo(new int[]{0});
    }

    @Test
    void shouldNotFindAnyPathWhenNoEdgesPresent()
    {
        assertThat(search.shortestPath(
                new int[][]{
                        new int[]{X, X},
                        new int[]{X, X},
                        },
                0, 1
        )).isEqualTo(NO_PATH);

        assertThat(search.shortestPath(
                new int[][]{
                        new int[]{X},
                        },
                0, 1
        )).isEqualTo(NO_PATH);
    }

    @Test
    void shouldNotFindAnyPathIfNodeDoesNotExist()
    {
        assertThat(search.shortestPath(
                new int[][]{
                        new int[]{X},
                        },
                0, 1
        )).isEqualTo(NO_PATH);

        assertThat(search.shortestPath(
                new int[][]{
                        new int[]{X},
                        },
                1, 0
        )).isEqualTo(NO_PATH);

        assertThat(search.shortestPath(
                new int[][]{
                        new int[]{X},
                        },
                1, 1
        )).isEqualTo(NO_PATH);

        assertThat(search.shortestPath(
                new int[][]{
                        new int[]{X},
                        },
                1, 2
        )).isEqualTo(NO_PATH);
    }

    @Test
    void shouldFindSimplePathBetweenNodes()
    {
        assertThat(search.shortestPath(
                new int[][]{
                        new int[]{X, 4},
                        new int[]{X, X},
                        },
                0, 1
        )).isEqualTo(new int[]{0, 1});

        assertThat(search.shortestPath(
                new int[][]{
                        new int[]{X, X, X, X},
                        new int[]{4, X, X, 4},
                        new int[]{X, X, X, X},
                        new int[]{X, X, X, X},
                        },
                1, 3
        )).isEqualTo(new int[]{1, 3});
    }

    @Test
    void shouldRejectInvalidGraph()
    {
        assertThatThrownBy(() -> search.shortestPath(
                new int[][]{
                        new int[]{X, X, X, X},
                        new int[]{4, X, X, 4}
                },
                2, 1
        )).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> search.shortestPath(
                new int[][]{
                        new int[]{X, X, X, X},
                        new int[]{4, X, X, 4}
                },
                0, 0
        )).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void shouldFindAPathWithOneHop()
    {
        assertThat(search.shortestPath(
                new int[][]{
                        new int[]{X, 4, X, X},
                        new int[]{X, X, 4, X},
                        new int[]{X, X, X, X},
                        new int[]{X, X, X, X},
                        },
                0, 2
        )).isEqualTo(new int[]{0, 1, 2});
    }
}