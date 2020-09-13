package com.leetcode.p79;


import java.util.*;

public class Solution {
    class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public boolean exist(char[][] board, String word) {
        if (board.length < 1 || board[0].length < 1 || word.isEmpty()) {
            return false;
        }
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == words[0]) {
                    if (words.length <= 1) return true;
                    if (find(board, i, j, words, 0, new HashSet<Point>())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean find(char[][] board, int i, int j, char[] words, int n, Set<Point> indexMap) {
        if (n >= words.length) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        Point p = new Point(i, j);
        if (indexMap.contains(p)) {
            return false;
        }
        if (board[i][j] != words[n]) {
            return false;
        }
        indexMap.add(new Point(i, j));
        n++;
        // 左
        boolean res = find(board, i - 1, j, words, n, indexMap)
                || find(board, i + 1, j, words, n, indexMap)
                || find(board, i, j + 1, words, n, indexMap)
                || find(board, i, j - 1, words, n, indexMap);
        indexMap.remove(p);
        return res;
    }

    public static void main(String[] args) {
        // char[][] board = new char[][]{
        //         new char[]{'A', 'B', 'C', 'E'},
        //         new char[]{'S', 'F', 'C', 'S'},
        //         new char[]{'A', 'D', 'E', 'E'}
        // };
        char[][] board = new char[][]{
                new char[]{'A', 'B', 'C', 'E'},
                new char[]{'S', 'F', 'E', 'S'},
                new char[]{'A', 'D', 'E', 'E'}
        };
        System.out.println(new Solution().exist(board, "ABCESEEEFS"));

        // System.out.println(new Solution().exist(new char[][]{new char[]{'a','a'}}, "aa"));
    }
}
