package com.pang.map;

import com.pang.array.BaseArray;
import com.pang.list.BaseList;


/**
 * @author pang
 * @version V1.0
 * @ClassName: BaseMap
 * @Package com.pang.map
 * @description: 散列表基本操作(增删改查扩容)的实现，参考《漫画算法》p51-p59
 * @date 2019/7/5 12:45
 */
public class BaseMap<V> {
    /**
     * 储存散列表的容器
     */
    private BaseList<Map<V>>[] mapArray;
    /**
     * 散列表大小，默认为8
     */
    private int size;
    /**
     * 计数器，用来计算散列表已存数据
     */
    private int counter;
    /**
     *
     */
    private final float EXPANSION_FACTOR = 0.75f;

    /**
     * 新建一个map对象
     *
     * @author pang
     * @date 2019/7/5
     */
    public BaseMap() {
        this.size = 0x08;
        this.counter = 0;
        this.mapArray = new BaseList[this.size];
    }

    /**
     * 添加新的键值对
     *
     * @param key   键
     * @param value 值
     * @author pang
     * @date 2019/7/5
     */
    public void put(int key, V value) throws Exception {
        // 当散列表超过75%时候，则扩容
        if (this.counter >= this.size * EXPANSION_FACTOR) {
            this.resize();
        }
        // 找到散列表坐标
        int index = key % this.size;
        if (mapArray[index] == null) {
            // 没有发生冲突的时候
            mapArray[index] = new BaseList<>(new Map<>(key, value));
        } else {
            // 发生冲突的时候
            // 键存在的状况，则对键的值进行修改
            for (int i = 0; i < mapArray[index].getSize(); i++) {
                if (key == mapArray[index].get(i).getKey()) {
                    // 修改键对应的值并结束
                    mapArray[index].get(i).setValue(value);
                    return;
                }
            }
            // 在链表后面添加新的键值对
            mapArray[index].insert(new Map<>(key, value), mapArray[index].getSize());
        }
        // 计数器+1
        this.counter++;
    }

    /**
     * 取得键对应的值
     *
     * @param key 键
     * @return V 值
     * @author pang
     * @date 2019/7/5
     */
    public V get(int key) throws Exception {
        // 找到散列表坐标
        int index = key % this.size;
        // 对应坐标链表为null的情况
        if (this.mapArray[index] == null) {
            return null;
        }
        // 链表不为空
        for (int i = 0; i < this.mapArray[index].getSize(); i++) {
            // 找到对应的值
            if (key == mapArray[index].get(i).getKey()) {
                // 修改键对应的值并结束
                return mapArray[index].get(i).getValue();
            }
        }
        // 没有找到对应的值
        return null;
    }

    /**
     * 散列表扩容
     *
     * @author pang
     * @date 2019/7/5
     */
    private void resize() throws Exception {
        // 获得所有键值对
        BaseArray<Map<V>> maps = this.getMaps();
        // 初始化计数器
        this.counter = 0;
        // 散列表大小扩大
        this.size = this.size << 1;
        // 散列表容器重新分配
        this.mapArray = new BaseList[this.size];
        // 逐一赋值，这里似乎有点小递归了
        for (int i = 0; i < maps.getSize(); i++) {
            this.put(maps.get(i).getKey(), maps.get(i).getValue());
        }
    }

    /**
     * 找到散列表中所有的键值对
     *
     * @return com.pang.array.BaseArray<com.pang.map.BaseMap                               <                               V>.Map<V>> 键值对集合
     * @author pang
     * @date 2019/7/5
     */
    private BaseArray<Map<V>> getMaps() throws Exception {
        // 新建散列表数组
        BaseArray<Map<V>> mapBaseArray = new BaseArray<>(this.counter);
        // 遍历
        for (int i = 0; i < this.size; i++) {
            // 如果index对应的链表不存在，则跳过
            if (this.mapArray[i] == null) {
                continue;
            }
            // 遍历链表
            for (int j = 0; j < this.mapArray[i].getSize(); j++) {
                Map<V> map = this.mapArray[i].get(j);
                mapBaseArray.insert(map, mapBaseArray.getSize());
            }
        }
        return mapBaseArray;
    }

    public int getSize() {
        return counter;
    }

    @Override
    public String toString() {
        String str = "";
        BaseArray<Map<V>> maps;
        try {
            maps = this.getMaps();
            for (int i = 0; i < maps.getSize(); i++) {
                str += "[k:" + maps.get(i).getKey() + ",v:" + maps.get(i).getValue() + "]";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "size=" + this.size + " counter=" + this.counter + " data=" + str;
    }

    /**
     * @author pang
     * @version V1.0
     * @ClassName: BaseMap.Map
     * @Package com.pang.map
     * @description: 散列表内部类
     * @date 2019/7/5 12:45
     */
    private class Map<T> {
        /**
         * 键
         */
        private int key;
        /**
         * 值
         */
        private T value;

        public Map(int key, T value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public Map setKey(int key) {
            this.key = key;
            return this;
        }

        public T getValue() {
            return value;
        }

        public Map setValue(T value) {
            this.value = value;
            return this;
        }

        @Override
        public String toString() {
            return "Map{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    public static void main(String... args) throws Exception {
        BaseMap<Integer> map = new BaseMap<>();
        for (int i = 0; i < 50; i++) {
            int key=(int) (Math.random() * 100);
            map.put(key, (int) (Math.random() * 100));
            System.out.println(map);
            System.out.println(map.get(key));
        }
    }
}
