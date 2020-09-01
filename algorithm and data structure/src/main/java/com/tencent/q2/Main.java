package com.tencent.q2;

import java.util.*;


public class Main {
    static Scanner sc = new Scanner(System.in);
    static List<Point> pointList = new LinkedList<>();

    public static void main(String[] args) {
        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {
            double r = Double.MAX_VALUE;
            int n = sc.nextInt();
            for (int j = 0; j < n; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                pointList.add(new Point(x, y));
            }
            for (int j = 0; j < n; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                Point p = new Point(x, y);
                for (Point point : pointList) {
                    r = Math.min(p.listen(point), r);
                }
            }
            System.out.printf("%.3f\n", r);
        }
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public double listen(Point p) {
            return Math.sqrt(Math.pow((p.x - x), 2) + Math.pow((p.y - y), 2));
        }
    }
}