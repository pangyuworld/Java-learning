package com.pang.command;

/**
 * @author pang
 * @version V1.0
 * @ClassName: InfantryAttackCommand
 * @Package com.pang.command
 * @description:
 * @date 2019/10/15 12:17
 */
public class InfantryAttackCommand implements Command {
    private Infantry infantry;

    public InfantryAttackCommand(Infantry infantry) {
        this.infantry=infantry;
    }

    @Override
    public void execute() {
        System.out.println("下令让步兵攻击敌军");
        infantry.attack();
    }
}
