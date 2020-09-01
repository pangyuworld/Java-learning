package com.leetcode.p1366;

import java.util.Arrays;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.leetcode.p1366
 * @description:
 * @date 2020/3/4 13:08
 */
class Solution {
    class Rank implements Comparable<Rank> {
        char c;
        int[] rank;
        boolean flag = false;

        public Rank(char c, int n) {
            this.c = c;
            rank = new int[n];
        }


        public void increaseRank(int j) {
            this.flag = true;
            this.rank[j]++;
        }

        @Override
        public int compareTo(Rank o) {
            for (int i = 0; i < this.rank.length; i++) {
                if (this.rank[i] > o.rank[i]) {
                    return 1;
                } else if (this.rank[i] < o.rank[i]) {
                    return -1;
                }
            }
            if (this.c > o.c) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    public String rankTeams(String[] votes) {
        Rank[] ranks = new Rank[26];
        for (int i = 0; i < ranks.length; i++) {
            ranks[i] = new Rank((char) ('A' + i), votes[0].length());
        }
        for (int i = 0; i < votes.length; i++) {
            for (int j = 0; j < votes[0].length(); j++) {
                ranks[votes[i].charAt(j) - 'A'].increaseRank(j);
            }
        }
        Arrays.sort(ranks);
        StringBuffer sb = new StringBuffer();
        for (Rank rank : ranks) {
            if (rank.flag)
                sb.append(rank.c);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().rankTeams(new String[]{"BCA", "CAB", "CBA", "ABC", "ACB", "BAC"}));
    }
}