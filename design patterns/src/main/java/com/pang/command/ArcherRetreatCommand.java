package com.pang.command;

/**
 * @author pang
 * @version V1.0
 * @ClassName: ArcherRetreatCommand
 * @Package com.pang.command
 * @description:
 * @date 2019/10/15 12:15
 */
public class ArcherRetreatCommand implements Command {
    private Archer archer;

    public ArcherRetreatCommand(Archer archer) {
        this.archer=archer;
    }

    @Override
    public void execute() {
        System.out.println("下令让弓箭手撤回");
        archer.retreat();
    }
}
