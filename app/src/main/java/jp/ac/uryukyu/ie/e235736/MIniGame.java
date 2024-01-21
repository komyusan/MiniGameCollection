package jp.ac.uryukyu.ie.e235736;

/**
 * MiniGameクラス
 * 抽象クラスであり，各種ミニゲームクラスから継承される
 * 名前を持ち，開始宣言と実際にゲームを開始することができる
 * @author　e235736
 */
public abstract class MiniGame {
    private String name;

    /**
     * MiniGameコンストラクタ
     * ゲーム名を設定する
     * @param name String型:ゲーム名
     */
    public MiniGame(String name){
        this.name=name;
    }

    /**
     * startGameメソッド
     * ゲーム開始宣言をする
     * 何も引数を受け取らない
     */
    public void startGame(){
        System.out.println(this.name+"を開始します");
    }

    /**
     * playGameメソッド
     * 抽象メソッドであり，子クラスによって機能は異なる
     * @param playerName String型:プレイヤー名
     */
    abstract void playGame(String playerName);

    /**
     * getNameメソッド
     * nameのgetter
     * @return ゲーム名を返す
     */
    public String getName() {
        return name;
    }

}
