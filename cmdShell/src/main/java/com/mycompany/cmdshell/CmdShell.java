/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.cmdshell;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author IBN SAEED
 */
public class CmdShell {
    NoParameter p0 = new NoParameter();
    OneParameter p1 = new OneParameter();
    TwoParameter p2 = new TwoParameter();

    public static void main(String[] args) {
        CmdShell command = new CmdShell();

        do {
            System.out.print(System.getProperty("user.dir") + ">");
            Scanner input = new Scanner(System.in);
            String cmd = input.nextLine();
            if(cmd.contains("|")){
                String[] commands;
                String commandOne, commandTwo;
                commands =  cmd.split("\\|");
                commandOne = commands[0];
                commandTwo = commands[1];
                command.checkCommand(commandOne);
                command.checkCommand(commandTwo);
            }
            else
            	command.checkCommand(cmd);
        } while(true);

    }
    public void checkCommand(String cmd){
        String[] params;
        params =  cmd.split("\\s+");
        String realCmd = params[0];
        if(("clear").equals(realCmd) || ("pwd").equals(realCmd) || ("exit").equals(realCmd)
                || ("ls").equals(realCmd) || ("date").equals(realCmd))
            p0.executeCommand(cmd);
        else if(("cd").equals(realCmd) || ("mkdir").equals(realCmd) || ("rmdir").equals(realCmd)
                || ("cat").equals(realCmd) || ("more").equals(realCmd) || ("args").equals(realCmd)
                || ("?").equals(realCmd)|| ("rm").equals(realCmd))
            p1.executeCommand(cmd);
        else if(("cp").equals(realCmd) || ("mv").equals(realCmd))
            p2.executeCommand(cmd);
    }

}
