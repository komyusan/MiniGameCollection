package jp.ac.uryukyu.ie.e235736;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * BigNumberTestクラス
 * BigNumberクラスのテストを行う
 * @author　e235736
 */
public class BigNumberTest {
    /**
     * restoreSystemInメソッド
     * System.inをテストメソッドの後に元の状態にリセットする
     * 何も引数を受け取らない
     */
    @AfterEach
    void restoreSystemIn() {
        System.setIn(System.in);
    }

    /**
     * playGameメソッド
     * テストメソッドであり，数字が大きい方が勝ちゲーム終了時，相手の手札が0枚であることをテストする
     * 何も引数を受け取らない
     */
    @Test
    void playGameTest(){
        String input = "0\n0\n0\n0\n0\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        BigNumber bigNumber = new BigNumber("数字が大きい方が勝ちゲーム");
        bigNumber.playGame("プレイヤー");
       
        assertEquals(0,bigNumber.enemyCards.size());
        System.setIn(System.in);
        
    }
}
