package jp.ac.uryukyu.ie.e235736;

import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * CommandSelectorクラス
 * プログラミング演習2-10のコードを参考にした
 * 学外に講義資料が流れる危険があるかもしれないと考えたためリンクはレポートのみに記述する
 * 参考コードと違っている部分は一つ目がremCommandメソッド
 * 二つ目が例外処理をするためwaitForUserCommandメソッドからretCommandメソッドを派生させた点
 */
public class CommandSelector {
    ArrayList<String> commands;
    Scanner scanner;

    /**
     * CommandSelectorコンストラクタ
     * scannerの準備と表示するコマンドリストの準備をする
     * 何も引数を受け取らない
     */
    public CommandSelector() {
        scanner = new Scanner(System.in);
        commands = new ArrayList<>();
    }

    /**
     * addCommandメソッド
     * コマンドリストに引数を追加する
     * @param command_name String型:追加するコマンド名
     */
    public void addCommand(String command_name) {
        commands.add(command_name);
    }

    /**
     * remCommandメソッド
     * 引数をインデックスとして受け取りコマンドリストから削除する
     * @param number int型:削除するコマンドのインデックス
     */
    public void remCommand(int number){
        commands.remove(number);
    }

    /**
     * clearCommandsメソッド
     * コマンドリストを空にする
     * 何も引数を受け取らない
     */
    public void clearCommands() {
        commands.clear();

    }

    /**
     * waitForUsersCommandメソッド
     * プレイヤーへの指示とコマンドを表示
     * retuCommandメソッドを通じてプレイヤーの選択を返す
     * @param prompt String型:プレイヤーへの指示文
     * @return int型:プレイヤーの選択
     */
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

    /**
     * retuCommandメソッド
     * プレイヤーの選択が範囲外や文字列になってないか確認し返す
     * 何も引数を受け取らない
     * @throws InputMismatchException が発生する可能性があり，その際にはプレイヤーに再入力させる
     * @return int型:プレイヤーの選択
     */
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