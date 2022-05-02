package com.leetcode.p417;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author godspeed.zxy
 * @version : Solution, v0.1 2022-04-27 11:51 上午 godspeed.zxy Exp $
 */
class Solution {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Map<String, PointValue> map = new HashMap<>(heights.length * heights[0].length);
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[i].length; j++) {
                map.put(point(i, j), new PointValue(heights[i][j]));
            }
        }
        // 太平洋
        for (int i = 0; i < heights[0].length; i++) {
            //System.out.println(0 + "," + i);
            liushui(0, i, map, 0, true);
        }
        for (int i = 0; i < heights.length; i++) {
            //System.out.println(i + "," + 0);
            liushui(i, 0, map, 0, true);
        }
        // 大西洋
        for (int i = 0; i < heights[0].length; i++) {
            //System.out.println(i + "," + (heights.length - 1));
            liushui(heights.length - 1, i, map, 0, false);
        }
        for (int i = 0; i < heights.length; i++) {
            //System.out.println(i + "," + (heights[0].length - 1));
            liushui(i, heights[0].length - 1, map, 0, false);
        }
        List<List<Integer>> res = new LinkedList<>();
        map.forEach((k, v) -> {
            if (v.shuangxiang()) {
                String[] split = k.split(",");
                res.add(Arrays.asList(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
            }
        });
        return res;
    }

    private void liushui(int x, int y, Map<String, PointValue> map, int val, boolean flag) {
        PointValue pointValue = map.get(point(x, y));
        if (pointValue == null) {
            return;
        }
        if (flag && pointValue.taipingyang()) {
            return;
        } else if (!flag && pointValue.daxiyang()) {
            return;
        }
        if (flag && pointValue.value >= val) {
            pointValue.setTaipingyang();
        } else if (!flag && pointValue.value >= val) {
            pointValue.setDaxiyang();
        } else {
            return;
        }
        liushui(x - 1, y, map, pointValue.value, flag);
        liushui(x + 1, y, map, pointValue.value, flag);
        liushui(x, y - 1, map, pointValue.value, flag);
        liushui(x, y + 1, map, pointValue.value, flag);
    }

    private static String point(int x, int y) {
        return "" + x + "," + y;
    }

    class PointValue {
        public int value;
        private int liuxiang;

        public PointValue(int value) {
            this.value = value;
        }

        private boolean taipingyang() {
            return (liuxiang & 1) > 0;
        }

        private boolean daxiyang() {
            return (liuxiang & 2) > 0;
        }

        private boolean shuangxiang() {
            return taipingyang() && daxiyang();
        }

        private PointValue setTaipingyang() {
            this.liuxiang = this.liuxiang | 1;
            return this;
        }

        private PointValue setDaxiyang() {
            this.liuxiang = this.liuxiang | 2;
            return this;
        }

        @Override
        public String toString() {
            return "PointValue{" +
                "value=" + value +
                ", liuxiang=" + liuxiang +
                '}';
        }
    }

}
