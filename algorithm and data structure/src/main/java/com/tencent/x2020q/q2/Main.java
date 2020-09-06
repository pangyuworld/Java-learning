package com.tencent.x2020q.q2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int l = sc.nextInt();
            Set<Integer> set = new HashSet<>(l);
            for (int j = 0; j < l; j++) {
                set.add(sc.nextInt());
            }
            for (Integer integer : set) {
                Set<Integer> set1 = map.get(integer);
                if (set1 == null || set1.isEmpty()) {
                    map.put(integer, set);
                    continue;
                }
                set1.addAll(set);
                map.put(integer, set1);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> result = new HashSet<>();
        queue.addAll(map.get(0));
        while (!queue.isEmpty()){
            Integer i = queue.poll();
            Set<Integer> set = map.get(i);
            for (Integer j : set) {
                if (!result.contains(j)){
                    queue.add(j);
                    result.add(j);
                }
            }
        }
        System.out.println(result.size());
    }
}