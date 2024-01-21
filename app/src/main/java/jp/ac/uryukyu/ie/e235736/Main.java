package jp.ac.uryukyu.ie.e235736;

/**
 * Mainクラス
 * ミニゲーム集を実行する
 * @author　e235736
 */
public class Main {
    
    /**
     * mainメソッド
     * ミニゲーム集を実行する
     * @param args String[]:必要なし
     */
    public static void main(String[] args) {
        GameMaster gameMaster = new GameMaster();
        gameMaster.opening();
        for(int i=0;i<2;i++){
            gameMaster.selectGame();
        }
        gameMaster.ending();
    }
}
