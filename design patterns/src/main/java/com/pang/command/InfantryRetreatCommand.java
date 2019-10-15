package com.pang.command;

/**
 * @author pang
 * @version V1.0
 * @ClassName: InfantryRetreatCommand
 * @Package com.pang.command
 * @description:
 * @date 2019/10/15 12:18
 */
public class InfantryRetreatCommand implements Command {
    private Infantry infantry;

    public InfantryRetreatCommand(Infantry infantry) {
        this.infantry=infantry;
    }

    @Override
    public void execute() {
        System.out.println("下令让步兵撤退");
        infantry.retreat();
    }
}
