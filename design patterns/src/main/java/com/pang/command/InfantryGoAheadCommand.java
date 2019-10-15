package com.pang.command;

/**
 * @author pang
 * @version V1.0
 * @ClassName: InfantryGoAheadCommand
 * @Package com.pang.command
 * @description:
 * @date 2019/10/15 12:16
 */
public class InfantryGoAheadCommand implements Command {
    private Infantry infantry;

    public InfantryGoAheadCommand(Infantry infantry) {
        this.infantry=infantry;
    }

    @Override
    public void execute() {
        System.out.println("下令让步兵前进");
        infantry.goAhead();
    }
}
