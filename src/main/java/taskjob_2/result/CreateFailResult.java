package taskjob_2.result;

import java.text.MessageFormat;
import lombok.NonNull;
import taskjob_2.Counter;

public class CreateFailResult implements ResultPrinter {
    private final Counter counter;

    public CreateFailResult(@NonNull Counter counter) {
        this.counter = counter;
    }

    @Override
    public void print() {
        String result = MessageFormat.format("TASK 생성 실패: {0}", counter.getValue());
        System.out.println(result);
    }
}
