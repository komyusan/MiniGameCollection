package jp.ac.uryukyu.ie.e235736;
import java.util.Random;
import java.util.Scanner;

public class CalcNumber extends MiniGame{
    Scanner scanner;
    public CalcNumber(String name){
        super(name);
        scanner = new Scanner(System.in);
    }

    Random rand=new Random();

    @Override
    public void playGame(String playerName){
        System.out.println("ルール説明をします");
        System.out.println("私が3つの数字を言いますので,それらを全て足し合わせて下さい");
        System.out.println("全部で2回戦します");
        for(int i=0;i<2;i++){
            int count =i+1;
            System.out.println(count+"回戦です");
            int number1 = rand.nextInt(1000);
            int number2 = rand.nextInt(1000);
            int number3 = rand.nextInt(1000);
            int total = number1+number2+number3;
            System.out.println(number1+","+number2+","+number3);
            System.out.println("これらを足し合わせて下さい");
            this.calcJudge(total);
        }
    }

    public void calcJudge(int total){
        while(true) {
            int playerAnswer = scanner.nextInt();
            if (playerAnswer==total) {
                System.out.println("正解です！");
                break;
            }else{
                System.out.println("不正解です");
                System.out.println("正解は"+total+"でした");
                break;
            }
        }  
    }

}