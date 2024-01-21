package jp.ac.uryukyu.ie.e235736;

import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * CommandSelectorクラス
 * プログラミング演習2-10のコードを参考にした
 * 学外に講義資料が流れる危険性があるためリンクは省略する
 * 参考コードと違っている部分は一つ目がremCommandメソッド
 * 二つ目が例外処理のをするためwaitForUserCommandメソッドからretCommandメソッドを派生させた
 */
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
        int target_index = this.retuCommand();
        return target_index;
    }

    public int retuCommand(){
        while(true) {
            try {
                int target_index = scanner.nextInt();
                if (target_index >= 0 && target_index < commands.size()) {
                    return target_index;
                }else{
                    System.out.println("表示されていないコマンド以外は入力しないで下さい");
                    int target_index_modified = this.retuCommand();
                    return target_index_modified;
                }
            } catch (InputMismatchException e) {
                System.out.println("表示されていないコマンド以外は入力しないで下さい");
                scanner.next();//間違った入力を読み飛ばす
            }
        }  
    }
}





