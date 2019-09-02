package com.pang.tree;

/**
 * @author pang
 * @version V1.0
 * @ClassName: BaseTree
 * @Package com.pang.tree
 * @description: 二叉查找树？？？？，这是最简单的树的构建和基本操作
 * @date 2019/9/2 8:23
 */
public class BaseTree {
    /**
     * 两个常量，分别表示向左右子节点添加数据
     */
    public static final boolean LEFT = true;
    public static final boolean RIGHT = false;
    /**
     * 树当前的大小
     */
    private int treeSize;
    /**
     * 树的最大父节点
     */
    private Node topFather;
    /**
     * 用于临时存储的节点
     */
    private Node node;
    /**
     * 用于临时存储左右
     */
    private boolean isLeft;

    /**
     * 添加节点
     *
     * @param data 要添加节点的数据
     * @return void
     * @author pang
     * @date 2019/9/2
     */
    public BaseTree add(int data) {
        // 如果是第一次创建节点，则一定为最大父节点
        if (topFather == null) {
            topFather = new Node().setData(data);
            node = topFather;
            return this;
        }
        // 查找目标节点
        node = findNode(node, data);
        // 添加节点
        new Node(node, this.isLeft, data);
        // 初始化临时节点
        node = this.topFather;
        // 返回其本身，链式添加
        return this;
    }

    /**
     * 查找目标节点
     *
     * @param base
     * @param data
     * @return com.pang.tree.BaseTree.Node
     * @author pang
     * @date 2019/9/2
     */
    private Node findNode(Node base, int data) {
        if (data < base.getData()) {
            // 如果数据比节点小，则查询左节点
            if (base.getLeft() == null) {
                // 如果左节点没数据，则返回该节点就好
                this.isLeft = true;
                return base;
            }
            // 如果左节点有数据，则继续查
            return findNode(base.getLeft(), data);
        } else if (data > base.getData()) {
            // 如果数据比节点大，则查询右节点
            if (base.getRight() == null) {
                // 如果右节点没数据，则返回该节点就好
                this.isLeft = false;
                return base;
            }
            // 如果右节点有数据，则继续查
            return findNode(base.getRight(), data);
        } else {
            // 如果两个节点相等，则返回本身，这是为了查找用,
            return base;
        }
    }

    /**
     * 查找二叉树中的某个值
     *
     * @param data
     * @return int
     * @author pang
     * @date 2019/9/2
     */
    public int find(int data) {
        if (topFather == null) {
            throw new NullPointerException("树为空");
        }
        // 同样是递归查找节点，但是这回只能右节点等于数据才为真
        node = findNode(node, data);
        if (data == node.getData()) {
            // 如果找到了
            return data;
        } else {
            // 没找到
            throw new NullPointerException("没有找到该节点");
        }
    }

    /**
     * 先序遍历
     *
     * @param base 父节点
     * @author pang
     * @date 2019/9/2
     */
    public void preOrderTraveral(Node base) {
        if (base == null) {
            return;
        }
        System.out.print(base.getData() + " ");
        preOrderTraveral(base.getLeft());
        preOrderTraveral(base.getRight());
    }

    /**
     * 中序遍历
     *
     * @param base 父节点
     * @author pang
     * @date 2019/9/2
     */
    public void inOrderTraveral(Node base) {
        if (base == null) {
            return;
        }
        inOrderTraveral(base.getLeft());
        System.out.print(base.getData() + " ");
        inOrderTraveral(base.getRight());
    }

    /**
     * 后续遍历
     *
     * @param base 父节点
     * @author pang
     * @date 2019/9/2
     */
    public void postOrderTraveral(Node base) {
        if (base == null) {
            return;
        }
        postOrderTraveral(base.getLeft());
        postOrderTraveral(base.getRight());
        System.out.print(base.getData() + " ");
    }


    /**
     * 使用内部类构建节点
     */
    class Node {
        /**
         * 节点数据
         */
        private int data;
        /**
         * 左子节点
         */
        private Node left;
        /**
         * 右子节点
         */
        private Node right;

        /**
         * 无参构造，创建第一个节点的时候用
         *
         * @param
         * @return
         * @author pang
         * @date 2019/9/2
         */
        public Node() {
            left = null;
            right = null;
        }

        /**
         * 以父节点创建子节点
         *
         * @param father
         * @return
         * @author pang
         * @date 2019/9/2
         */
        public Node(Node father, boolean isLeft, int data) {
            this();
            this.data = data;
            if (isLeft) {
                father.setLeft(this);
            } else {
                father.setRight(this);
            }
        }

        public int getData() {
            return data;
        }

        public Node setData(int data) {
            this.data = data;
            return this;
        }

        public Node getLeft() {
            return left;
        }

        public Node setLeft(Node left) {
            this.left = left;
            return this;
        }

        public Node getRight() {
            return right;
        }

        public Node setRight(Node right) {
            this.right = right;
            return this;
        }
    }

    public int getTreeSize() {
        return treeSize;
    }

    public BaseTree setTreeSize(int treeSize) {
        this.treeSize = treeSize;
        return this;
    }

    public Node getTopFather() {
        return topFather;
    }

    public BaseTree setTopFather(Node topFather) {
        this.topFather = topFather;
        return this;
    }

    public static void main(String... args) {
        BaseTree tree = new BaseTree();
        tree.add(6).add(3).add(4).add(2).add(1).add(8).add(7).add(9);
        // System.out.println(tree.find(6));
        System.out.println("先序遍历");
        tree.preOrderTraveral(tree.getTopFather());
        System.out.println("\n中序遍历");
        tree.inOrderTraveral(tree.getTopFather());
        System.out.println("\n后序遍历");
        tree.postOrderTraveral(tree.getTopFather());
    }
}
