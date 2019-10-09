package com.pang.prototype.tutorial;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Shape
 * @Package com.pang.prototype
 * @description:
 * @date 2019/10/7 11:45
 */
public abstract class Shape implements Cloneable {
    private String id;
    protected String type;

    abstract void deaw();

    public String getId() {
        return id;
    }

    public Shape setId(String id) {
        this.id = id;
        return this;
    }

    public Shape setType(String type) {
        this.type = type;
        return this;
    }

    public String getType() {
        return type;
    }

    @Override
    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
