package jp.ac.uryukyu.ie.e235736;


import java.util.ArrayList;
import java.util.Scanner;

public class CommandSelector {
    ArrayList<String> commands;
    Scanner scanner;

    public CommandSelector() {
        scanner = new Scanner(System.in);
        commands = new ArrayList<>();
    }

    public void addCommand(String command_name) {
        commands.add(command_name);
    }

    public void remCommand(int number){
        commands.remove(number);
    }
    public void clearCommands() {
        commands.clear();

    }

    
    public int waitForUsersCommand(String prompt) {
        var index = 0;
        System.out.println(prompt);
        for(var command : commands) { 
            System.out.println(index + ":" + command);
            index += 1;
        }
        
       
        while(true) {
            int target_index = scanner.nextInt();

            if (target_index >= 0 && target_index < commands.size()) {
                return target_index;
            }
        }        
    }
}





