package com.pang.prototype.exercise;

import java.io.*;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Citation
 * @Package com.pang.prototype.exercise
 * @description: 奖状类
 * @date 2019/10/7 12:10
 */
public class Citation implements Cloneable, Serializable {
    /**
     * 获奖人
     */
    private String winner;
    /**
     * 获奖等级
     */
    private String rank;

    public Citation(String winner, String rank) {
        this.winner = winner;
        this.rank = rank;
    }

    @Override
    protected Object clone(){
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        Object clone = null;
        try{
            bos=new ByteArrayOutputStream();
            oos=new ObjectOutputStream(bos);
            oos.writeObject(this);
            
            bis=new ByteArrayInputStream(bos.toByteArray());
            ois=new ObjectInputStream(bis);
            clone= ois.read();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bos.close();
                oos.close();
                bis.close();
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return clone;
    }

    public String getWinner() {
        return winner;
    }

    public Citation setWinner(String winner) {
        this.winner = winner;
        return this;
    }

    public String getRank() {
        return rank;
    }

    public Citation setRank(String rank) {
        this.rank = rank;
        return this;
    }
}
