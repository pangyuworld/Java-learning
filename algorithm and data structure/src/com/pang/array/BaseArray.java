package com.pang.array;

import java.util.Arrays;

/**
 * @author pang
 * @version V1.0
 * @ClassName: BaseArray
 * @Package com.pang.array
 * @description: 数组基本操作(增删改查)的实现，参考《漫画算法》p21-p32
 * @date 2019/7/4 11:00
 */
public class BaseArray {
    /**
     * 对象内置的数组
     */
    private int[] array;
    /**
     * 数组实际大小
     */
    private int size;

    /**
     * 构造对象
     *
     * @param arraySize 数组容量
     * @author pang
     * @date 2019/7/4
     */
    public BaseArray(int arraySize) {
        this.array = new int[arraySize];
        size = 0;
    }

    /**
     * 数组插入操作
     *
     * @param element 要插入的元素
     * @param index   插入位置
     * @author pang
     * @date 2019/7/4
     */
    public void insert(int element, int index) throws Exception {
        // 处理越界
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("插入元素时，数组越界");
        }
        // 扩容
        if (this.size >= this.array.length) {
            resize();
        }
        if (index == 0) {
            // 头部插入,逆序赋值，一次循环
            for (int i = this.size; i > 0; i--) {
                // 让数组当前下标的元素向后退一格
                this.array[i] = this.array[i - 1];
            }
            // 让头部等于要插入的元素
            this.array[0] = element;
        } else if (index == this.size) {
            // 尾部插入，直接赋值就好
            this.array[this.size] = element;
        } else {
            // 中部插入
            for (int i = this.size; i > index; i--) {
                // 其实和头部插入相似，只不过头部变成了中部
                this.array[i] = this.array[i - 1];
            }
            // 让中部等于要插入的元素
            this.array[index] = element;
        }
        // 数组实际大小+1
        this.size += 1;
    }

    /**
     * 获取数组元素
     *
     * @param index 要获取的元素下标
     * @return int 数组元素
     * @author pang
     * @date 2019/7/4
     */
    public int get(int index) throws Exception {
        // 处理数组越界
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("获取数组元素时，数组越界");
        }
        // 得到数组元素
        return this.array[index];
    }

    /**
     * 修改数组元素大小
     *
     * @param element 目标值
     * @param index   目标数组下标
     * @author pang
     * @date 2019/7/4
     */
    public void update(int element, int index) throws Exception {
        // 处理数组越界
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("获取数组元素时，数组越界");
        }
        // 更新数组元素数据
        this.array[index] = element;
    }

    public void delete(int index) throws Exception {
        // 处理数组越界
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("获取数组元素时，数组越界");
        }
        if (index == this.size) {
            // 尾部删除，最简单,令实际大小-1就好了
            this.size--;
        } else if (index == 0) {
            // 头部删除，将所有的元素向前移动一个单位
            for (int i = 0; i < this.size - 1; i++) {
                this.array[i] = this.array[i + 1];
            }
        } else {
            // 中部删除，类似中部插入
            for (int i = index; i < this.size - 1; i++) {
                this.array[i] = this.array[i + 1];
            }
        }
        // 大小-1
        this.size--;
    }

    /**
     * 数组2倍扩容
     *
     * @author pang
     * @date 2019/7/4
     */
    private void resize() {
        int[] arrayTemp = new int[2 * this.size];
        System.arraycopy(this.array, 0, arrayTemp, 0, this.size);
        this.array = arrayTemp;
    }

    /**
     * 获得对象中的数组
     *
     * @return int[] 对象中的数组
     * @author pang
     * @date 2019/7/4
     */
    public int[] getArray() {
        return array;
    }

    /**
     * 获得数组大小
     *
     * @return int 数组大小
     * @author pang
     * @date 2019/7/4
     */
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "BaseArray{" +
                "array=" + Arrays.toString(array) +
                ", size=" + size +
                ", length=" + this.array.length +
                '}';
    }

    /**
     * TEST
     */
    public static void main(String... args) throws Exception {
        // 新建一个大小为3的对象
        BaseArray baseArray = new BaseArray(3);
        // 顺序插入2个元素，即尾部插入
        baseArray.insert(5, 0);
        baseArray.insert(9, 1);
        // 查看输入结果
        System.out.println("新建的对象：" + baseArray);
        // 头部插入1个元素，即头部插入
        baseArray.insert(99, 0);
        System.out.println("头部插入后：" + baseArray);
        // 中部插入1个元素，即中部插入（同时执行扩容）
        baseArray.insert(55, 1);
        System.out.println("中部插入后：" + baseArray);
        // 读取元素
        for (int i = 0; i < baseArray.getSize(); i++) {
            System.out.println("下标为" + i + "的元素，值为" + baseArray.get(i));
        }
        // 修改元素
        baseArray.update(100, 1);
        System.out.println("修改后的对象：" + baseArray);
        // 删除元素
        baseArray.delete(1);
        System.out.println("删除后的对象：" + baseArray);
    }
}
