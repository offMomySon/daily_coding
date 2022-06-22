package taskjob_2.aggregator;

/**
 * 특정 횟수를 세는 역할
 *
 * ? 완전히 데이터는 아니지만, 데이터의 성격이 있는것 같다.
 */
public class Counter {
    private int value;

    public void increase(){
        value++;
    }

    public String getValueAsView(){
        return Integer.toString(value);
    }
}
