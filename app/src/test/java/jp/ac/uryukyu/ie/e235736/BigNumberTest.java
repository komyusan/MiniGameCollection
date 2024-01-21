package jp.ac.uryukyu.ie.e235736;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class BigNumberTest {
    @AfterEach
    void restoreSystemIn() {
        System.setIn(System.in);
    }

    @Test
    void playGame(){
        String input = "0\n0\n0\n0\n0\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        BigNumber bigNumber = new BigNumber("数字が大きい方が勝ちゲーム");
        bigNumber.playGame("プレイヤー");
       
        assertEquals(0,bigNumber.enemyCards.size());
        System.setIn(System.in);
        
    }
}
