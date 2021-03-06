package com.michaelszymczak.training.grokalgo.chapter07;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


import static com.michaelszymczak.training.grokalgo.chapter07.DijkstraSearch.NO_EDGE;

class GraphRepresentationsTest
{
    @Test
    void shouldGenerateEmptyMatrix()
    {
        assertThat(GraphRepresentations.m("")).isEqualTo(new int[][]{});
    }

    @Test
    void shouldRepresentNoEdgeAsDot()
    {
        assertThat(GraphRepresentations.m("|.")).isEqualTo(new int[][]{
                new int[]{NO_EDGE}
        });
        assertThat(GraphRepresentations.m(
                "|.." +
                "|.."
        )).isEqualTo(new int[][]{
                new int[]{NO_EDGE, NO_EDGE},
                new int[]{NO_EDGE, NO_EDGE}
        });
    }

    @Test
    void shouldParseWeights()
    {
        assertThat(GraphRepresentations.m(
                "|12" +
                "|34"
        )).isEqualTo(new int[][]{
                new int[]{1, 2},
                new int[]{3, 4}
        });
    }

    @Test
    void shouldIgnoreEverythingBeforeFirstPipe()
    {
        assertThat(GraphRepresentations.m(
                " _" +
                "|."
        )).isEqualTo(new int[][]{
                new int[]{NO_EDGE}
        });

        assertThat(GraphRepresentations.m(
                "__" +
                "|."
        )).isEqualTo(new int[][]{
                new int[]{NO_EDGE}
        });

        assertThat(GraphRepresentations.m(
                " 012" +
                "____" +
                "|.." +
                "|.."
        )).isEqualTo(new int[][]{
                new int[]{NO_EDGE, NO_EDGE},
                new int[]{NO_EDGE, NO_EDGE}
        });

        assertThat(GraphRepresentations.m(
                " 012" +
                "____" +
                "|"
        )).isEqualTo(new int[][]{});
    }

    @Test
    void shouldRenderEmptyPath()
    {
        assertThat(GraphRepresentations.p("")).isEqualTo(new int[0]);
        assertThat(GraphRepresentations.p("   ")).isEqualTo(new int[0]);
    }

    @Test
    void shouldRenderPath()
    {
        assertThat(GraphRepresentations.p("1,2,5")).isEqualTo(new int[]{1, 2, 5});
    }
}