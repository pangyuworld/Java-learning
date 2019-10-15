package com.pang.command;

/**
 * @author pang
 * @version V1.0
 * @ClassName: ArcherGoAheadCommand
 * @Package com.pang.command
 * @description: 弓箭手前进命令
 * @date 2019/10/15 12:10
 */
public class ArcherGoAheadCommand implements Command {
    Archer archer;

    public ArcherGoAheadCommand(Archer archer) {
        this.archer = archer;
    }

    @Override
    public void execute() {
        System.out.println("下令让弓箭手前进");
        archer.goAhead();
    }

}
