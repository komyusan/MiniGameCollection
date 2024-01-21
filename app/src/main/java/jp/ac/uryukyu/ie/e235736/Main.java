package jp.ac.uryukyu.ie.e235736;

public class Main {
    public static void main(String[] args) {
        GameMaster gameMaster = new GameMaster();
        gameMaster.opening();
        for(int i=0;i<2;i++){
            gameMaster.selectGame();
        }
        gameMaster.ending();
    }
}
