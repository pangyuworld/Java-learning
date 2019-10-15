package com.pang.command;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Commander
 * @Package com.pang.command
 * @description: 指挥官
 * @date 2019/10/15 12:23
 */
public class Commander {
    /**
     * 前进指令集
     */
    private Command[] goAheadCommands;
    /**
     * 攻击指令集
     */
    private Command[] attackCommands;
    /**
     * 撤退指令集
     */
    private Command[] retreatCommands;

    public Commander() {
        goAheadCommands = new Command[5];
        attackCommands = new Command[5];
        retreatCommands = new Command[5];
        for (int i = 0; i < 5; i++) {
            goAheadCommands[i] = new NoCommand();
            attackCommands[i] = new NoCommand();
            retreatCommands[i] = new NoCommand();
        }
    }

    /**
     * 设置命令
     *
     * @param id             命令编号
     * @param goAheadCommand 前进命令
     * @param attackCommand  攻击命令
     * @param retreatCommand 撤回命令
     */
    public void setCommands(int id, Command goAheadCommand, Command attackCommand, Command retreatCommand) {
        this.goAheadCommands[id] = goAheadCommand;
        this.attackCommands[id] = attackCommand;
        this.retreatCommands[id] = retreatCommand;
    }

    /**
     * 执行前进指令
     *
     * @param id 命令编号
     */
    public void executeGoAheadCommand(int id) {
        this.goAheadCommands[id].execute();
    }

    /**
     * 执行进攻指令
     *
     * @param id 命令编号
     */
    public void executeAttackCommand(int id) {
        this.attackCommands[id].execute();
    }

    /**
     * 执行前进指令
     *
     * @param id 命令编号
     */
    public void executeRetreatCommands(int id) {
        this.retreatCommands[id].execute();
    }

    /**
     * 全军前进
     */
    public void executeAllGoHead() {
        for (Command c : this.goAheadCommands) {
            c.execute();
        }
    }

    /**
     * 全军攻击
     */
    public void executeAllAttack() {
        for (Command c : this.attackCommands) {
            c.execute();
        }
    }

    /**
     * 全军撤退
     */
    public void executeAllRetreat() {
        for (Command c : this.retreatCommands) {
            c.execute();
        }
    }
}
