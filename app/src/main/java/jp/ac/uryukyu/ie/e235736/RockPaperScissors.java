package jp.ac.uryukyu.ie.e235736;
import java.util.ArrayList;
import java.util.Random;
public class RockPaperScissors extends MiniGame{
    ArrayList<String> handSigns;
    public RockPaperScissors(String name){
        super(name);
        handSigns = new ArrayList<>();
        handSigns.add("グー");
        handSigns.add("チョキ");
        handSigns.add("パー");
    }

    Random rand=new Random();

    @Override
    public void playGame(String playerName){
        int count = 0;
        var commandSelector = new CommandSelector();
        System.out.println("全部で3回戦します");
        System.out.println("相手は私の息子です");
        commandSelector.clearCommands();
        for(var handSign: handSigns){
            commandSelector.addCommand(handSign);
        }
        for(int i=0;i<3;i++){
            count++;
            String enemyJankenNumber = handSigns.get(rand.nextInt(handSigns.size()));
            System.out.println(count+"回戦です");
            var playerJankenNumber = commandSelector.waitForUsersCommand("何を出しますか");
            System.out.println(playerName+"さんは"+handSigns.get(playerJankenNumber)+"を出しました！");
            System.out.println("私の息子は"+enemyJankenNumber+"を出しました！");
            if(handSigns.get(playerJankenNumber).equals("グー")){
                switch (enemyJankenNumber) {
                    case "グー":
                        System.out.println("あいこです");
                        break;
                    case "チョキ":
                        System.out.println(playerName+"さんの勝ちです");
                        break;
                    case "パー":
                    System.out.println("私の息子の勝ちです");
                        break;
                }
            }
            if(handSigns.get(playerJankenNumber).equals("チョキ")){
                switch (enemyJankenNumber) {
                    case "グー":
                        System.out.println("私の息子の勝ちです");
                        break;
                    case "チョキ":
                        System.out.println("あいこです");
                        break;
                    case "パー":
                        System.out.println(playerName+"さんの勝ちです");
                        break;
                }
            }
            if(handSigns.get(playerJankenNumber).equals("パー")){
                switch (enemyJankenNumber) {
                    case "グー":
                        System.out.println(playerName+"さんの勝ちです");
                        break;
                    case "チョキ":
                        System.out.println("私の息子の勝ちです");
                        break;
                    case "パー":
                        System.out.println("あいこです");
                        break;
                }

            }
        }//50行以内になるよう短くする
        //ポイントは一旦ほっとく
        
        
        
    }


}
