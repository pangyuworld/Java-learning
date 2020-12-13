package com.leetcode.p94;

import com.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author godspeed.zxy
 * @version $id: Solution.java, v 0.1 2020/9/14 9:18 godspeed.zxy Exp $
 */
public class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        // 具体注释细节看先序遍历即可
        // 根节点不能为空或者栈不为空
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            if (!stack.isEmpty() || root.right != null) {
                // 这里栈为空在获得顶点6的时候就停了
                // 但是如果加上判断右子节点是不是为空又会导致当root为8的时候直接无法运行下面的语句
                root = root.right;
            } else {
                // 所以，在这里加上一个else语句作为结尾的判断就好了啊
                root = root.right;
            }
        }
        return list;
    }
}
