package taskjob_1;

public class CreateFailCounter {
    private static int createFailCount = 0;

    public void increase(){
        createFailCount+=1;
    }

    public int getCount(){
        return createFailCount;
    }
}
