package com.pang.prototype.exercise;

import java.io.*;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Certificate
 * @Package com.pang.prototype
 * @description: 奖状类
 * @date 2019/10/7 13:28
 */
public class Certificate implements Cloneable,Serializable{
	private static final long serialVersionUID=1L;
	private Student winner=new Student().setStudentName("张星宇");
	private String rank="一等奖";


	public String getRank() {
		return rank;
	}

	public Certificate setRank(String rank) {
		this.rank = rank;
		return this;
	}

	@Override
	public String toString() {
		return "Certificate{" +
				"winner=" + winner +
				", rank='" + rank + '\'' +
				'}';
	}

	public Student getWinner() {
		return winner;
	}

	public Certificate setWinner(Student winner) {
		this.winner = winner;
		return this;
	}

	@Override
	public Object clone() {
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
			clone= ois.readObject();

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
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
}
