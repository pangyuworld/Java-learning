package com.leetcode.p841;


import java.util.*;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int N = rooms.size();
        if (N <= 0) {
            return true;
        }
        if (rooms.get(0).isEmpty()) {
            if (N == 1) {
                return true;
            } else {
                return false;
            }
        }
        int[] roomArray = new int[N];
        dfs(rooms,roomArray,0);
        for (int i : roomArray) {
            if (i<=0){
                return false;
            }
        }
        return true;
    }

    private void dfs(List<List<Integer>> rooms, int[] roomArray, int index) {
        if (roomArray[index]>0){
            return;
        }
        roomArray[index]=1;
        List<Integer> list = rooms.get(index);
        for (Integer i : list) {
            dfs(rooms,roomArray,i);
        }
    }


    public static void main(String[] args) {
        List<Integer> a1 = new ArrayList<>(Arrays.asList(1));
        List<Integer> a2 = new ArrayList<>(Arrays.asList(2));
        List<Integer> a3 = new ArrayList<>(Arrays.asList(3));
        List<Integer> a4 = new ArrayList<>(Arrays.asList());
        System.out.println(new Solution().canVisitAllRooms(Arrays.asList(a1, a2, a3,a4)));
    }
}
