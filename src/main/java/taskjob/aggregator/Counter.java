package taskjob.aggregator;

public class Counter {
    private int count;

    public Counter(int start) {
        this.count = start;
    }

    public void increase(){
        count++;
    }

    public String getCountAsView(){
        return Integer.toString(count);
    }
}
