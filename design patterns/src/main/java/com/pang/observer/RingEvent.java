package com.pang.observer;

import java.util.LinkedList;

/**
 * @author pang
 * @version V1.0
 * @ClassName: RingEvent
 * @Package com.pang.observer
 * @description:
 * @date 2019/10/17 15:36
 */
public class RingEvent {
    private java.util.List<SchoolPerson> schoolPersonList;

    public RingEvent() {
        schoolPersonList = new LinkedList<>();
    }

    /**
     * 添加观察者
     *
     * @param person
     * @return void
     * @author pang
     * @date 2019/10/17
     */
    public void addObserver(SchoolPerson person) {
        schoolPersonList.add(person);
    }

    /**
     * 删除观察者
     *
     * @param person
     * @return void
     * @author pang
     * @date 2019/10/17
     */
    public void deleteObserver(SchoolPerson person) {
        schoolPersonList.remove(person);
    }
    /**
     * 下课铃响
     *
     * @param
     * @return void
     * @author pang
     * @date 2019/10/17
     */
    public void ringAfterClass() {
        System.out.println("下课铃响了");
        for (SchoolPerson s : schoolPersonList) {
            s.getOutOfClass();
        }
    }

    /**
     * 上课铃响
     *
     * @param
     * @return void
     * @author pang
     * @date 2019/10/17
     */
    public void ringBeforeClass() {
        System.out.println("上课铃响了");
        for (SchoolPerson s : schoolPersonList) {
            s.takeClass();
        }
    }
}
