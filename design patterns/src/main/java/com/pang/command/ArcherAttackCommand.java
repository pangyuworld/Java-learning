package com.pang.command;

/**
 * @author pang
 * @version V1.0
 * @ClassName: ArcherAttackCommand
 * @Package com.pang.command
 * @description:
 * @date 2019/10/15 12:14
 */
public class ArcherAttackCommand implements Command {
    private Archer archer;

    public ArcherAttackCommand(Archer archer) {
        this.archer=archer;
    }

    @Override
    public void execute() {
        System.out.println("下令让弓箭手攻击敌军");
        archer.attack();
    }
}
