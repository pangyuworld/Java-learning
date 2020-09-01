package com.pang.test;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * @author pang
 * @version V1.0
 * @ClassName: MapTest
 * @Package com.pang.test
 * @description:
 * @date 2019/11/28 15:46
 */
public class MapTest {

    @Test
    public void test1() {
        Map<String, Object> map = new HashMap<>();
        map.put("userName", "zz");
        Set<String> keySet = map.keySet();
        keySet.add("password");
        System.out.println(map.size());
        System.out.println(keySet.size());
    }

    @Test
    public void test2() {
        long start = System.currentTimeMillis();
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println((System.currentTimeMillis() - start));
    }

    @Test
    public void test3() {
        Value v1 = new Value(1);
        Value v2 = new Value(1);
        System.out.println(v1==v2);
        Map<Value,Object> map=new HashMap<>();
        map.put(v1,"hello");
        map.put(v2,"world");
        System.out.println(map.get(v1));
    }
}

class Value {
    private int id;

    public Value(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Value value = (Value) o;
        return id == value.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}