package taskjob_1.v3.result;

import lombok.NonNull;
import taskjob_1.v3.aggregator.Counter;

public class CreateFailResult implements Result{
    private final static String format = "TASK 생성 실패: %s";
    private final Counter createFailCounter;

    public CreateFailResult(@NonNull Counter createFailCounter) {
        this.createFailCounter = createFailCounter;
    }

    public void print(){
        String result = String.format(format, createFailCounter.getValueAsView());
        System.out.println(result);
    }
}
