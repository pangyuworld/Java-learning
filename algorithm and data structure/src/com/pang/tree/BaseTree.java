package com.pang.tree;

import com.pang.queue.BaseQueue;
import com.pang.stack.BaseStack;

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
            this.treeSize++;
            return this;
        }
        // 查找目标节点
        node = findNode(node, data);
        // 添加节点
        new Node(node, this.isLeft, data);
        // 初始化临时节点
        node = this.topFather;
        // 树的节点数量+1
        this.treeSize++;
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
     * 使用栈完成二叉树先序遍历
     *
     * @param base 父节点
     * @author pang
     * @date 2019/9/2
     */
    public void preOrderTraveralByStatic(Node base) {
        // 用自己实现的栈创建一个可以存储节点的栈
        BaseStack<Node> stack = new BaseStack<>(this.treeSize);
        // 如果开始的根节点为空或者栈为空都会使死循环终止
        while (base != null || !stack.isEmpty()) {
            // 下面有个子循环，是向左递归的思路，所以只要有左子节点就不会停
            // 如果因为这个节点等于了左节点且为空，则停止循环，执行循环下面的语句
            while (base != null) {
                // 输出该节点信息
                System.out.print(base.getData() + " ");
                // 将输出过的节点压入栈
                stack.push(base);
                // 这是做递归思路，所以让根节点指向他的左节点，然后再回到循环开始进行判断
                base = base.getLeft();
            }
            // 当然，栈不能为空，如果栈为空就代表递归到了终点了
            if (!stack.isEmpty()) {
                // 既然左节点为空了，那么我们就让他成为右节点吧
                // 注意这里的pop()是从栈中取出且删除栈顶元素
                base = stack.pop().getRight();
            }
        }
    }

    /**
     * 使用栈完成中序遍历
     *
     * @param base 根节点
     * @author pang
     * @date 2019/9/2
     */
    public void inOrderTraveralByStatic(Node base) {
        BaseStack<Node> stack = new BaseStack<>(this.treeSize);
        // 具体注释细节看先序遍历即可
        // 根节点不能为空或者栈不为空
        while (base != null || !stack.isEmpty()) {
            while (base != null) {
                stack.push(base);
                base = base.getLeft();
            }
            base = stack.pop();
            System.out.print(base.getData() + " ");
            if (!stack.isEmpty() || base.getRight() != null) {
                // 这里栈为空在获得顶点6的时候就停了
                // 但是如果加上判断右子节点是不是为空又会导致当base为8的时候直接无法运行下面的语句
                base = base.getRight();
            } else {
                // 所以，在这里加上一个else语句作为结尾的判断就好了啊
                base = base.getRight();
            }
        }
    }

    /**
     * 使用栈实现后续遍历
     *
     * @param base 根节点
     * @author pang
     * @date 2019/9/2
     */
    public void postOrderTraveralByStatic(Node base) {
        BaseStack<Node> stack = new BaseStack<>(this.treeSize);
        // 这里创建一个临时变量是要保存最近一次访问的节点，一般就是某个根节点的右节点
        Node node = null;
        while (base != null || !stack.isEmpty()) {
            // 向左查找到最底一层叶子节点
            if (base != null) {
                stack.push(base);
                base = base.getLeft();
            } else {
                // 当最左侧叶子节点没有子节点以后，就开始考虑它有没有右节点
                // 首先是得到这个左叶子节点
                base = stack.top();
                // 这里进行判断，首先是判断他有没有右子节点，如果有右子节点，那么上一次访问的右子节点是不是它
                if (base.getRight() != null && base.getRight() != node) {
                    // 这里已经证明我们是第一次访问这个右子节点
                    // 所以把这个右子节点压入栈
                    base = base.getRight();
                    stack.push(base);
                    // 然后获得他的左子节点（因为总有一些奇形怪状的树），然后再返回循环继续判断
                    base = base.getLeft();
                } else {
                    // 代码执行到这里是因为这个节点可能没有右子节点或者上次一已经访问过右子节点了
                    // 先把栈顶元素取出来
                    stack.pop();
                    // 输出当前元素
                    System.out.print(base.getData() + " ");
                    // 然后把临时变量保存为刚刚输出的临时变量
                    node = base;
                    // 这里置空是因为如果不置空的话，第一层判断会直接把最左叶子节点压入栈
                    base = null;
                }
            }
        }
    }

    /**
     * 层序遍历
     *
     * @param base 根节点
     * @author pang
     * @date 2019/9/3
     */
    public void sequenceTraversal(Node base) throws Exception {
        // 用自己实现的简单队列来做
        BaseQueue<Node> queue = new BaseQueue<>(this.treeSize);
        // 基础条件还是节点不为空，队列不为空
        while (base != null || !queue.isEmpty()) {
            if (base.getLeft() != null) { 
                // 如果有左子节点，就把左子节点添加到队列中
                queue.add(base.getLeft());
            }
            if (base.getRight() != null) {
                // 如果有右子节点，就把右子节点添加到队列中
                queue.add(base.getRight());
            }
            // 输出节点信息
            System.out.print(base.getData() + " ");
            // 这里有点坑，当时写队列的时候把空队列写成了异常，所以这里是不是需要一个异常处理呢
            // 答案是不用，直接在这里添加一个把base置空就好了
            base = null;
            // 还是这个问题，如果队列为空的时候执行Poll会导致抛出异常
            if (!queue.isEmpty()) {
                base = queue.poll();
            }
        }
    }

    /**
     * 使用内部类构建节点
     */
    private class Node {
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

    public static void main(String... args) throws Exception {
        BaseTree tree = new BaseTree();
        tree.add(6).add(3).add(4).add(2).add(1).add(8).add(7).add(9);
        // tree.add(6).add(3).add(8);
        // System.out.println(tree.find(6));
        System.out.println("先序遍历");
        tree.preOrderTraveral(tree.getTopFather());
        System.out.println("\n先序遍历（栈版本）");
        tree.preOrderTraveralByStatic(tree.getTopFather());
        System.out.println("\n中序遍历");
        tree.inOrderTraveral(tree.getTopFather());
        System.out.println("\n中序遍历（栈版本）");
        tree.inOrderTraveralByStatic(tree.getTopFather());
        System.out.println("\n后序遍历");
        tree.postOrderTraveral(tree.getTopFather());
        System.out.println("\n后序遍历（栈版本）");
        tree.postOrderTraveralByStatic(tree.getTopFather());
        System.out.println("\n层序遍历");
        tree.sequenceTraversal(tree.getTopFather());
    }
}
