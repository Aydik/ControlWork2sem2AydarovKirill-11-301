import org.example.MyThread;
import org.junit.jupiter.api.*;

public class СheckCorrectCount {
    @Test
    public void countOneTest1() {
        Assertions.assertEquals(MyThread.countOne(new byte[] {1, 1, 1, 1, 1}), 1+1+1+1+1);
    }
    @Test
    public void countOneTestEmpty() {
        Assertions.assertEquals(MyThread.countOne(new byte[] {}), 0);
    }
    @Test
    public void countOneTestMinus() {
        Assertions.assertEquals(MyThread.countOne(new byte[] {-1, -1, -1, -1, -1}), 8+8+8+8+8);
    }
    @Test
    public void countOneTestRandom() {
        Assertions.assertEquals(MyThread.countOne(new byte[] {15, 4, -1, 8, -20}), 4+1+8+1+5);
    }

}
