package com.tencent.x2020q.q3;


import java.util.*;

public class Main {
    /**
     * 0~9 数组下表0-9 a-z 数组下标10-35 A-Z 数组下标36-61
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String str = sc.next();
            Integer rank = map.get(str);
            if (rank == null || rank == 0) {
                map.put(str, 1);
            } else {
                map.put(str, rank + 1);
            }
        }
        List<Word> words = new LinkedList<>();
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            words.add(new Word(stringIntegerEntry.getKey(), stringIntegerEntry.getValue()));
        }
        Collections.sort(words, (o1, o2) -> {
            if (o1.rank < o2.rank) return 1;
            if (o1.rank > o2.rank) return -1;
            return o1.str.compareTo(o2.str);
        });
        for (int i = 0; i < K; i++) {
            Word word = words.get(i);
            System.out.println(word.str + " " + word.rank);
        }
        Collections.sort(words, (o1, o2) -> {
            if (o1.rank > o2.rank) return 1;
            if (o1.rank < o2.rank) return -1;
            return o1.str.compareTo(o2.str);
        });
        for (int i = 0; i < K; i++) {
            Word word = words.get(i);
            System.out.println(word.str + " " + word.rank);
        }
    }

}

class Word {
    String str;
    int rank = 0;

    public Word(String str, int rank) {
        this.str = str;
        this.rank = rank;
    }
}