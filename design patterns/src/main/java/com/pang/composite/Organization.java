package com.pang.composite;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Organization
 * @Package com.pang.composite
 * @description:
 * @date 2019/10/11 10:33
 */
public abstract class Organization {
    private String name;

    /**
     * 添加组织成员，如果要进行操作必须进行重写
     *
     * @param organization
     * @return void
     * @author pang
     * @date 2019/10/11
     */
    public void add(Organization organization) {
        throw new UnsupportedOperationException();
    }

    /**
     * 删除组织成员，如果要进行操作必须进行重写
     *
     * @param organization
     * @return void
     * @author pang
     * @date 2019/10/11
     */
    public void remove(Organization organization) {
        throw new UnsupportedOperationException();
    }

    /**
     * 输出信息
     *
     * @author pang
     * @date 2019/10/11
     */
    public abstract void print();

    public Organization(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Organization setName(String name) {
        this.name = name;
        return this;
    }
}
