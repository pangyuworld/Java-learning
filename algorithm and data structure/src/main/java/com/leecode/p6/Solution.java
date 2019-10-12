package com.leecode.p6;

import org.junit.jupiter.api.Test;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Solution
 * @Package com.leecode.p6
 * @description:
 * @date 2019/10/11 17:09
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 N 字形排列。
 */
public class Solution {
    class Node{
        char val;
        Node down;
        Node rightUp;
        public Node(char x){
            this.val=x;
        }
        public Node setDown(Node node){
            this.down=node;
            return this.down;
        }

        public Node setRightUp(Node rightUp) {
            this.rightUp = rightUp;
            return this.rightUp;
        }
    }
    public String convert(String s, int numRows) {
        char[] chars=s.toCharArray();
        // 新建一个空的头部
        Node node=new Node(' ');
        Node result=node;
        // 标记是否往下进行
        boolean nextDown=true;
        int downCount=1;
        for (int i=0;i<chars.length;i++){
            if (nextDown){
                node=node.setDown(new Node(chars[i]));
                // 计数器+1
                downCount++;
                // 如果计数器超过最大，则置换状态
                if (downCount>numRows){
                    nextDown=!nextDown;
                }
            }else{
                node=node.setRightUp(new Node(chars[i]));
                // 计数器-1
                downCount--;
                if (downCount==2){
                    nextDown=!nextDown;
                }
            }
        }
        return "";
    }

    public String combination(Node node,int numRows){
        String[] strings=new String[numRows];
        int i=0;
        while(node.down!=null||node.rightUp!=null){

        }
        return "";
    }
    @Test
    public void test(){
        convert("LEETCODEISHIRING",4);
    }
}
