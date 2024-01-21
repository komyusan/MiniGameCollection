package jp.ac.uryukyu.ie.e235736;
import java.util.ArrayList;
import java.util.Random;

public class BigNumber extends MiniGame{
    ArrayList<String> cards;
    ArrayList<Integer> enemyCards;
    public BigNumber(String name){
        super(name);
        cards =new ArrayList<>();
        for(int i=0;i<=4;i++){
            cards.add(String.valueOf(i));
        }
        enemyCards = new ArrayList<>();
        for(int i=0;i<=4;i++){
            enemyCards.add(i);
        }
    }

    Random rand=new Random();

    @Override
    public void playGame(String playerName){
        int gameCount =0;
        int vicCount = 0;
        int loCount = 0;
        int draCount = 0;
        var commandselector = new CommandSelector();
        commandselector.clearCommands();
        for(var card: cards){
            commandselector.addCommand(card+"を出す");
        }
        this.explain(playerName);
        for(int i=0;i<5;i++){
            gameCount++;
            int randIndex = rand.nextInt(enemyCards.size());
            int enemyNumber = enemyCards.get(randIndex);
            System.out.println(gameCount+"ターン目です");
            var playerNumber = commandselector.waitForUsersCommand("何を出しますか？");
            System.out.println(playerName+"さんは"+playerNumber+"を出しました！");
            System.out.println("私の息子は"+enemyNumber+"を出しました！");
            if(playerNumber>enemyNumber){
                System.out.println(playerName+"さんの勝利です");
                vicCount++;
            }else{
               if(playerNumber<enemyNumber){
                System.out.println("私の息子の勝ちです");
                loCount++;
               }else{
                System.out.println("引き分けです");
                draCount++;
               }
            }
            commandselector.remCommand(playerNumber);
            enemyCards.remove(randIndex);
        }
        System.out.println("最終結果は，"+playerName+"さんが");
        System.out.println(vicCount+"勝"+loCount+"敗"+draCount+"引き分けです");
    }

    public void explain(String playerName){
        System.out.println("ルール説明をします");
        System.out.println(playerName+"さんには私の息子と勝負してもらいます");
        System.out.println("二人には0~4の数字が手札としてあります");
        System.out.println("そして二人は毎ターンその中から1枚選択してもらいます");
        System.out.println("このとき数字の大きい方がそのターンの勝者です");
        System.out.println("一つの手札は一度しか使えず,5ターンの勝負をします");
        System.out.println("では始めます");
    }

    
}
