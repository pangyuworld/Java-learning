package com.pang.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pang
 * @version V1.0
 * @ClassName: University
 * @Package com.pang.composite
 * @description:
 * @date 2019/10/11 10:37
 */
public class University extends Organization {
    List<Organization> organizations = new ArrayList<Organization>();

    public University(String name) {
        super(name);
    }

    @Override
    public void print() {
        System.out.println("--------" + getName() + "---------");
        for (Organization organization : organizations) {
            organization.print();
        }
    }

    @Override
    public void add(Organization organization) {
        organizations.add(organization);
    }

    @Override
    public void remove(Organization organization) {
        organizations.remove(organization);
    }
}
