package com.michaelszymczak.training.grokalgo.chapter07;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


import static com.michaelszymczak.training.grokalgo.chapter06.Path.NO_PATH;
import static com.michaelszymczak.training.grokalgo.chapter07.DijkstraSearch.NO_EDGE;
import static com.michaelszymczak.training.grokalgo.chapter07.GraphRepresentations.m;
import static com.michaelszymczak.training.grokalgo.chapter07.GraphRepresentations.p;

class DijkstraSearchTest
{
    private final DijkstraSearch search = new DijkstraSearch();

    @Test
    void shouldNotFindAnyPathInEmptyGraph()
    {
        assertThat(search.shortestPath(m(""), 1, 2)).isEqualTo(NO_PATH);
    }

    @Test
    void shouldFindTheOnlyNode()
    {
        assertThat(search.shortestPath(m(
                " _" +
                "|4"
        ), 0, 0)).isEqualTo(p("0"));

        assertThat(search.shortestPath(m(
                " __" +
                "|4." +
                "|.."
        ), 0, 0)).isEqualTo(p("0"));

        assertThat(search.shortestPath(m(
                " __" +
                "|.." +
                "|.."
        ), 0, 0)).isEqualTo(p("0"));

        assertThat(search.shortestPath(m(
                " _" +
                "|."
        ), 0, 0)).isEqualTo(p("0"));

        assertThat(search.shortestPath(m(
                " _" +
                "|4"
        ), 0, 0)).isEqualTo(p("0"));
    }

    @Test
    void shouldNotFindAnyPathWhenNoEdgesPresent()
    {
        assertThat(search.shortestPath(m(
                " __" +
                "|.." +
                "|.."
        ), 0, 1)).isEqualTo(NO_PATH);
    }

    @Test
    void shouldNotFindAnyPathIfNodeDoesNotExist()
    {
        assertThat(search.shortestPath(m(
                " _" +
                "|."
        ), 0, 1)).isEqualTo(NO_PATH);

        assertThat(search.shortestPath(m(
                " _" +
                "|."
        ), 1, 0)).isEqualTo(NO_PATH);

        assertThat(search.shortestPath(m(
                " _" +
                "|."
        ), 1, 1)).isEqualTo(NO_PATH);

        assertThat(search.shortestPath(m(
                " _" +
                "|."
        ), 1, 2)).isEqualTo(NO_PATH);
    }

    @Test
    void shouldFindSimplePathBetweenNodes()
    {
        assertThat(search.shortestPath(m(
                " __" +
                "|.4" +
                "|.."
        ), 0, 1)).isEqualTo(p("0,1"));

        assertThat(search.shortestPath(m(
                " ____" +
                "|...." +
                "|4..4" +
                "|...." +
                "|...."
        ), 1, 3)).isEqualTo(p("1,3"));

        assertThat(search.shortestPath(m(
                " __" +
                "|.." +
                "|4."
        ), 1, 0)).isEqualTo(p("1,0"));
    }

    @Test
    void shouldFindAPathWithOneHop()
    {
        assertThat(search.shortestPath(m(
                " ____" +
                "|.4.." +
                "|..4." +
                "|...." +
                "|...."
        ), 0, 2)).isEqualTo(p("0,1,2"));
    }

    @Test
    void shouldFindPathWithOneHopGoingBackward()
    {
        assertThat(search.shortestPath(m(
                " ____" +
                "|..4." +
                "|...." +
                "|.4.." +
                "|...."
        ), 0, 1)).isEqualTo(p("0,2,1"));

        assertThat(search.shortestPath(m(
                " ____" +
                "|...." +
                "|..4." +
                "|4..." +
                "|...."
        ), 1, 0)).isEqualTo(p("1,2,0"));
    }

    @Test
    void shouldRejectInvalidGraph()
    {
        assertThatThrownBy(() -> search.shortestPath(
                new int[][]{
                        new int[]{NO_EDGE, NO_EDGE, NO_EDGE, NO_EDGE},
                        new int[]{4, NO_EDGE, NO_EDGE, 4}
                },
                2, 1
        )).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> search.shortestPath(
                new int[][]{
                        new int[]{NO_EDGE, NO_EDGE, NO_EDGE, NO_EDGE},
                        new int[]{4, NO_EDGE, NO_EDGE, 4}
                },
                0, 0
        )).isInstanceOf(IllegalArgumentException.class);
    }
}