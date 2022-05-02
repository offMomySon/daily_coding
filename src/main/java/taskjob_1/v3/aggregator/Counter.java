package taskjob_1.v3.aggregator;

public class Counter {
    private int value = 0;

    public void increase(){
        value +=1;
    }

    public int getValueAsView() {
        return value;
    }
}
