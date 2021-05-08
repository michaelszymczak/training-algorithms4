package com.michaelszymczak.training.grokalgo.chapter07;

import java.util.Arrays;


import static com.michaelszymczak.training.grokalgo.chapter07.DijkstraSearch.X;

public class GraphRepresentations
{
    /**
     * Adjacency matrix
     */
    public static int[][] m(final String representation)
    {
        int firstRelevantIndex = representation.indexOf('|');
        if (firstRelevantIndex == -1 || firstRelevantIndex == representation.length() - 1)
        {
            return new int[0][0];
        }
        String repr = representation.substring(firstRelevantIndex + 1);
        String[] rows = repr.split("\\|");
        int[][] result = new int[rows.length][rows.length];
        for (int row = 0; row < rows.length; row++)
        {
            if (rows[row].length() != rows.length)
            {
                throw new IllegalArgumentException("Must be a square");
            }
            for (int col = 0; col < rows[row].length(); col++)
            {
                String ch = String.valueOf(rows[row].charAt(col));
                result[row][col] = ".".equals(ch) ? X : Integer.parseInt(ch);
            }
        }
        return result;
    }

    /**
     * Path
     */
    public static int[] p(final String representation)
    {
        if (representation.trim().isEmpty())
        {
            return new int[0];
        }
        return Arrays.stream(representation.split(",")).mapToInt(node -> Integer.parseInt(node.trim())).toArray();
    }
}
