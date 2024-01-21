package jp.ac.uryukyu.ie.e235736;
import java.util.ArrayList;
import java.util.Scanner;
public class GameMaster {
    
    Scanner scanner;
    private String playerName;
    private CommandSelector commandSelector = new CommandSelector();
    private int gameCount = 0;
    private ArrayList<MiniGame> minigames = new ArrayList<>();

    public GameMaster(){
        scanner = new Scanner(System.in);
        MiniGame janken = new RockPaperScissors("じゃんけん");
        minigames.add(janken);
        MiniGame tasizan = new CalcNumber("足し算ゲーム");
        minigames.add(tasizan);
        MiniGame bigN = new BigNumber("数字大きい方が勝ちゲーム");
        minigames.add(bigN);
    }

    public void opening(){
        System.out.println("初めまして，これからミニゲームをしましょう！");
        System.out.println("あなたの名前を教えて下さい");
        playerName = scanner.next();
        System.out.println(playerName+"さん，よろしくお願いします");
        System.out.println("今から2つのミニゲームをします");
    }

    public void selectGame(){
        commandSelector.clearCommands();
        for(var game: minigames){
            commandSelector.addCommand(game.getName());
        }
        gameCount++;
        var gameNumber = commandSelector.waitForUsersCommand(gameCount+"回目のゲームはどれにしますか？");
        minigames.get(gameNumber).startGame();
        minigames.get(gameNumber).playGame(playerName);
        minigames.remove(gameNumber);
    }

    public void ending(){
        System.out.println("以上でミニゲームは終わりです");
        System.out.println(playerName+"さんと過ごせて楽しかったです");
        System.out.println("息子も楽しかったようで何よりです");
        System.out.println("またどこかで！");
    }

}
