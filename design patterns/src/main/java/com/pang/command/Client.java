package com.pang.command;

/**
 * @author pang
 * @version V1.0
 * @ClassName: Client
 * @Package com.pang.command
 * @description:
 * @date 2019/10/15 13:07
 */
public class Client {
    public static void main(String... args) {
        Archer archer = new Archer();
        Infantry infantry = new Infantry();

        Commander commander = new Commander();

        commander.setCommands(0, new ArcherGoAheadCommand(archer), new ArcherAttackCommand(archer), new ArcherRetreatCommand(archer));
        commander.setCommands(1, new InfantryGoAheadCommand(infantry), new InfantryAttackCommand(infantry), new InfantryRetreatCommand(infantry));

        commander.executeGoAheadCommand(0);
        commander.executeAttackCommand(0);
        commander.executeGoAheadCommand(1);
        commander.executeAttackCommand(1);
        commander.executeAllRetreat();
    }
}
