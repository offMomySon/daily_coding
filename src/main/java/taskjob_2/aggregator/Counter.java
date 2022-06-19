package taskjob_2.aggregator;

/**
 * 특정 횟수를 세는 역할
 */
public class Counter {
    private int value;

    public void increase(){
        value++;
    }

    public int getValue(){
        return value;
    }
}
