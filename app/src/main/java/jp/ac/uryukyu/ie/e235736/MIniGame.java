package jp.ac.uryukyu.ie.e235736;

public class MiniGame {
    private String name;
    public MiniGame(String name){
        this.name=name;
    }

    public void startGame(){
        System.out.println(this.name+"を開始します");
    }

    public String getName() {
        return name;
    }

}
